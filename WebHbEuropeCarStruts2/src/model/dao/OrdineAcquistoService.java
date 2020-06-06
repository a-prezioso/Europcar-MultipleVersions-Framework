package model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import model.session.AnnoContabile;
import model.session.OrdineAcquisto;



public class OrdineAcquistoService extends AbstractService<OrdineAcquistoDAO, OrdineAcquisto> {
	
	@Override
	public OrdineAcquistoDAO createDAO() {
		return new OrdineAcquistoDAO();
	}
	
	
	public List<OrdineAcquisto> findPerAnnoContabile(AnnoContabile oAnnoContabile) {
		List<OrdineAcquisto> elenco = this.findAll();
		List<OrdineAcquisto> result = new ArrayList<OrdineAcquisto>();
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
					&& elenco.get(i).getData().getTime() <= oAnnoContabile.getDatafine().getTime()) {
				result.add(elenco.get(i));
			}
		}
		return result;
	}
}