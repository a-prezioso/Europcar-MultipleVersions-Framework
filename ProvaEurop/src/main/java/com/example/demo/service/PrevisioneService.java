package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Previsione;

public interface PrevisioneService {
	
public List<Previsione> getAllPrevisionali();
	
	public Previsione getPrevisionaleById(Integer idPrevisionale);
	
	public Previsione saveOrUpdate(Previsione oPrevisionale);
	
	public void deletePrevisionale(Integer idPrevisionale);
	
	public List<Previsione> getPrevisionaleByVend(Integer idvenditore);

}
