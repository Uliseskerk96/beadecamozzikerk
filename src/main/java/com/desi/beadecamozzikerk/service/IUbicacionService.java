package com.desi.beadecamozzikerk.service;

import java.util.List;
import com.desi.beadecamozzikerk.domain.Ubicacion;

public interface IUbicacionService {
    List<Ubicacion> getUbicaciones();
    Ubicacion getUbicacionById(Long id);
    List<Ubicacion> getUbicacionesByCiudad(String ciudad);
    List<Ubicacion> getUbicacionesByCodigoPostal(int codigoPostal);
	List<Ubicacion> filtrarUbicaciones(String patente, Integer codPostal);
}
