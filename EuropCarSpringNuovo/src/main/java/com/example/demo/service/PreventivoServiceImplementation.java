package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Preventivo;
import com.example.demo.repository.PreventivoRepository;

@Service
@Transactional
public class PreventivoServiceImplementation implements PreventivoService {

	@Autowired
	PreventivoRepository prerep;

	@Override
	public List<Preventivo> getAllPreventivi() {
		return (List<Preventivo>) prerep.findAll();
	}

	@Override
	public Preventivo getPreventivoById(Integer idPreventivo) {
		return prerep.findById(idPreventivo).get();
	}

	@Override
	public Preventivo saveOrUpdate(Preventivo oPreventivo) {
		return prerep.save(oPreventivo);
	}

	@Override
	public void deletePreventivo(Integer idPreventivo) {
		prerep.deleteById(idPreventivo);
	}

	@Override
	public List<Preventivo> getPreventiviByForn(Integer idfornitore) {
		return (List<Preventivo>) prerep.getPreventiviByForn(idfornitore);
	}

}
