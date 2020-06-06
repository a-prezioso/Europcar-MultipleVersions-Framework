package importerstrategy;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;

import generation.FatturaElettronica;
import generation.FatturaElettronicaBody;
import generation.FatturaElettronicaHeader;
import model.dao.AliquotaIvaService;
import model.dao.FatturaPassivaService;
import model.dao.FornitoreService;
import model.session.AliquotaIva;
import model.session.FatturaPassiva;
import model.session.FatturaPassivaDettaglio;
import model.session.Fornitore;

public class ImporterStrategyFatturePassive {
	byte[] bytesArray;
	private static final String CODIFICA_DEFAULT = "UTF-8";

	private static final String HEADER_START = "<FatturaElettronicaHeader>";
	private static final String HEADER_DELIMITER = "</FatturaElettronicaHeader>";

	private static final String BODY_START = "<FatturaElettronicaBody>";
	private static final String BODY_DELIMITER = "</FatturaElettronicaBody>";
	private Date datainizio;
	private Date datafine;

	public ImporterStrategyFatturePassive(File fileUploaded, Date datainizio, Date datafine) {
		convertToByteArray(fileUploaded);
		this.datainizio = datainizio;
		this.datafine = datafine;
	}

	private void convertToByteArray(File file) {
		this.bytesArray = new byte[(int) file.length()];

		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			fis.read(this.bytesArray); // read file into bytes[]
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("File non trovato:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Errore I/O: " + e.getMessage());
		}
	}

	public ArrayList<FatturaElettronicaHeader> generaHeader() {
		return generaFatturaPassivaObj(HEADER_START, HEADER_DELIMITER, FatturaElettronicaHeader.class);
	}

	public ArrayList<FatturaElettronicaBody> generaBody() {
		return generaFatturaPassivaObj(BODY_START, BODY_DELIMITER, FatturaElettronicaBody.class);
	}

	@SuppressWarnings("rawtypes")
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
					fatturaDaProcessare = StringUtils.substring(fatturaDaProcessare, StringUtils.indexOf(fatturaDaProcessare, start)) + delimiter;
					
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

	@SuppressWarnings("unused")
	public String importaFatture() throws Exception {
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
			if (datafattura.getTime() >= this.datainizio.getTime()
					&& datafattura.getTime() <= this.datafine.getTime()) {
				FatturaPassiva oFatturaPassiva = new FatturaPassiva();
				oFatturaPassiva.setData(lista.get(i).getBody().getDatiGenerali().getDatiGeneraliDocumento().getData()
						.toGregorianCalendar().getTime());
				oFatturaPassiva.setOfornitore(this.processaFornitore());
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
				oFatturaPassiva.getDettagli().add(oDettaglio);
				FatturaPassivaService oFatturaPassivaService = new FatturaPassivaService();
				oFatturaPassivaService.persist(oFatturaPassiva);
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

	private Fornitore processaFornitore() throws Exception {
		ArrayList<FatturaElettronicaHeader> header = generaHeader();
		FornitoreService oFornitoreService = new FornitoreService();
		Fornitore result = null;
		for (int i = 0; i < header.size(); i++) {
			if ((oFornitoreService.findFornitorePerPartitaIva(String.valueOf(
					header.get(i).getCessionarioCommittente().getDatiAnagrafici().getCodiceFiscale())) != null)) {
				Fornitore oFornitore = oFornitoreService.findFornitorePerPartitaIva(String
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
				oFornitoreService.persist(oFornitore);
				result = oFornitore;
			}
		}
		return result;
	}

	private AliquotaIva processaAliquota() throws Exception {
		ArrayList<FatturaElettronicaBody> body = generaBody();
		AliquotaIvaService oAliquota = new AliquotaIvaService();
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
				oAliquota.persist(oAliquotaIva);
				result = oAliquotaIva;
			}
		}
		return result;
	}
}