package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.AliquotaIva;

public interface AliquotaIvaRepository extends CrudRepository<AliquotaIva, Integer> {

	@Query("SELECT c FROM AliquotaIva c WHERE c.aliquota = ?1")
	AliquotaIva findAliquotaByAliquota(float aliquotaIVA);

}
