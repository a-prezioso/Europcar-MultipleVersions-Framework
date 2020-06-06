package model.dao;

import model.session.Utente;


public class UtenteService extends AbstractService<UtenteDAO, Utente> {
	
	@Override
	public UtenteDAO createDAO() {
		return new UtenteDAO();
	}
}