package model.dao;

import model.session.Area;


public class AreaService extends AbstractService<AreaDAO, Area> {
	
	@Override
	public AreaDAO createDAO() {
		return new AreaDAO();
	}
}