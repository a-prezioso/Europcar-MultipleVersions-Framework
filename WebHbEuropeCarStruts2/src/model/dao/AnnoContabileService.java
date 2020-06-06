package model.dao;

import model.session.AnnoContabile;

public class AnnoContabileService extends AbstractService<AnnoContabileDAO, AnnoContabile>{

	@Override
	public AnnoContabileDAO createDAO() {
		return new AnnoContabileDAO();
	}
}
