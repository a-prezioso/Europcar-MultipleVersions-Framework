package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.FatturaPassivaDettaglio;
import model.session.Fornitore;


public class FatturaPassivaDettaglioService extends AbstractService<FatturaPassivaDettaglioDAO, FatturaPassivaDettaglio> {
	
	@Override
	public FatturaPassivaDettaglioDAO createDAO() {
		return new FatturaPassivaDettaglioDAO();
	}
	
	public List<FatturaPassivaDettaglio> elencoFatturaPassivaDettaglioPerFornitore(Fornitore oFornitore) {
		FatturaPassivaDettaglioDAO dao =  this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				.createAlias("ofatturapassiva", "o")
				.createAlias("o.ofornitore", "a")
				.add(Restrictions.eq("a.idfornitore", oFornitore.getIdfornitore()));
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
 	public List<FatturaPassivaDettaglio> findFatturaPerAnnoContabile(int IDAnnoContabile) {
 		FatturaPassivaDettaglioDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(FatturaPassivaDettaglio.class)
				 .createAlias("ospesainvestimento", "o")
		   		 .createAlias("o.osottocategoria", "a")
		   		 .createAlias("a.oarea", "e")
		   		 .createAlias("e.oannocontabile", "i")
		   		 .add(Restrictions.eq("i.idannocontabile", IDAnnoContabile));
		List<FatturaPassivaDettaglio> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}