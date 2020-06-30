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

import com.example.demo.model.Gruppo;
import com.example.demo.service.GruppoService;

@RestController
@RequestMapping("/Rest/Gruppo")
public class GruppoRest {

	@Autowired
	GruppoService gruser;
	
	

	public GruppoService getAliser() {
		return gruser;
	}

	public void setAliser(GruppoService gruser) {
		this.gruser = gruser;
	}

	@GetMapping
	public Iterable<Gruppo> getAll() {
		return gruser.getAllGruppi();
	}

	@GetMapping(value = "/{id}")
	public Gruppo getByID(@PathVariable("id") Integer id) {
		Gruppo ogruppo = gruser.getGruppoById(id);
		if (ogruppo == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return ogruppo;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		gruser.deleteGruppo(id);

	}

	@PostMapping
	public Gruppo create(@RequestBody Gruppo ogruppo) {
		return gruser.saveOrUpdate(ogruppo);
	}

	@PutMapping("/{id}")
	public Gruppo update(@PathVariable("id") Integer id, @RequestBody Gruppo ogruppo) {
		return gruser.saveOrUpdate(ogruppo);
	}
}
