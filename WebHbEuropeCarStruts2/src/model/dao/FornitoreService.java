package model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.Fornitore;


public class FornitoreService extends AbstractService<FornitoreDAO, Fornitore> {
	
	@Override
	public FornitoreDAO createDAO() {
		return new FornitoreDAO();
	}
	
// 	public Fornitore findFornitoreByPIVA(Integer partitaiva) throws Exception {
// 		FornitoreDAO dao = this.createDAO();
//		dao.openCurrentSessionwithTransaction();
//		Criteria criteria = dao.getCurrentSession().createCriteria(Fornitore.class)
//		   		 .add(Restrictions.eq("partitaiva", String.valueOf(partitaiva)));
//		Fornitore result = (Fornitore) criteria.list().get(0);
//		if(criteria.list().size() > 1 ) {
//			throw new Exception("Più di un fornitore trovato con la stessa partita iva:" + partitaiva);
//		}
//		dao.closeCurrentSessionwithTransaction();
//		return result;
//	}
 	
 	public Fornitore findFornitorePerPartitaIva(String partitaIva) throws Exception {
        Fornitore result =null;
        if(this.executeParamizedHQLQuery("FROM model.session.Fornitore o WHERE o.partitaiva= '"+partitaIva+"'", Fornitore.class)!=null) {
            if((this.executeParamizedHQLQuery("FROM model.session.Fornitore o WHERE o.partitaiva='"+partitaIva+"'", Fornitore.class).size()==1)) {
                result = this.executeParamizedHQLQuery("FROM model.session.Fornitore o WHERE o.partitaiva='"+partitaIva+"'", Fornitore.class).get(0);
            }
            else if
            (this.executeParamizedHQLQuery("FROM model.session.Fornitore o WHERE o.partitaiva="+partitaIva, Fornitore.class).size()>1) {
                throw new Exception("ATTENZIONE presenti più di un Fornitore per la PartitaIva:"+partitaIva);

            }
        }
        return result;
    }


	
}