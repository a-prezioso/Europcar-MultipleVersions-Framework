package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.FatturaPassivaDettaglio;

public interface FatturaPassivaDettaglioRepository extends CrudRepository<FatturaPassivaDettaglio, Integer> {

	
	@Query("SELECT c FROM FatturaPassivaDettaglio c WHERE c.opreventivo.idpreventivo = ?1 AND c.ospesainvestimento.osottocategoria.oarea.oannocontabile.idannocontabile = ?2")
	List<FatturaPassivaDettaglio> fatturePerPreventivo(Integer idpreventivo, Integer idAnno);

	@Query("SELECT c FROM FatturaPassivaDettaglio c WHERE c.ospesainvestimento.osottocategoria.idsottocategoria = ?1 AND c.ospesainvestimento.osottocategoria.oarea.oannocontabile.idannocontabile = ?2")
	List<FatturaPassivaDettaglio> fatturePerSottoCategoria(Integer idsottocategoria, Integer idAnno);
	
}
