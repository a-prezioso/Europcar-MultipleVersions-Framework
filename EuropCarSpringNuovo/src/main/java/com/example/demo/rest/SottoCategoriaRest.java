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

import com.example.demo.model.SottoCategoria;
import com.example.demo.service.SottoCategoriaService;

@RestController
@RequestMapping("/Rest/SottoCategoria")
public class SottoCategoriaRest {

	@Autowired
	SottoCategoriaService areaser;
	
	

	public SottoCategoriaService getAliser() {
		return areaser;
	}

	public void setAliser(SottoCategoriaService areaser) {
		this.areaser = areaser;
	}

	@GetMapping
	public Iterable<SottoCategoria> getAll() {
		return areaser.getAllSottoCategorie();
	}

	@GetMapping(value = "/{id}")
	public SottoCategoria getByID(@PathVariable("id") Integer id) {
		SottoCategoria osottocategoria = areaser.getSottoCategoriaById(id);
		if (osottocategoria == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return osottocategoria;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		areaser.deleteSottoCategoria(id);

	}

	@PostMapping
	public SottoCategoria create(@RequestBody SottoCategoria osottocategoria) {
		return areaser.saveOrUpdate(osottocategoria);
	}

	@PutMapping("/{id}")
	public SottoCategoria update(@PathVariable("id") Integer id, @RequestBody SottoCategoria osottocategoria) {
		return areaser.saveOrUpdate(osottocategoria);
	}
}
