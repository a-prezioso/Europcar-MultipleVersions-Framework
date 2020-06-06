package model.dao;

import model.session.Venditore;


public class VenditoreService extends AbstractService<VenditoreDAO, Venditore> {
	
	@Override
	public VenditoreDAO createDAO() {
		return new VenditoreDAO();
	}
}