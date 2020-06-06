package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SpesaInvestimento;
import com.example.demo.repository.SpesaInvestimentoRepository;

@Service
@Transactional
public class SpesaInvestimentoServiceImplementation implements SpesaInvestimentoService {
	
	@Autowired
	SpesaInvestimentoRepository sperep;

	@Override
	public List<SpesaInvestimento> getAllSpeseInvestimento() {
		return (List<SpesaInvestimento>) sperep.findAll();
	}

	@Override
	public SpesaInvestimento getSpesaInvestimentoById(Integer idSpesaInvestimento) {
		return sperep.findById(idSpesaInvestimento).get();
	}

	@Override
	public SpesaInvestimento saveOrUpdate(SpesaInvestimento oSpesaInvestimento) {
		return sperep.save(oSpesaInvestimento);
	}

	@Override
	public void deleteSpesaInvestimento(Integer idSpesaInvestimento) {
		sperep.deleteById(idSpesaInvestimento);
	}

	@Override
	public List<SpesaInvestimento> getSpesePerAnno(int idannocontabile) {
		return sperep.findSpesePerAnno(idannocontabile);
	}

}
