package model.dao;

import model.session.TipoVenditore;

public class TipoVenditoreService extends AbstractService<TipoVenditoreDAO, TipoVenditore>{
	@Override
	public TipoVenditoreDAO createDAO() {
		return new TipoVenditoreDAO();
	}
	
}
