package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.Previsione;
import model.session.Utente;
import model.session.Venditore;


public class PrevisioneService extends AbstractService<PrevisioneDAO, Previsione> {
	
	@Override
	public PrevisioneDAO createDAO() {
		return new PrevisioneDAO();
	}
	
	
	public List<Previsione> elencoPrevisioniPerAreaAzienda(Venditore ovenditore, String idarea, String idazienda, int idannocontabile) {
		PrevisioneDAO dao = new PrevisioneService().createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(Previsione.class)
				.add(Restrictions.eq("ovenditore.idvenditore", ovenditore.getIdvenditore()))
				.add(Restrictions.eq("oarea.idarea", Integer.parseInt(idarea.replace("\'", ""))))
				.add(Restrictions.eq("oazienda.idazienda", Integer.parseInt(idazienda.replace("\'", ""))))
				.createAlias("osottocategoria", "a")
				.createAlias("a.oarea", "e")
				.createAlias("e.oannocontabile", "f")
				.add(Restrictions.eq("f.idannocontabile", idannocontabile));
		List<Previsione> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
	public List<Previsione> elencoPrevisioniPerArea(Venditore ovenditore, String idarea, int idannocontabile) {
		PrevisioneDAO dao = new PrevisioneService().createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(Previsione.class)
				.add(Restrictions.eq("ovenditore.idvenditore", ovenditore.getIdvenditore()))
				.add(Restrictions.eq("oarea.idarea", Integer.parseInt(idarea.replace("\'", ""))))
				.createAlias("osottocategoria", "a")
				.createAlias("a.oarea", "e")
				.createAlias("e.oannocontabile", "f")
				.add(Restrictions.eq("f.idannocontabile", idannocontabile));
		List<Previsione> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
	public List<Previsione> elencoPrevisioniPerAzienda(Venditore ovenditore, String idazienda, int idannocontabile) {
		PrevisioneDAO dao = new PrevisioneService().createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(Previsione.class)
				.add(Restrictions.eq("ovenditore.idvenditore",ovenditore.getIdvenditore()))
				.add(Restrictions.eq("oazienda.idazienda", Integer.parseInt(idazienda.replace("\'", ""))))
				.createAlias("osottocategoria", "a")
				.createAlias("a.oarea", "e")
				.createAlias("e.oannocontabile", "f")
				.add(Restrictions.eq("f.idannocontabile", idannocontabile));
		List<Previsione> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
	public List<Previsione> findPrevisionePerVenditore(Utente outente) {
		PrevisioneDAO dao = new PrevisioneService().createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(Previsione.class).createAlias("ovenditore", "o")
				.add(Restrictions.eq("o.idvenditore", outente.getOvenditore().getIdvenditore()));
		List<Previsione> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
	public List<Previsione> findPrevisionePerVenditore(Venditore ovenditore, int idannocontabile) {
		PrevisioneDAO dao = new PrevisioneService().createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(Previsione.class)
				.createAlias("ovenditore", "o")
				.add(Restrictions.eq("o.idvenditore", ovenditore.getIdvenditore()))
				.createAlias("osottocategoria", "a")
				.createAlias("a.oarea", "e")
				.createAlias("e.oannocontabile", "f")
				.add(Restrictions.eq("f.idannocontabile", idannocontabile));
		List<Previsione> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
	public List<Previsione> findPrevisionePerVenditore(Venditore ovenditore) {
		PrevisioneDAO dao = new PrevisioneService().createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(Previsione.class)
				.createAlias("ovenditore", "o")
				.add(Restrictions.eq("o.idvenditore",ovenditore.getIdvenditore()));
		List<Previsione> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

}