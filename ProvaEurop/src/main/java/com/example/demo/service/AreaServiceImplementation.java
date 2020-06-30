package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Area;
import com.example.demo.repository.AreaRepository;

@Service
@Transactional
public class AreaServiceImplementation implements AreaService {

	@Autowired
	AreaRepository arearep;
	
	@Override
	public List<Area> getAllAree() {
		return (List<Area>) arearep.findAll();
	}

	@Override
	public Area getAreaById(Integer idArea) {
		return arearep.findById(idArea).get();
	}

	@Override
	public Area saveOrUpdate(Area oArea) {
		return arearep.save(oArea);
	}

	@Override
	public void deleteArea(Integer idArea) {
		arearep.deleteById(idArea);
	}

}
