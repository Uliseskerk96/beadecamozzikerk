package com.desi.beadecamozzikerk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desi.beadecamozzikerk.domain.Ciudad;
import com.desi.beadecamozzikerk.service.ICiudadService;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {
	@Autowired
	private ICiudadService ciudadService;

	@GetMapping
	public List<Ciudad> getCiudades() {
		return ciudadService.getCiudades();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> getCiudadPorId(@PathVariable Long id) {
		try {
			Ciudad ciudad = ciudadService.getCiudadById(id);

			return ResponseEntity.status(HttpStatus.OK).body(ciudad);
		} catch (Exception e) {
			 Map<String, String> errorResponse = new HashMap<>();
		        errorResponse.put("message", "Error al obtener la ciudad: " + e.getMessage());
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	
		}

	}

	@GetMapping("/codPostal/{codPostal}")
	public ResponseEntity<?> getCiudadPorId(@PathVariable int codPostal) {
		try {
			Ciudad ciudad = ciudadService.getCiudadByCodPostal(codPostal);

			return ResponseEntity.status(HttpStatus.OK).body(ciudad);
		} catch (Exception e) {
			 Map<String, String> errorResponse = new HashMap<>();
		        errorResponse.put("message", "Error al obtener la ciudad: " + e.getMessage());
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		
		}

	}

}
