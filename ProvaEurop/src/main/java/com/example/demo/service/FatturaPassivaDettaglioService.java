package com.example.demo.service;

import java.util.List;

import com.example.demo.model.FatturaPassivaDettaglio;

public interface FatturaPassivaDettaglioService {
	
	public List<FatturaPassivaDettaglio> getAllFatturePassiveDettaglio();
	
	public FatturaPassivaDettaglio getFatturaPassivaDettaglioById(Integer idFatturaPassiva);
	
	public FatturaPassivaDettaglio saveOrUpdate(FatturaPassivaDettaglio oFatturaPassiva);
	
	public void deleteFatturaPassivaDettaglio(Integer idFatturaPassiva);
	
	public List<FatturaPassivaDettaglio> getFatturePerSottoCategoria(Integer idsottocategoria, Integer idAnno);

	public List<FatturaPassivaDettaglio> getFatturePerPreventivo(Integer idpreventivo, Integer idAnno);


}
