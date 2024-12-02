package com.desi.beadecamozzikerk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.desi.beadecamozzikerk.domain.Ubicacion;
import com.desi.beadecamozzikerk.service.IUbicacionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {

    @Autowired
    private IUbicacionService ubicacionService;

    @GetMapping
    public List<Ubicacion> getUbicaciones() {
        return ubicacionService.getUbicaciones();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getUbicacionPorId(@PathVariable Long id) {
        try {
            Ubicacion ubicacion = ubicacionService.getUbicacionById(id);
            if (ubicacion == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ubicación no encontrada.");
            }
            return ResponseEntity.status(HttpStatus.OK).body(ubicacion);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Error al obtener la ubicación: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<Ubicacion> getUbicacionesPorCiudad(@PathVariable String ciudad) {
        return ubicacionService.getUbicacionesByCiudad(ciudad);
    }

    @GetMapping("/cod_Postal/{codPostal}")
    public List<Ubicacion> getUbicacionesPorCodigoPostal(@PathVariable int codPostal) {
        return ubicacionService.getUbicacionesByCodigoPostal(codPostal);
    }
    
    @GetMapping("/gestionar-ubicacion/filtrar")
    public String filtrarUbicaciones(@RequestParam(required = false) String patente, 
                                     @RequestParam(required = false) Integer codPostal,
                                     Model model) {
        // Lógica para filtrar ubicaciones según los parámetros
        List<Ubicacion> ubicacionesFiltradas = ubicacionService.filtrarUbicaciones(patente, codPostal);
        
        model.addAttribute("ubicaciones", ubicacionesFiltradas);
        
        // Devolver la vista con las ubicaciones filtradas
        return "gestionar_ubicacion";
        
    }
}
