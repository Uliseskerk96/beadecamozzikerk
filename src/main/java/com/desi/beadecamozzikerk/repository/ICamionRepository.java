package com.desi.beadecamozzikerk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.beadecamozzikerk.domain.Camion;

@Repository
public interface ICamionRepository extends JpaRepository<Camion, Long> {
	boolean existsByPatente(String patente);
}
