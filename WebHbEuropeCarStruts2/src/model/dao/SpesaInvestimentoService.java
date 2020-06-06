package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.SottoCategoria;
import model.session.SpesaInvestimento;


public class SpesaInvestimentoService extends AbstractService<SpesaInvestimentoDAO, SpesaInvestimento> {
	
	@Override
	public SpesaInvestimentoDAO createDAO() {
		return new SpesaInvestimentoDAO();
	}

	public List<SpesaInvestimento> findPerSottoCategoria(int idsottocategoria) {
		SpesaInvestimentoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(SpesaInvestimento.class)
				.createAlias("osottocategoria", "o")
				.add(Restrictions.eq("o.idsottocategoria", idsottocategoria));
		List<SpesaInvestimento> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
	public List<SpesaInvestimento> findPerAnnoContabile(int idannocontabile) {
        SpesaInvestimentoDAO dao= this.createDAO();
        dao.openCurrentSessionwithTransaction();
        Criteria criteria = dao.getCurrentSession().createCriteria(SpesaInvestimento.class)
        	.createAlias("osottocategoria", "o")
            .createAlias("o.oarea", "a")
            .createAlias("a.oannocontabile", "e")
            .add(Restrictions.eq("e.idannocontabile", idannocontabile));
        List<SpesaInvestimento> result = criteria.list();
        dao.closeCurrentSessionwithTransaction();
        return result;
    }
}