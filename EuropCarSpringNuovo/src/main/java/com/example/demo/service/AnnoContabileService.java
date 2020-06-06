package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AnnoContabile;

public interface AnnoContabileService {
	
	public List<AnnoContabile> getAllAnni();
	
	public AnnoContabile saveOrUpdate(AnnoContabile oAnnoContabile);
	
	public void deleteAnnoContabile(Integer idAnnoContabile);
		
	public AnnoContabile getUltimoAnno();
	
	public AnnoContabile getAnnoById(Integer idAnnoContabile);

}
