package model.dao;



import java.util.ArrayList;
import java.util.List;

import model.session.AnnoContabile;
import model.session.FatturaPassiva;


public class FatturaPassivaService extends AbstractService<FatturaPassivaDAO, FatturaPassiva> {
	
	@Override
	public FatturaPassivaDAO createDAO() {
		return new FatturaPassivaDAO();
	}
	
	public List<FatturaPassiva> findPerAnnoContabile(AnnoContabile oAnnoContabile) {
		List<FatturaPassiva> elenco = this.findAll();
		List<FatturaPassiva> result = new ArrayList<FatturaPassiva>();
		for (int i = 0; i < elenco.size(); i++) {
			if (elenco.get(i).getData().getTime() >= oAnnoContabile.getDatainizio().getTime()
					&& elenco.get(i).getData().getTime() <= oAnnoContabile.getDatafine().getTime()) {
				result.add(elenco.get(i));
			}
		}
		return result;
	}
	
}