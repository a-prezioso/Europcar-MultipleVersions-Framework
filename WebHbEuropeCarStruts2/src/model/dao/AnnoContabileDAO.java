package model.dao;

import model.session.AnnoContabile;

public class AnnoContabileDAO extends AbstractDAO<AnnoContabile>{
	@Override
	public Class<AnnoContabile> getPersistentClass() {
		return AnnoContabile.class;
	}
}
