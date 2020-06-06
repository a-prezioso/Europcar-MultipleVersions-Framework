package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.SottoCategoria;

public interface SottoCategoriaRepository extends CrudRepository<SottoCategoria, Integer> {

	@Query("SELECT c FROM SottoCategoria c WHERE c.oarea.oannocontabile.idannocontabile = :idannocontabile")
	List<SottoCategoria> findSottoPerAnno(int idannocontabile);

}
