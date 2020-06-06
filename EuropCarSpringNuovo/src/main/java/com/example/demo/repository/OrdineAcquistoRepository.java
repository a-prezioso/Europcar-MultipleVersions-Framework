package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.OrdineAcquisto;

public interface OrdineAcquistoRepository extends CrudRepository<OrdineAcquisto, Integer> {

	@Query("SELECT c FROM OrdineAcquisto c WHERE c.ofornitore.idfornitore = ?1 " + "AND c.idordineacquisto IN "
			+ "(SELECT f.oordineacquisto.idordineacquisto FROM OrdineDiAcquistoDettaglio f WHERE f.ospesainvestimento.osottocategoria.oarea.oannocontabile.idannocontabile = ?2)")
	List<OrdineAcquisto> ordiniPerFornitore(Integer idFornitore, Integer idAnno);

}
