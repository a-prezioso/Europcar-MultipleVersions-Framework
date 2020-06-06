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

import com.example.demo.model.Azienda;
import com.example.demo.service.AziendaService;

@RestController
@RequestMapping("/Rest/Azienda")
public class AziendaRest {

	@Autowired
	AziendaService aziendaser;
	
	

	public AziendaService getAliser() {
		return aziendaser;
	}

	public void setAliser(AziendaService aziendaser) {
		this.aziendaser = aziendaser;
	}

	@GetMapping
	public Iterable<Azienda> getAll() {
		return aziendaser.getAllAziende();
	}

	@GetMapping(value = "/{id}")
	public Azienda getByID(@PathVariable("id") Integer id) {
		Azienda oazienda = aziendaser.getAziendaById(id);
		if (oazienda == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return oazienda;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		aziendaser.deleteAzienda(id);

	}

	@PostMapping
	public Azienda create(@RequestBody Azienda oazienda) {
		return aziendaser.saveOrUpdate(oazienda);
	}

	@PutMapping("/{id}")
	public Azienda update(@PathVariable("id") Integer id, @RequestBody Azienda oazienda) {
		return aziendaser.saveOrUpdate(oazienda);
	}
}
