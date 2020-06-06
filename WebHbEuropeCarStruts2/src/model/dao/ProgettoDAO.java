package model.dao;

import model.session.Progetto;

public class ProgettoDAO extends AbstractDAO<Progetto> {

	@Override
	public Class<Progetto> getPersistentClass() {
		return Progetto.class;
	}

}

