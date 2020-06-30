package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.AreaInvestimento;

public interface AreaInvestimentoRepository extends CrudRepository<AreaInvestimento, Integer> {

	@Query("SELECT c FROM AreaInvestimento c WHERE c.oannocontabile.idannocontabile = ?1")
	List<AreaInvestimento> findPerAnno(Integer idAnno);

}
