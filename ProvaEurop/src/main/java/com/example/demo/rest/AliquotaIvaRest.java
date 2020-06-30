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

import com.example.demo.model.AliquotaIva;
import com.example.demo.service.AliquotaIvaService;

@RestController
@RequestMapping("/Rest/AliquotaIva")
public class AliquotaIvaRest {

	@Autowired
	AliquotaIvaService aliser;
	
	

	public AliquotaIvaService getAliser() {
		return aliser;
	}

	public void setAliser(AliquotaIvaService aliser) {
		this.aliser = aliser;
	}

	@GetMapping
	public Iterable<AliquotaIva> getAll() {
		return aliser.getAllAliquoteIva();
	}

	@GetMapping(value = "/{id}")
	public AliquotaIva getByID(@PathVariable("id") Integer id) {
		AliquotaIva oali = aliser.getAliquotaIvaById(id);
		if (oali == null) {
			throw new EntityNotFoundException("Missing Entity");
		}
		return oali;
	}


	//Alternativa all'utilizzo dei metodi tradizionali
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<AliquotaIva> getByID2(@PathVariable("id") Integer id) {
//		HttpHeaders header = new HttpHeaders();
//		header.set("prova header", "valore header");
//		AliquotaIva oaliq = aliser.getAliquotaIvaById(id);
//		return new ResponseEntity<AliquotaIva>(oaliq, header, HttpStatus.CREATED);
//	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		aliser.deleteAliquotaIva(id);

	}

	@PostMapping
	public AliquotaIva create(@RequestBody AliquotaIva oali) {
		return aliser.saveOrUpdate(oali);
	}

	@PutMapping("/{id}")
	public AliquotaIva update(@PathVariable("id") Integer id, @RequestBody AliquotaIva oali) {
		return aliser.saveOrUpdate(oali);
	}
}
