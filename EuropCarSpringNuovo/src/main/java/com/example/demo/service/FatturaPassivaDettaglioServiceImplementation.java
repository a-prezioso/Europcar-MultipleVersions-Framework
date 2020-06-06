package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FatturaPassivaDettaglio;
import com.example.demo.repository.FatturaPassivaDettaglioRepository;

@Service
@Transactional
public class FatturaPassivaDettaglioServiceImplementation implements FatturaPassivaDettaglioService {

	@Autowired
	FatturaPassivaDettaglioRepository fatrep;

	@Override
	public List<FatturaPassivaDettaglio> getAllFatturePassiveDettaglio() {
		return (List<FatturaPassivaDettaglio>) fatrep.findAll();
	}

	@Override
	public FatturaPassivaDettaglio getFatturaPassivaDettaglioById(Integer idFatturaPassiva) {
		return fatrep.findById(idFatturaPassiva).get();
	}

	@Override
	public FatturaPassivaDettaglio saveOrUpdate(FatturaPassivaDettaglio oFatturaPassiva) {
		return fatrep.save(oFatturaPassiva);
	}

	@Override
	public void deleteFatturaPassivaDettaglio(Integer idFatturaPassiva) {
		fatrep.deleteById(idFatturaPassiva);
	}
	
	@Override
	public List<FatturaPassivaDettaglio> getFatturePerPreventivo(Integer idpreventivo, Integer idAnno) {
		return fatrep.fatturePerPreventivo(idpreventivo, idAnno);
	}

	@Override
	public List<FatturaPassivaDettaglio> getFatturePerSottoCategoria(Integer idsottocategoria, Integer idAnno) {
		return fatrep.fatturePerSottoCategoria(idsottocategoria, idAnno);
	}

}
