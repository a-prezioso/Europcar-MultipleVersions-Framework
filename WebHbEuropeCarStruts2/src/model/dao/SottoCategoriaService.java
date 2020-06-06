package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.SottoCategoria;


public class SottoCategoriaService extends AbstractService<SottoCategoriaDAO, SottoCategoria> {
	
	@Override
	public SottoCategoriaDAO createDAO() {
		return new SottoCategoriaDAO();
	}
	
	public List<SottoCategoria> findPerAnnoContabile(int idannocontabile) {
        SottoCategoriaDAO dao= this.createDAO();
        dao.openCurrentSessionwithTransaction();
        Criteria criteria = dao.getCurrentSession().createCriteria(SottoCategoria.class)
            .createAlias("oarea", "o")
            .createAlias("o.oannocontabile", "e")
            .add(Restrictions.eq("e.idannocontabile", idannocontabile));
        List<SottoCategoria> result = criteria.list();
        dao.closeCurrentSessionwithTransaction();
        return result;
    }
	public List<SottoCategoria> findPerAreaInvestimento(int idarea) {
		SottoCategoriaDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(SottoCategoria.class)
				.createAlias("oarea", "o")
				.add(Restrictions.eq("o.idarea", idarea));
		List<SottoCategoria> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
}