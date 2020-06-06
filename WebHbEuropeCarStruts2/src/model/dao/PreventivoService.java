package model.dao;

import model.session.Preventivo;


public class PreventivoService extends AbstractService<PreventivoDAO, Preventivo> {
	
	@Override
	public PreventivoDAO createDAO() {
		return new PreventivoDAO();
	}
	
	
	
}