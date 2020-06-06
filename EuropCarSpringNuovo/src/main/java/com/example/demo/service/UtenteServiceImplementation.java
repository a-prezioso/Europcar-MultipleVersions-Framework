package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@Service
@Transactional
public class UtenteServiceImplementation implements UtenteService {
	
	@Autowired
	UtenteRepository uterep;

	@Override
	public List<Utente> getAllUtenti() {
		return (List<Utente>) uterep.findAll();
	}

	@Override
	public Utente getUtenteById(Integer id) {
		return uterep.findById(id).get();
	}

	@Override
	public Utente saveOrUpdate(Utente oUtente) {
		return uterep.save(oUtente);
	}

	@Override
	public void deleteUtente(Integer idUtente) {
		uterep.deleteById(idUtente);
	}

	@Override
	public Utente getUtenteByUserPass(String username, String password) {
		return uterep.getUtenteCustom(username, password);
	}

}
