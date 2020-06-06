package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.DistintaPagamento;
import model.session.FatturaPassiva;

public class DistintaPagamentoService extends AbstractService<DistintaPagamentoDAO, DistintaPagamento> {

	@Override
	public DistintaPagamentoDAO createDAO() {
		return new DistintaPagamentoDAO();
	}

	public List<DistintaPagamento> findDistintaPerFattura(FatturaPassiva ofatturapassiva, int idannocontabile) {
		DistintaPagamentoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(DistintaPagamento.class)
				.createAlias("ofatturapassivadettaglio", "o").createAlias("o.ofatturapassiva", "a")
				.add(Restrictions.eq("a.idfatturapassiva", ofatturapassiva.getIdfatturapassiva()))
				.createAlias("o.ospesainvestimento", "e").createAlias("e.osottocategoria", "i")
				.createAlias("i.oarea", "b").createAlias("b.oannocontabile", "c")
				.add(Restrictions.eq("c.idannocontabile", idannocontabile));
		List<DistintaPagamento> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
	public List<DistintaPagamento> findDistintaPerFattura(FatturaPassiva ofatturapassiva) {
		DistintaPagamentoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(DistintaPagamento.class)
				.createAlias("ofatturapassivadettaglio", "o")
				.createAlias("o.ofatturapassiva", "a")
				.add(Restrictions.eq("a.idfatturapassiva", ofatturapassiva.getIdfatturapassiva()));
		List<DistintaPagamento> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	public List<DistintaPagamento> findDistintaPerStato(String stato, String idfattura, int idannocontabile) {
		if (stato.equalsIgnoreCase("Pagate")) {
			DistintaPagamentoDAO dao = this.createDAO();
			dao.openCurrentSessionwithTransaction();
			Criteria criteria = dao.getCurrentSession().createCriteria(DistintaPagamento.class)
					.createAlias("ofatturapassivadettaglio", "o")
					.add(Restrictions.eqProperty("o.importo", "o.importoPagato")).createAlias("o.ofatturapassiva", "a")
					.add(Restrictions.eq("a.idfatturapassiva", Integer.parseInt(idfattura)))
					.createAlias("o.ospesainvestimento", "e").createAlias("e.osottocategoria", "i")
					.createAlias("i.oarea", "b").createAlias("b.oannocontabile", "c")
					.add(Restrictions.eq("c.idannocontabile", idannocontabile));
			List<DistintaPagamento> result = criteria.list();
			dao.closeCurrentSessionwithTransaction();
			return result;
		} else {
			DistintaPagamentoDAO dao = this.createDAO();
			dao.openCurrentSessionwithTransaction();
			Criteria criteria = dao.getCurrentSession().createCriteria(DistintaPagamento.class)
					.createAlias("ofatturapassivadettaglio", "o")
					.add(Restrictions.neProperty("o.importo", "o.importoPagato")).createAlias("o.ofatturapassiva", "a")
					.add(Restrictions.eq("a.idfatturapassiva", Integer.parseInt(idfattura)));
			;
			List<DistintaPagamento> result = criteria.list();
			dao.closeCurrentSessionwithTransaction();
			return result;
		}
	}

	public List<DistintaPagamento> findDistintaPerFornitore(String idfornitore, String idfattura, int idannocontabile) {
		DistintaPagamentoDAO dao = this.createDAO();
		dao.openCurrentSessionwithTransaction();
		Criteria criteria = dao.getCurrentSession().createCriteria(DistintaPagamento.class)
				.createAlias("ofatturapassivadettaglio", "o").createAlias("o.ofatturapassiva", "a")
				.add(Restrictions.eq("a.idfatturapassiva", Integer.parseInt(idfattura)))
				.createAlias("a.ofornitore", "e").add(Restrictions.eq("e.idfornitore", Integer.parseInt(idfornitore)))
				.createAlias("o.ospesainvestimento", "e").createAlias("e.osottocategoria", "i")
				.createAlias("i.oarea", "b").createAlias("b.oannocontabile", "c")
				.add(Restrictions.eq("c.idannocontabile", idannocontabile));
		List<DistintaPagamento> result = criteria.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}

	public List<DistintaPagamento> findDistintaPerFornitoreStato(String idfornitore, String stato, String idfattura,
			int idannocontabile) {
		if (stato.equalsIgnoreCase("Pagate")) {
			DistintaPagamentoDAO dao = this.createDAO();
			dao.openCurrentSessionwithTransaction();
			Criteria criteria = dao.getCurrentSession().createCriteria(DistintaPagamento.class)
					.createAlias("ofatturapassivadettaglio", "o")
					.add(Restrictions.eqProperty("o.importo", "o.importoPagato")).createAlias("o.ofatturapassiva", "a")
					.add(Restrictions.eq("a.idfatturapassiva", Integer.parseInt(idfattura)))
					.createAlias("a.ofornitore", "r")
					.add(Restrictions.eq("r.idfornitore", Integer.parseInt(idfornitore)))
					.createAlias("o.ospesainvestimento", "e")
					.createAlias("e.osottocategoria", "i")
					.createAlias("i.oarea", "b")
					.createAlias("b.oannocontabile", "c")
					.add(Restrictions.eq("c.idannocontabile", idannocontabile));
			List<DistintaPagamento> result = criteria.list();
			dao.closeCurrentSessionwithTransaction();
			return result;
		} else {
			DistintaPagamentoDAO dao = this.createDAO();
			dao.openCurrentSessionwithTransaction();
			Criteria criteria = dao.getCurrentSession().createCriteria(DistintaPagamento.class)
					.createAlias("ofatturapassivadettaglio", "o")
					.add(Restrictions.neProperty("o.importo", "o.importoPagato")).createAlias("o.ofatturapassiva", "a")
					.add(Restrictions.eq("a.idfatturapassiva", Integer.parseInt(idfattura)))
					.createAlias("a.ofornitore", "e")
					.add(Restrictions.eq("e.idfornitore", Integer.parseInt(idfornitore)));
			List<DistintaPagamento> result = criteria.list();
			dao.closeCurrentSessionwithTransaction();
			return result;
		}
	}

}