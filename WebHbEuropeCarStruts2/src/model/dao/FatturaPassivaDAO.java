package model.dao;

import model.session.FatturaPassiva;

public class FatturaPassivaDAO extends AbstractDAO<FatturaPassiva> {

	@Override
	public Class<FatturaPassiva> getPersistentClass() {
		return FatturaPassiva.class;
	}

}

