package model.dao;

import model.session.SpesaInvestimento;

public class SpesaInvestimentoDAO extends AbstractDAO<SpesaInvestimento> {

	@Override
	public Class<SpesaInvestimento> getPersistentClass() {
		return SpesaInvestimento.class;
	}

}

