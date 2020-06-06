package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.AliquotaIva;
import model.session.Fornitore;
import model.session.Previsione;
import model.session.Venditore;


public class AliquotaIvaService extends AbstractService<AliquotaIvaDAO, AliquotaIva> {
	
	@Override
	public AliquotaIvaDAO createDAO() {
		return new AliquotaIvaDAO();
	}
	
	public AliquotaIva findAliquotaPerAliquota(float aliquota) throws Exception {
        AliquotaIva result =null;
        if(this.executeParamizedHQLQuery("FROM model.session.AliquotaIva o WHERE o.aliquota="+aliquota, AliquotaIva.class)!=null) {
            if((this.executeParamizedHQLQuery("FROM model.session.AliquotaIva o WHERE o.aliquota="+aliquota, AliquotaIva.class).size()==1)) {
                result = this.executeParamizedHQLQuery("FROM model.session.AliquotaIva o WHERE o.aliquota="+aliquota, AliquotaIva.class).get(0);
            }
            else if(this.executeParamizedHQLQuery("FROM model.session.AliquotaIva o WHERE o.aliquota="+aliquota, AliquotaIva.class).size()>1) {
                throw new Exception("ATTENZIONE presenti più di un aliquota per la le aliquote:"+aliquota);

            }
        }
        return result;
    }
	
	
//	public List<Previsione> elencoPrevisioniPerAreaAzienda(Venditore ovenditore, String idarea, String idazienda, int idannocontabile) {
//		PrevisioneDAO dao = new PrevisioneService().createDAO();
//		dao.openCurrentSessionwithTransaction();
//		Criteria criteria = dao.getCurrentSession().createCriteria(Previsione.class)
//				.add(Restrictions.eq("ovenditore.idvenditore", ovenditore.getIdvenditore()))
//				.add(Restrictions.eq("oarea.idarea", Integer.parseInt(idarea.replace("\'", ""))))
//				.add(Restrictions.eq("oazienda.idazienda", Integer.parseInt(idazienda.replace("\'", ""))))
//				.createAlias("osottocategoria", "a")
//				.createAlias("a.oarea", "e")
//				.createAlias("e.oannocontabile", "f")
//				.add(Restrictions.eq("f.idannocontabile", idannocontabile));
//		List<Previsione> result = criteria.list();
//		dao.closeCurrentSessionwithTransaction();
//		return result;
//	}
}