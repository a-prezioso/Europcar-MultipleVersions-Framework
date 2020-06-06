package model.dao;

import model.session.Preventivo;

public class PreventivoDAO extends AbstractDAO<Preventivo> {

	@Override
	public Class<Preventivo> getPersistentClass() {
		return Preventivo.class;
	}

}

