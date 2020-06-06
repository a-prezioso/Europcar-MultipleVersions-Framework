package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.AreaInvestimento;


public class AreaInvestimentoService extends AbstractService<AreaInvestimentoDAO, AreaInvestimento>{
	@Override
	public AreaInvestimentoDAO createDAO() {
		return new AreaInvestimentoDAO();
	}
	public List<AreaInvestimento> findPerAnnoContabile(int idannocontabile) {
		AreaInvestimentoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(AreaInvestimento.class)
				.createAlias("oannocontabile", "o")
				.add(Restrictions.eq("o.idannocontabile", idannocontabile));
		List<AreaInvestimento> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}
