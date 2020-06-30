package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Utente;

public interface UtenteService {
	
	public List<Utente> getAllUtenti();

	public Utente getUtenteById(Integer id);
	
	public Utente saveOrUpdate(Utente oUtente);
	
	public void deleteUtente(Integer idUtente);

	public Utente getUtenteByUserPass(String username, String password);


}
