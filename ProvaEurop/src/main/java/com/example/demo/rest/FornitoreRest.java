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

import com.example.demo.model.Fornitore;
import com.example.demo.service.FornitoreService;

@RestController
@RequestMapping("/Rest/Fornitore")
public class FornitoreRest {

	@Autowired
	FornitoreService forniser;
	
	

	public FornitoreService getAliser() {
		return forniser;
	}

	public void setAliser(FornitoreService forniser) {
		this.forniser = forniser;
	}

	@GetMapping
	public Iterable<Fornitore> getAll() {
		return forniser.getAllFornitori();
	}

	@GetMapping(value = "/{id}")
	public Fornitore getByID(@PathVariable("id") Integer id) {
		Fornitore ofornitore = forniser.getFornitoreById(id);
		if (ofornitore == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return ofornitore;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		forniser.deleteFornitore(id);

	}

	@PostMapping
	public Fornitore create(@RequestBody Fornitore ofornitore) {
		return forniser.saveOrUpdate(ofornitore);
	}

	@PutMapping("/{id}")
	public Fornitore update(@PathVariable("id") Integer id, @RequestBody Fornitore ofornitore) {
		return forniser.saveOrUpdate(ofornitore);
	}
}
