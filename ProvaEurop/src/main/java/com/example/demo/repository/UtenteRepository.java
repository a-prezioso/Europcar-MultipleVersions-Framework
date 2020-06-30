package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Integer>{

	@Query("SELECT c FROM Utente c WHERE c.username = ?1 AND c.password = ?2")
	Utente getUtenteCustom(String username, String password);

}
