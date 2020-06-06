package com.example.demo.service;

import java.util.List;

import com.example.demo.model.OrdineDiAcquistoDettaglio;

public interface OrdineAcquistoDettaglioService {
	
	public List<OrdineDiAcquistoDettaglio> getAllFatturePassiveDettaglio();
	
	public OrdineDiAcquistoDettaglio getOrdineAcquistoDettaglioById(Integer idOrdineAcquisto);
	
	public OrdineDiAcquistoDettaglio saveOrUpdate(OrdineDiAcquistoDettaglio oOrdineAcquisto);
	
	public void deleteOrdineAcquistoDettaglio(Integer idOrdineAcquisto);

	List<OrdineDiAcquistoDettaglio> getOrdiniPerSottoCategoria(int idsottocategoria, Integer idAnno);
	
	public List<OrdineDiAcquistoDettaglio> getOrdiniPerProgetto(Integer idprogetto, Integer idAnno);

}