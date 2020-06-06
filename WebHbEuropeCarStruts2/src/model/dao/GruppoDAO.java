package model.dao;

import model.session.Gruppo;

public class GruppoDAO extends AbstractDAO<Gruppo> {

	@Override
	public Class<Gruppo> getPersistentClass() {
		return Gruppo.class;
	}

}

