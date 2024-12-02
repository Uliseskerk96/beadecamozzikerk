package com.desi.beadecamozzikerk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desi.beadecamozzikerk.domain.Ubicacion;

@Repository
public interface IUbicacionRepository extends JpaRepository<Ubicacion, Long> {

	List<Ubicacion> findByPatenteAndCodPostal(String patente, Integer codPostal);
    
	List<Ubicacion> findByPatente(String patente);

	List<Ubicacion> findByCodPostal(Integer codPostal);
}
