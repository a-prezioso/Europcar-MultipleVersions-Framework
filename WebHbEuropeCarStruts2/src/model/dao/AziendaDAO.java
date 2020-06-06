package model.dao;

import model.session.Azienda;

public class AziendaDAO extends AbstractDAO<Azienda> {

	@Override
	public Class<Azienda> getPersistentClass() {
		return Azienda.class;
	}

}

