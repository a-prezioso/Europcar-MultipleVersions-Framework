package com.example.demo.rest;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Progetto;
import com.example.demo.service.ProgettoService;

@RestController
@RequestMapping("/Rest/Progetto")
public class ProgettoRest {

	@Autowired
	ProgettoService proser;
	
	

	public ProgettoService getAliser() {
		return proser;
	}

	public void setAliser(ProgettoService proser) {
		this.proser = proser;
	}

	@GetMapping
	public Iterable<Progetto> getAll() {
		return proser.getAllProgetti();
	}

	@GetMapping(value = "/{id}")
	public Progetto getByID(@PathVariable("id") Integer id) {
		Progetto oprogetto = proser.getProgettoById(id);
		if (oprogetto == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return oprogetto;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		proser.deleteProgetto(id);

	}

	@PostMapping
	public Progetto create(@RequestBody Progetto oprogetto) {
		return proser.saveOrUpdate(oprogetto);
	}

	@PutMapping("/{id}")
	public Progetto update(@PathVariable("id") Integer id, @RequestBody Progetto oprogetto) {
		return proser.saveOrUpdate(oprogetto);
	}
}
