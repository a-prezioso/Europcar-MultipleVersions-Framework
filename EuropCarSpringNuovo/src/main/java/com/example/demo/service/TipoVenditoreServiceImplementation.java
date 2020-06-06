package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TipoVenditore;
import com.example.demo.repository.TipoVenditoreRepository;

@Service
@Transactional
public class TipoVenditoreServiceImplementation implements TipoVenditoreService {

	@Autowired
	TipoVenditoreRepository tiporep;
	
	@Override
	public List<TipoVenditore> getAllTipiVenditore() {
		return (List<TipoVenditore>) tiporep.findAll();
	}

	@Override
	public TipoVenditore getTipoVenditoreById(Integer idTipoVenditore) {
		return tiporep.findById(idTipoVenditore).get();
	}

	@Override
	public void saveOrUpdate(TipoVenditore oTipoVenditore) {
		tiporep.save(oTipoVenditore);
	}

	@Override
	public void deleteTipoVenditore(Integer idTipoVenditore) {
		tiporep.deleteById(idTipoVenditore);
	}

}
