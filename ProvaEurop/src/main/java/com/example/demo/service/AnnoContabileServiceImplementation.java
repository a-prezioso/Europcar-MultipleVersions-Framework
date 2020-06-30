package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AnnoContabile;
import com.example.demo.repository.AnnoContabileRepository;

@Service
@Transactional
public class AnnoContabileServiceImplementation implements AnnoContabileService {
	
	@Autowired
	AnnoContabileRepository annorep;

	@Override
	public List<AnnoContabile> getAllAnni() {
		return (List<AnnoContabile>) annorep.findAll();
	}


	@Override
	public AnnoContabile saveOrUpdate(AnnoContabile oAnnoContabile) {
		return annorep.save(oAnnoContabile);
	}

	@Override
	public void deleteAnnoContabile(Integer idAnnoContabile) {
		annorep.deleteById(idAnnoContabile);
		
	}


	@Override
	public AnnoContabile getUltimoAnno() {
		AnnoContabile oanno = annorep.getUltimoAnno();
		return oanno;
	}


	@Override
	public AnnoContabile getAnnoById(Integer idAnnoContabile) {
		return annorep.findById(idAnnoContabile).get();
	}

}
