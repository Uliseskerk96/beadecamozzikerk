package com.desi.beadecamozzikerk.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.beadecamozzikerk.domain.Ciudad;
import com.desi.beadecamozzikerk.repository.ICiudadRepository;
import com.desi.beadecamozzikerk.service.ICiudadService;

@Service
public class CiudadServiceImpl implements ICiudadService{

	@Autowired
	private ICiudadRepository ciudadRepository;

	@Override
	public List<Ciudad> getCiudades() {
		return ciudadRepository.findAll();
	}

	@Override
	public Ciudad getCiudadById(Long id) {
		return ciudadRepository.findById(id).orElse(null);
	}

	@Override
	public Ciudad getCiudadByCodPostal(int codPostal) {
		return ciudadRepository.findByCodPostal(codPostal).orElse(null);
	}
}
