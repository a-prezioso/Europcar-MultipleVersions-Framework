package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Previsione;

public interface PrevisioneRepository extends CrudRepository<Previsione, Integer> {

	@Query("SELECT c FROM Previsione c WHERE c.ovenditore.idvenditore = ?1")
	List<Previsione> getPrevisionaliByVend(Integer idvenditore);

}
