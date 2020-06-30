package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Venditore;
import com.example.demo.repository.VenditoreRepository;

@Service
@Transactional
public class VenditoreServiceImplementation implements VenditoreService {

	@Autowired
	VenditoreRepository venrep;
	
	@Override
	public List<Venditore> getAllVenditori() {
		return (List<Venditore>) venrep.findAll();
	}

	@Override
	public Venditore getVenditoreById(Integer idVenditore) {
		return venrep.findById(idVenditore).get();
	}

	@Override
	public Venditore saveOrUpdate(Venditore oVenditore) {
		return venrep.save(oVenditore);
	}

	@Override
	public void deleteVenditore(Integer idVenditore) {
		venrep.deleteById(idVenditore);
	}

}
