package model.dao;

import model.session.Utente;

public class UtenteDAO extends AbstractDAO<Utente> {

	@Override
	public Class<Utente> getPersistentClass() {
		return Utente.class;
	}

}

