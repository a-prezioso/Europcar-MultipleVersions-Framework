package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Gruppo;
import com.example.demo.repository.GruppoRepository;

@Service
@Transactional
public class GruppoServiceImplementation implements GruppoService {

	@Autowired
	GruppoRepository gruprep;
	
	@Override
	public List<Gruppo> getAllGruppi() {
		return (List<Gruppo>) gruprep.findAll();
	}

	@Override
	public Gruppo getGruppoById(Integer idGruppo) {
		return gruprep.findById(idGruppo).get();
	}

	@Override
	public Gruppo saveOrUpdate(Gruppo oGruppo) {
		return gruprep.save(oGruppo);
	}

	@Override
	public void deleteGruppo(Integer idGruppo) {
		gruprep.deleteById(idGruppo);
	}


}
