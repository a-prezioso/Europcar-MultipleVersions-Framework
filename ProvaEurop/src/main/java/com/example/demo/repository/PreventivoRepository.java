package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Preventivo;

public interface PreventivoRepository extends CrudRepository<Preventivo, Integer> {
	
	@Query("SELECT c FROM Preventivo c WHERE c.ofornitore.idfornitore = ?1")
	List<Preventivo> getPreventiviByForn(Integer idfornitore);

}
