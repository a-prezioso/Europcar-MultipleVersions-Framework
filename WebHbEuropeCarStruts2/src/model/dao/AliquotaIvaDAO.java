package model.dao;

import model.session.AliquotaIva;

public class AliquotaIvaDAO extends AbstractDAO<AliquotaIva> {

	@Override
	public Class<AliquotaIva> getPersistentClass() {
		return AliquotaIva.class;
	}

}

