package com.desi.beadecamozzikerk.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desi.beadecamozzikerk.domain.Paquete;
import com.desi.beadecamozzikerk.repository.IPaqueteRepository;
import com.desi.beadecamozzikerk.service.IPaqueteService;

import java.util.List;


@Service
public class PaqueteServiceImpl implements IPaqueteService {
	@Autowired
    private IPaqueteRepository paqueteRepository;

    @Override
    public void guardarPaquete(Paquete paquete) {
        paqueteRepository.save(paquete);
        
    }

    @Override
    public List<Paquete> obtenerTodosLosPaquetes() {
        return paqueteRepository.findAll();
        
    }

    @Override
    public Paquete obtenerPaquetePorId(Long id) {       
        return paqueteRepository.findById(id).orElse(null);
        
    }

    @Override
    public void eliminarPaquete(Long id) {
        paqueteRepository.deleteById(id);
    }
}
