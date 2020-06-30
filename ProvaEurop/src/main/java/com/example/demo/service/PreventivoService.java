package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Preventivo;

public interface PreventivoService {
	
	public List<Preventivo> getAllPreventivi();
	
	public Preventivo getPreventivoById(Integer idPreventivo);
	
	public Preventivo saveOrUpdate(Preventivo oPreventivo);
	
	public void deletePreventivo(Integer idPreventivo);
	
	public List<Preventivo> getPreventiviByForn(Integer idfornitore);

}
