package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Azienda;
import com.example.demo.repository.AziendaRepository;

@Service
@Transactional
public class AziendaServiceImplementation implements AziendaService {

	@Autowired
	AziendaRepository azirep;
	
	@Override
	public List<Azienda> getAllAziende() {
		return (List<Azienda>) azirep.findAll();
	}

	@Override
	public Azienda getAziendaById(Integer idAzienda) {
		return azirep.findById(idAzienda).get();
	}

	@Override
	public Azienda saveOrUpdate(Azienda oAzienda) {
		return azirep.save(oAzienda);
	}

	@Override
	public void deleteAzienda(Integer idAzienda) {
		azirep.deleteById(idAzienda);
	}



}
