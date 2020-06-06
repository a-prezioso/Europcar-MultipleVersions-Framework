package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SottoCategoria;
import com.example.demo.repository.SottoCategoriaRepository;

@Service
@Transactional
public class SottoCategoriaServiceImplementation implements SottoCategoriaService {

	@Autowired
	SottoCategoriaRepository sotrep;
	
	@Override
	public List<SottoCategoria> getAllSottoCategorie() {
		return (List<SottoCategoria>) sotrep.findAll();
	}

	@Override
	public SottoCategoria getSottoCategoriaById(Integer idSottoCategoria) {
		return sotrep.findById(idSottoCategoria).get();
	}

	@Override
	public SottoCategoria saveOrUpdate(SottoCategoria oSottoCategoria) {
		return sotrep.save(oSottoCategoria);
		
	}

	@Override
	public void deleteSottoCategoria(Integer idSottoCategoria) {
		sotrep.deleteById(idSottoCategoria);
	}

	@Override
	public List<SottoCategoria> getSottoCategoriePerAnno(int idannocontabile) {
		return sotrep.findSottoPerAnno(idannocontabile);
	}

}