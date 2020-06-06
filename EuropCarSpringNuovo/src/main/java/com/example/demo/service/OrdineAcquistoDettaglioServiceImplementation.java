package com.example.demo.service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrdineDiAcquistoDettaglio;
import com.example.demo.repository.OrdineAcquistoDettaglioRepository;

@Service
@Transactional
public class OrdineAcquistoDettaglioServiceImplementation implements OrdineAcquistoDettaglioService {

	@Autowired
	OrdineAcquistoDettaglioRepository orddetrep;

	@Override
	public List<OrdineDiAcquistoDettaglio> getAllFatturePassiveDettaglio() {
		return (List<OrdineDiAcquistoDettaglio>) orddetrep.findAll();
	}

	@Override
	public OrdineDiAcquistoDettaglio getOrdineAcquistoDettaglioById(Integer idOrdineAcquisto) {
		return orddetrep.findById(idOrdineAcquisto).get();
	}

	@Override
	public OrdineDiAcquistoDettaglio saveOrUpdate(OrdineDiAcquistoDettaglio oOrdineAcquisto) {
		return orddetrep.save(oOrdineAcquisto);
	}

	@Override
	public void deleteOrdineAcquistoDettaglio(Integer idOrdineAcquisto) {
		orddetrep.deleteById(idOrdineAcquisto);
	}

	@Override
	public List<OrdineDiAcquistoDettaglio> getOrdiniPerSottoCategoria(int idsottocategoria, Integer idAnno) {
		return orddetrep.ordiniPerSottoCategoria(idsottocategoria, idAnno);
	}

	@Override
	public List<OrdineDiAcquistoDettaglio> getOrdiniPerProgetto(Integer idprogetto, Integer idAnno) {
		return orddetrep.ordiniPerProgetto(idprogetto, idAnno);
	}
	
}
