package com.desi.beadecamozzikerk.service;

import com.desi.beadecamozzikerk.domain.Paquete;

import java.util.List;

import org.springframework.stereotype.Service;



@Service
public interface IPaqueteService {


    // Método para guardar un paquete
	void guardarPaquete(Paquete paquete);

    // Método para obtener todos los paquetes
    List<Paquete> obtenerTodosLosPaquetes();

    // Método para obtener un paquete por su ID
    Paquete obtenerPaquetePorId(Long id);

    // Método para eliminar un paquete por su ID
    void eliminarPaquete(Long id);
}
