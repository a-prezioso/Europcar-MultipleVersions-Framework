package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Progetto;
import com.example.demo.repository.ProgettoRepository;

@Service
@Transactional
public class ProgettoServiceImplementation implements ProgettoService {

	@Autowired
	ProgettoRepository prorep;
	
	@Override
	public List<Progetto> getAllProgetti() {
		return (List<Progetto>) prorep.findAll();
	}

	@Override
	public Progetto getProgettoById(Integer idProgetto) {
		return prorep.findById(idProgetto).get();
	}

	@Override
	public Progetto saveOrUpdate(Progetto oProgetto) {
		return prorep.save(oProgetto);
	}

	@Override
	public void deleteProgetto(Integer idProgetto) {
		prorep.deleteById(idProgetto);
	}

}
