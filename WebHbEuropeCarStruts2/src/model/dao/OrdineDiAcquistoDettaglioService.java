package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import model.session.OrdineDiAcquistoDettaglio;

public class OrdineDiAcquistoDettaglioService extends AbstractService<OrdineDiAcquistoDettaglioDAO, OrdineDiAcquistoDettaglio> {
	
	@Override
	public OrdineDiAcquistoDettaglioDAO createDAO() {
		return new OrdineDiAcquistoDettaglioDAO();
	}
	
	
 	public List<OrdineDiAcquistoDettaglio> findOrdinePerAnnoContabile(int idannocontabile) {
 		OrdineDiAcquistoDettaglioDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(OrdineDiAcquistoDettaglio.class)
				 .createAlias("ospesainvestimento", "o")
		   		 .createAlias("o.osottocategoria", "a")
		   		.createAlias("a.oarea", "e")
		   		.createAlias("e.oannocontabile", "i")
		   		 .add(Restrictions.eq("i.idannocontabile", idannocontabile));
		List<OrdineDiAcquistoDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

}