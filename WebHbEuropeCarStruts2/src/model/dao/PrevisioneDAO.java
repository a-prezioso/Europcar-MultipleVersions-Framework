package model.dao;

import model.session.Previsione;

public class PrevisioneDAO extends AbstractDAO<Previsione> {

	@Override
	public Class<Previsione> getPersistentClass() {
		return Previsione.class;
	}

}

