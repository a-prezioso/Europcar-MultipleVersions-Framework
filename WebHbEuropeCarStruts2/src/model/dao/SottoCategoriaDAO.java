package model.dao;

import model.session.SottoCategoria;

public class SottoCategoriaDAO extends AbstractDAO<SottoCategoria> {

	@Override
	public Class<SottoCategoria> getPersistentClass() {
		return SottoCategoria.class;
	}

}

