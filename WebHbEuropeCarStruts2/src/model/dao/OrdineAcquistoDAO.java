package model.dao;

import model.session.OrdineAcquisto;

public class OrdineAcquistoDAO extends AbstractDAO<OrdineAcquisto> {

	@Override
	public Class<OrdineAcquisto> getPersistentClass() {
		return OrdineAcquisto.class;
	}

}

