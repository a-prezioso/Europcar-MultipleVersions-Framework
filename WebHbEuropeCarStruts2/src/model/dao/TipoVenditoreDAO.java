package model.dao;

import model.session.TipoVenditore;

public class TipoVenditoreDAO extends AbstractDAO<TipoVenditore>{
	
	@Override
	public Class<TipoVenditore> getPersistentClass() {
		return TipoVenditore.class;
	}
}
