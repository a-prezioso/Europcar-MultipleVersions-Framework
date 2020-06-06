package com.example.demo.rest;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AnnoContabile;
import com.example.demo.service.AnnoContabileService;

@RestController
@RequestMapping("/Rest/AnnoContabile")
public class AnnoContabileRest {

	@Autowired
	AnnoContabileService annoser;
	
	

	public AnnoContabileService getAliser() {
		return annoser;
	}

	public void setAliser(AnnoContabileService annoser) {
		this.annoser = annoser;
	}

	@GetMapping
	public Iterable<AnnoContabile> getAll() {
		return annoser.getAllAnni();
	}

	@GetMapping(value = "/{id}")
	public AnnoContabile getByID(@PathVariable("id") Integer id) {
		AnnoContabile oanno = annoser.getAnnoById(id);
		if (oanno == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return oanno;
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		annoser.deleteAnnoContabile(id);

	}


}
