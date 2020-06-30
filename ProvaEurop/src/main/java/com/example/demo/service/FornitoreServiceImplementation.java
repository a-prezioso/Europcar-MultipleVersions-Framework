package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fornitore;
import com.example.demo.repository.FornitoreRepository;

@Service
@Transactional
public class FornitoreServiceImplementation implements FornitoreService {
	
	@Autowired
	FornitoreRepository forrep;

	@Override
	public List<Fornitore> getAllFornitori() {
		return (List<Fornitore>) forrep.findAll();
	}

	@Override
	public Fornitore getFornitoreById(Integer idFornitore) {
		return forrep.findById(idFornitore).get();
	}

	@Override
	public Fornitore saveOrUpdate(Fornitore oFornitore) {
		return forrep.save(oFornitore);
	}

	@Override
	public void deleteFornitore(Integer idFornitore) {
		forrep.deleteById(idFornitore);
	}

	@Override
	public Fornitore findFornitorePerPartitaIva(String partitaiva) {
		return (Fornitore) forrep.getFornitoreByPartitaIva(partitaiva);
	}

}
