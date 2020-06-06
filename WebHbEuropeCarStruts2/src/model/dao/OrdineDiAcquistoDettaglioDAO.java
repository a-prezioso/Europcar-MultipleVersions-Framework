package model.dao;

import model.session.OrdineDiAcquistoDettaglio;

public class OrdineDiAcquistoDettaglioDAO extends AbstractDAO<OrdineDiAcquistoDettaglio> {

	@Override
	public Class<OrdineDiAcquistoDettaglio> getPersistentClass() {
		return OrdineDiAcquistoDettaglio.class;
	}

}

