package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.AnnoContabile;

public interface AnnoContabileRepository extends CrudRepository<AnnoContabile, Integer> {

	@Query(value = "SELECT * FROM AnnoContabile WHERE idannocontabile = (SELECT MAX(idannocontabile) FROM AnnoContabile)",
			nativeQuery = true)
	AnnoContabile getUltimoAnno();

	
	
}
