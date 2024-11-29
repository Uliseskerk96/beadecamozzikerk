package com.desi.beadecamozzikerk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.beadecamozzikerk.domain.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
    Optional<Ciudad> findByCodPostal(int codPostal);
}
