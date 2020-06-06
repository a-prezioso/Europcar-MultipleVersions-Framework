package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.FatturaPassiva;

public interface FatturaPassivaRepository extends CrudRepository<FatturaPassiva, Integer> {

//	@Query("SELECT c FROM FatturaPassiva c WHERE c.ofornitore.idfornitore = ?1 AND c.oanno")
//	List<FatturaPassiva> fatturePerFornitore(Integer idFornitore, Integer idAnno);
	
	@Query("SELECT c FROM FatturaPassiva c WHERE c.ofornitore.idfornitore = ?1 "
					+ "AND c.idfatturapassiva IN "
					+ "(SELECT f.ofatturapassiva.idfatturapassiva FROM FatturaPassivaDettaglio f WHERE f.ospesainvestimento.osottocategoria.oarea.oannocontabile.idannocontabile = ?2)")
	List<FatturaPassiva> fatturePerFornitore(Integer idFornitore, Integer idAnno);

	

}