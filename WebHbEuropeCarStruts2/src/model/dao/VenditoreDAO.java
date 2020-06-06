package model.dao;

import model.session.Venditore;

public class VenditoreDAO extends AbstractDAO<Venditore> {

	@Override
	public Class<Venditore> getPersistentClass() {
		return Venditore.class;
	}

}

