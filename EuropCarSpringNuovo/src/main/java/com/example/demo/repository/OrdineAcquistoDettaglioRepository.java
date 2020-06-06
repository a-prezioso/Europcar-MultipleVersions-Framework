package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.OrdineDiAcquistoDettaglio;


public interface OrdineAcquistoDettaglioRepository extends CrudRepository<OrdineDiAcquistoDettaglio, Integer> {

	@Query("SELECT c FROM OrdineDiAcquistoDettaglio c WHERE c.ospesainvestimento.osottocategoria.idsottocategoria = :idsottocategoria AND c.ospesainvestimento.osottocategoria.oarea.oannocontabile.idannocontabile = :idAnno")
	List<OrdineDiAcquistoDettaglio> ordiniPerSottoCategoria(int idsottocategoria, Integer idAnno);

	@Query("SELECT c FROM OrdineDiAcquistoDettaglio c WHERE c.oprogetto.idprogetto = :idprogetto AND c.ospesainvestimento.osottocategoria.oarea.oannocontabile.idannocontabile = :idAnno")
	List<OrdineDiAcquistoDettaglio> ordiniPerProgetto(Integer idprogetto, Integer idAnno);

}
