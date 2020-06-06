package model.dao;

import model.session.Fornitore;

public class FornitoreDAO extends AbstractDAO<Fornitore> {

	@Override
	public Class<Fornitore> getPersistentClass() {
		return Fornitore.class;
	}

}

