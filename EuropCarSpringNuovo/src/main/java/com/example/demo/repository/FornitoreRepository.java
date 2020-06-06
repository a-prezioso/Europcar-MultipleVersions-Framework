package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Fornitore;

public interface FornitoreRepository extends CrudRepository<Fornitore, Integer> {
	
	@Query("SELECT c FROM Fornitore c WHERE c.partitaiva = ?1")
	Fornitore getFornitoreByPartitaIva(String partitaiva);

}
