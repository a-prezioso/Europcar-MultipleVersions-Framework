package model.dao;

import model.session.Progetto;


public class ProgettoService extends AbstractService<ProgettoDAO, Progetto> {
	
	@Override
	public ProgettoDAO createDAO() {
		return new ProgettoDAO();
	}
}