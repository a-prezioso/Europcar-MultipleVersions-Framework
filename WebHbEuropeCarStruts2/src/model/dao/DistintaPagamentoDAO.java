package model.dao;

import model.session.DistintaPagamento;

public class DistintaPagamentoDAO extends AbstractDAO<DistintaPagamento> {

	@Override
	public Class<DistintaPagamento> getPersistentClass() {
		return DistintaPagamento.class;
	}

}

