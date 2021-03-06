package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.OrdineDiAcquistoDettaglio;
import com.example.demo.model.SottoCategoria;


public interface OrdineAcquistoDettaglioRepository extends CrudRepository<OrdineDiAcquistoDettaglio, Integer> {

	@Query("SELECT c FROM OrdineDiAcquistoDettaglio c WHERE c.ospesainvestimento.osottocategoria.idsottocategoria = :idsottocategoria AND c.ospesainvestimento.osottocategoria.oarea.oannocontabile.idannocontabile = :idAnno")
	List<OrdineDiAcquistoDettaglio> ordiniPerSottoCategorie(int idsottocategoria, Integer idAnno);

	@Query("SELECT c FROM OrdineDiAcquistoDettaglio c WHERE c.oprogetto.idprogetto = :idprogetto AND c.ospesainvestimento.osottocategoria.oarea.oannocontabile.idannocontabile = :idAnno")
	List<OrdineDiAcquistoDettaglio> ordiniPerProgetto(Integer idprogetto, Integer idAnno);

//	@Query(value = "SELECT * FROM ORDINEDIACQUISTODETTAGLIO WHERE IDORDINEACQUISTO IN (SELECT IDORDINEACQUISTO FROM ORDINEACQUISTO WHERE DATA BETWEEN TO_DATE('?1', 'YYYY-MM-DD') AND TO_DATE('?2', 'YYYY-MM-DD'))", nativeQuery = true)
//	List<OrdineDiAcquistoDettaglio> dettagliPerSottoCategoriaDate(String estraiData, String estraiData2);
	
	@Query(value = "SELECT o FROM OrdineDiAcquistoDettaglio o WHERE o.oordineacquisto.idordineacquisto IN (SELECT i FROM OrdineAcquisto i WHERE i.data BETWEEN ?1 AND ?2)")
	List<OrdineDiAcquistoDettaglio> dettagliPerSottoCategoriaDate2(Date estraiData, Date estraiData2);

}
