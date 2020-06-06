package com.example.demo.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.generation.FatturaElettronica;
import com.example.demo.generation.FatturaElettronicaBody;
import com.example.demo.generation.FatturaElettronicaHeader;
import com.example.demo.model.AliquotaIva;
import com.example.demo.model.FatturaPassiva;
import com.example.demo.model.FatturaPassivaDettaglio;
import com.example.demo.model.Fornitore;
import com.example.demo.service.AliquotaIvaService;
import com.example.demo.service.FatturaPassivaService;
import com.example.demo.service.FornitoreService;
import com.example.demo.service.PreventivoService;
import com.example.demo.service.SpesaInvestimentoService;
import com.example.demo.util.UDate;

@Controller
@RequestMapping(value = "/ImportaFatture")
public class ImportaFatture {

	@Autowired
	FatturaPassivaService fatser;

	@Autowired
	FornitoreService forser;

	@Autowired
	AliquotaIvaService oAliquota;
	
	@Autowired
	SpesaInvestimentoService spesaser;
	
	@Autowired
	PreventivoService preser;

	private String messaggio;
	private Date dateinizio;
	private Date datefine;
	byte[] bytesArray;
	private static final String CODIFICA_DEFAULT = "UTF-8";

	private static final String HEADER_START = "<FatturaElettronicaHeader>";
	private static final String HEADER_DELIMITER = "</FatturaElettronicaHeader>";

	private static final String BODY_START = "<FatturaElettronicaBody>";
	private static final String BODY_DELIMITER = "</FatturaElettronicaBody>";

	public byte[] getBytesArray() {
		return bytesArray;
	}

	public void setBytesArray(byte[] bytesArray) {
		this.bytesArray = bytesArray;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public Date getDateinizio() {
		return dateinizio;
	}

	public void setDateinizio(Date dateinizio) {
		this.dateinizio = dateinizio;
	}

	public Date getDatefine() {
		return datefine;
	}

	public void setDatefine(Date datefine) {
		this.datefine = datefine;
	}

	@GetMapping(value = "/Importa")
	public ModelAndView importaFatture() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/ImportaFatture/Importa");
		return model;
	}

	@PostMapping(value = "/Salva", consumes = "multipart/form-data")
	public ModelAndView salvaFatture(@RequestParam("datainizio") String datainizio,
			@RequestParam("datafine") String datafine, @RequestParam("multifile") MultipartFile multifile,
			RedirectAttributes red) throws Exception {
		this.dateinizio = UDate.estraiData(datainizio);
		this.datefine = UDate.estraiData(datafine);
		if (dateinizio != null && multifile != null) {
//			ImporterStrategyFatturePassive oImporto = new ImporterStrategyFatturePassive(multifile, dateinizio, datefine);
			convertToByteArray(multifile);
			messaggio = this.importaFattureOld();
			red.addFlashAttribute("message", "Fattura inserita correttamente");
			return new ModelAndView("redirect:/ImportaFatture/Importa");
		} else {
			red.addFlashAttribute("message", "inserire una fattura e/o entrambe le date per poter procedere");
			return new ModelAndView("redirect:/ImportaFatture/Importa");
		}
	}

	private void convertToByteArray(MultipartFile multifile) throws IOException {
		this.bytesArray = multifile.getBytes();

		InputStream fis;
		try {
			fis = new BufferedInputStream(multifile.getInputStream());
			fis.read(this.bytesArray); // read file into bytes[]
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("File non trovato:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Errore I/O: " + e.getMessage());
		}
	}

