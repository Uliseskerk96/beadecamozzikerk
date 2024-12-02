package com.desi.beadecamozzikerk.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desi.beadecamozzikerk.domain.Ubicacion;
import com.desi.beadecamozzikerk.repository.IUbicacionRepository;
import com.desi.beadecamozzikerk.service.IUbicacionService;

@Service
public class IUbicacionServiceImpl implements IUbicacionService {

    @Autowired
    private IUbicacionRepository ubicacionRepository;

    @Override
    public List<Ubicacion> getUbicaciones() {
        return ubicacionRepository.findAll();
    }

    @Override
    public Ubicacion getUbicacionById(Long id) {
        return ubicacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ubicacion> getUbicacionesByCiudad(String ciudad) {
        // Suponiendo que se tiene que filtrar por ciudad
        return ubicacionRepository.findAll().stream()
                                  .filter(ubicacion -> ubicacion.getCiudad().equalsIgnoreCase(ciudad))
                                  .toList();
    }

    @Override
    public List<Ubicacion> getUbicacionesByCodigoPostal(int codigoPostal) {
        // Implementar la lógica para filtrar por código postal, si es necesario.
    	     	    	
        return ubicacionRepository.findAll();  // 
    }

	@Override
	public List<Ubicacion> filtrarUbicaciones(String patente, Integer codPostal) {
		// TODO Auto-generated method stub
		//System.out.println("Codigo postal " + codPostal);
		// return ubicacionRepository.findByCodPostal(codPostal);
		if ((patente != "") && (codPostal != null)) {
            return ubicacionRepository.findByPatenteAndCodPostal(patente, codPostal);
        } else if (patente != "") {
            return ubicacionRepository.findByPatente(patente);
        } else if (codPostal != null) {
        	
            return ubicacionRepository.findByCodPostal(codPostal);
        } else {
            return ubicacionRepository.findAll();  // Si no se filtra por nada, retorna todas
        }
    }
		
		
	}

