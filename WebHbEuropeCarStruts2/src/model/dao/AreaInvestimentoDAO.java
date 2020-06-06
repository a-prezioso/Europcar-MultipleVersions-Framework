package model.dao;

import model.session.AreaInvestimento;

public class AreaInvestimentoDAO extends AbstractDAO<AreaInvestimento>{
	
	@Override
	public Class<AreaInvestimento> getPersistentClass() {
		return AreaInvestimento.class;
	}
}
