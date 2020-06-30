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

import com.example.demo.model.Venditore;
import com.example.demo.service.VenditoreService;

@RestController
@RequestMapping("/Rest/Venditore")
public class VenditoreRest {

	@Autowired
	VenditoreService areaser;
	
	

	public VenditoreService getAliser() {
		return areaser;
	}

	public void setAliser(VenditoreService areaser) {
		this.areaser = areaser;
	}

	@GetMapping
	public Iterable<Venditore> getAll() {
		return areaser.getAllVenditori();
	}

	@GetMapping(value = "/{id}")
	public Venditore getByID(@PathVariable("id") Integer id) {
		Venditore ovenditore = areaser.getVenditoreById(id);
		if (ovenditore == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return ovenditore;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		areaser.deleteVenditore(id);

	}

	@PostMapping
	public Venditore create(@RequestBody Venditore ovenditore) {
		return areaser.saveOrUpdate(ovenditore);
	}

	@PutMapping("/{id}")
	public Venditore update(@PathVariable("id") Integer id, @RequestBody Venditore ovenditore) {
		return areaser.saveOrUpdate(ovenditore);
	}
}
