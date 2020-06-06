package model.dao;

import model.session.Azienda;


public class AziendaService extends AbstractService<AziendaDAO, Azienda> {
	
	@Override
	public AziendaDAO createDAO() {
		return new AziendaDAO();
	}
}