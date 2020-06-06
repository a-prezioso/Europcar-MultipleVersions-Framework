package model.dao;

import model.session.Gruppo;


public class GruppoService extends AbstractService<GruppoDAO, Gruppo> {
	
	@Override
	public GruppoDAO createDAO() {
		return new GruppoDAO();
	}
}