package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Previsione;
import com.example.demo.repository.PrevisioneRepository;

@Service
@Transactional
public class PrevisioneServiceImplementation implements PrevisioneService {
	
	@Autowired
	PrevisioneRepository prerep;

	@Override
	public List<Previsione> getAllPrevisionali() {
		return (List<Previsione>) prerep.findAll();
	}

	@Override
	public Previsione getPrevisionaleById(Integer idPrevisionale) {
		return prerep.findById(idPrevisionale).get();
	}

	@Override
	public Previsione saveOrUpdate(Previsione oPrevisionale) {
		return prerep.save(oPrevisionale);
	}

	@Override
	public void deletePrevisionale(Integer idPrevisionale) {
		prerep.deleteById(idPrevisionale);
	}

	@Override
	public List<Previsione> getPrevisionaleByVend(Integer idvenditore) {
		return (List<Previsione>) prerep.getPrevisionaliByVend(idvenditore);
	}

}
