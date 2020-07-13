package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AliquotaIva;
import com.example.demo.repository.AliquotaIvaRepository;

@Service
@Transactional
public class AliquotaIvaServiceImplementation implements AliquotaIvaService {
	
	@Autowired
	AliquotaIvaRepository alirep;

	@Override
	public List<AliquotaIva> getAllAliquoteIva() {
		System.out.println("ciao");
		return null;
	}

	@Override
	public AliquotaIva getAliquotaIvaById(Integer idAliquotaIva) {
		return alirep.findById(idAliquotaIva).get();
	}

	@Override
	public AliquotaIva saveOrUpdate(AliquotaIva oAliquotaIva) {
		return alirep.save(oAliquotaIva);
	}

	@Override
	public void deleteAliquotaIva(Integer idAliquotaIva) {
		alirep.deleteById(idAliquotaIva);
	}

	@Override
	public AliquotaIva findAliquotaPerAliquota(float aliquotaIVA) {
		return (AliquotaIva) alirep.findAliquotaByAliquota(aliquotaIVA);
	}

}
