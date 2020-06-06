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

import com.example.demo.model.AreaInvestimento;
import com.example.demo.service.AreaInvestimentoService;

@RestController
@RequestMapping("/Rest/AreaInvestimento")
public class AreaInvestimentoRest {

	@Autowired
	AreaInvestimentoService areaser;
	
	

	public AreaInvestimentoService getAliser() {
		return areaser;
	}

	public void setAliser(AreaInvestimentoService areaser) {
		this.areaser = areaser;
	}

	@GetMapping
	public Iterable<AreaInvestimento> getAll() {
		return areaser.getAllAreeInvestimento();
	}

	@GetMapping(value = "/{id}")
	public AreaInvestimento getByID(@PathVariable("id") Integer id) {
		AreaInvestimento oarea = areaser.getAreaInvestimentoById(id);
		if (oarea == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return oarea;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		areaser.deleteArea(id);

	}

	@PostMapping
	public AreaInvestimento create(@RequestBody AreaInvestimento oarea) {
		return areaser.saveOrUpdate(oarea);
	}

	@PutMapping("/{id}")
	public AreaInvestimento update(@PathVariable("id") Integer id, @RequestBody AreaInvestimento oarea) {
		return areaser.saveOrUpdate(oarea);
	}
}
