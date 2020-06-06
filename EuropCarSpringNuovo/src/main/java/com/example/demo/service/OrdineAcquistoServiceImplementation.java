package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrdineAcquisto;
import com.example.demo.repository.OrdineAcquistoRepository;

@Service
@Transactional
public class OrdineAcquistoServiceImplementation implements OrdineAcquistoService {

	@Autowired
	OrdineAcquistoRepository ordrep;

	@Override
	public List<OrdineAcquisto> getAllOrdiniAcquisto() {
		return (List<OrdineAcquisto>) ordrep.findAll();
	}

	@Override
	public OrdineAcquisto getOrdineAcquistoById(Integer idOrdineAcquisto) {
		return ordrep.findById(idOrdineAcquisto).get();
	}

	@Override
	public OrdineAcquisto saveOrUpdate(OrdineAcquisto oOrdineAcquisto) {
		return ordrep.save(oOrdineAcquisto);
	}

	@Override
	public void deleteOrdineAcquisto(Integer idOrdineAcquisto) {
		ordrep.deleteById(idOrdineAcquisto);
	}

	@Override
	public List<OrdineAcquisto> getOrdiniPerFornitore(Integer idFornitore, Integer idAnno) {
		return ordrep.ordiniPerFornitore(idFornitore, idAnno);
	}
	
}
