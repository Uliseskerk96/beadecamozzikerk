package com.desi.beadecamozzikerk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.beadecamozzikerk.domain.Paquete;

@Repository
public interface IPaqueteRepository extends JpaRepository<Paquete, Long>{
	boolean existsById(Long id);

}
