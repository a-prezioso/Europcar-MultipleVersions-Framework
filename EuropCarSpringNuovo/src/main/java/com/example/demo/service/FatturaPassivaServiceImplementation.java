package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FatturaPassiva;
import com.example.demo.repository.FatturaPassivaRepository;

@Service
@Transactional
public class FatturaPassivaServiceImplementation implements FatturaPassivaService {
	
	@Autowired
	FatturaPassivaRepository fatrep;

	@Override
	public List<FatturaPassiva> getAllFatturePassive() {
		return (List<FatturaPassiva>) fatrep.findAll();
	}

	@Override
	public FatturaPassiva getFatturaPassivaById(Integer idFatturaPassiva) {
		return fatrep.findById(idFatturaPassiva).get();
	}

	@Override
	public FatturaPassiva saveOrUpdate(FatturaPassiva oFatturaPassiva) {
		return fatrep.save(oFatturaPassiva);
	}

	@Override
	public void deleteFatturaPassiva(Integer idFatturaPassiva) {
		fatrep.deleteById(idFatturaPassiva);
	}

	@Override
	public List<FatturaPassiva> getFatturePerFornitore(Integer idFornitore, Integer idAnno) {
		return fatrep.fatturePerFornitore(idFornitore, idAnno);
	}
//



}