	private ArrayList generaFatturaPassivaObj(String start, String delimiter, Class classe) {
		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytesArray);
		Unmarshaller unmarshaller = null;
		JAXBContext jaxbContext;
		Scanner scanner = new Scanner(arrayInputStream, CODIFICA_DEFAULT);
		scanner.useDelimiter(delimiter);
		StringReader reader = null;
		ArrayList list = new ArrayList<>();
		try {
			jaxbContext = JAXBContext.newInstance(classe);
			unmarshaller = jaxbContext.createUnmarshaller();

			while (scanner.hasNext()) {
				String fatturaDaProcessare = scanner.next();
				if (StringUtils.contains(fatturaDaProcessare, start)) {
					fatturaDaProcessare = StringUtils.substring(fatturaDaProcessare,
							StringUtils.indexOf(fatturaDaProcessare, start)) + delimiter;

				}
				if (fatturaDaProcessare.startsWith(start)) {
					reader = new StringReader(fatturaDaProcessare);
					list.add(unmarshaller.unmarshal(reader));
				}
			}
			scanner.close();
			return list;
		} catch (JAXBException e) {
			System.out.println("Eccezione JAXB:" + e.getMessage());
		}
		scanner.close();
		return null;
	}

	public ArrayList<FatturaElettronicaHeader> generaHeader() {
		return generaFatturaPassivaObj(HEADER_START, HEADER_DELIMITER, FatturaElettronicaHeader.class);
	}

	public ArrayList<FatturaElettronicaBody> generaBody() {
		return generaFatturaPassivaObj(BODY_START, BODY_DELIMITER, FatturaElettronicaBody.class);
	}

	public String importaFattureOld() throws Exception {
		int contafatture = 0;
		String result = null;
		ArrayList<FatturaElettronicaHeader> header = generaHeader();
		ArrayList<FatturaElettronicaBody> body = generaBody();
		ArrayList<FatturaElettronica> lista = new ArrayList<FatturaElettronica>();
		for (int i = 0; i < header.size(); i++) {
			FatturaElettronica oFat = new FatturaElettronica();
			oFat.setBody(body.get(i));
			oFat.setHeader(header.get(i));
			lista.add(oFat);
		}
		for (int i = 0; i < lista.size(); i++) {
			Date datafattura = lista.get(i).getBody().getDatiGenerali().getDatiGeneraliDocumento().getData()
					.toGregorianCalendar().getTime();
//			Date dataInitial = this.datainizio.toGregorianCalendar().getTime();
//			Date dataFinish = this.datafine.toGregorianCalendar().getTime();
			if (datafattura.getTime() >= this.dateinizio.getTime()
					&& datafattura.getTime() <= this.datefine.getTime()) {

				FatturaPassiva oFatturaPassiva = new FatturaPassiva();
				String data2 = lista.get(i).getBody().getDatiGenerali().getDatiGeneraliDocumento().getData().toString();
//				String uscita1 = data2.substring(8);
//				String uscita2 = data2.substring(5, 7);
//				String uscita3 = data2.substring(0, 4);
//				
			    oFatturaPassiva.setData(data2);
			     
				oFatturaPassiva.setOfornitore(this.processaFornitore(header));
				oFatturaPassiva
						.setNumero(lista.get(i).getBody().getDatiGenerali().getDatiGeneraliDocumento().getNumero());
				oFatturaPassiva.setDescrizione(
						lista.get(i).getBody().getDatiGenerali().getDatiGeneraliDocumento().getTipoDocumento());
				FatturaPassivaDettaglio oDettaglio = new FatturaPassivaDettaglio(oFatturaPassiva);
				oDettaglio.setImporto(lista.get(i).getBody().getDatiGenerali().getDatiGeneraliDocumento()
						.getImportoTotaleDocumento());
				oDettaglio.setDettagliofattura(
						lista.get(i).getBody().getDatiBeniServizi().getDettaglioLinee().getDescrizione());
				oDettaglio.setOaliquota(this.processaAliquota());
				oDettaglio.setImportoPagato(lista.get(i).getBody().getDatiGenerali().getDatiGeneraliDocumento().getImportoTotaleDocumento());
				oDettaglio.setOpreventivo(preser.getPreventivoById(125));
				oDettaglio.setOspesainvestimento(spesaser.getSpesaInvestimentoById(7));
				oFatturaPassiva.getDettagli().add(oDettaglio);
				fatser.saveOrUpdate(oFatturaPassiva);
				contafatture++;
			}
		}
		if (contafatture < lista.size()) {
			result = "Le Fatture inserite sono:" + contafatture + " ,quelle non inserite sono:"
					+ (lista.size() - contafatture);
		} else
			result = "Le Fatture inserite sono:" + contafatture;
		return result;
	}

	private AliquotaIva processaAliquota() throws Exception {
		ArrayList<FatturaElettronicaBody> body = generaBody();
		AliquotaIva result = null;
		for (int i = 0; i < body.size(); i++) {
			if (oAliquota.findAliquotaPerAliquota(
					body.get(i).getDatiBeniServizi().getDettaglioLinee().getAliquotaIVA()) != null) {
				AliquotaIva oAliquotaIva = oAliquota
						.findAliquotaPerAliquota(body.get(i).getDatiBeniServizi().getDettaglioLinee().getAliquotaIVA());
				result = oAliquotaIva;
			} else {
				AliquotaIva oAliquotaIva = new AliquotaIva();
				oAliquotaIva.setAliquota((int) body.get(i).getDatiBeniServizi().getDettaglioLinee().getAliquotaIVA());
				oAliquotaIva.setDescrizione("Test");
				oAliquota.saveOrUpdate(oAliquotaIva);
				result = oAliquotaIva;
			}
		}
		return result;
	}

	public Fornitore processaFornitore(ArrayList<FatturaElettronicaHeader> header) throws Exception {
		Fornitore result = null;
		for (int i = 0; i < header.size(); i++) {

			if (forser.findFornitorePerPartitaIva(String.valueOf(
					header.get(i).getCessionarioCommittente().getDatiAnagrafici().getCodiceFiscale())) != null) {
				Fornitore oFornitore = forser.findFornitorePerPartitaIva(String
						.valueOf(header.get(i).getCessionarioCommittente().getDatiAnagrafici().getCodiceFiscale()));
				result = oFornitore;

			} else {
				Fornitore oFornitore = new Fornitore();
				oFornitore.setCap(String.valueOf(header.get(i).getCessionarioCommittente().getSede().getCAP()));
				oFornitore.setCitta(header.get(i).getCessionarioCommittente().getSede().getComune());
				oFornitore.setIndirizzo(header.get(i).getCessionarioCommittente().getSede().getIndirizzo());
				oFornitore.setPartitaiva(String
						.valueOf(header.get(i).getCessionarioCommittente().getDatiAnagrafici().getCodiceFiscale()));
				oFornitore.setProvincia(header.get(i).getCessionarioCommittente().getSede().getProvincia());
				oFornitore.setRagionesociale(header.get(i).getCessionarioCommittente().getDatiAnagrafici()
						.getAnagrafica().getDenominazione());
				forser.saveOrUpdate(oFornitore);

				result = oFornitore;
			}
		}
		return result;
	}

}
