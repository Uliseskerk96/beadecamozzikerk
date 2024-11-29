package com.desi.beadecamozzikerk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desi.beadecamozzikerk.domain.Ciudad;
import com.desi.beadecamozzikerk.domain.Paquete;
import com.desi.beadecamozzikerk.service.ICiudadService;
import com.desi.beadecamozzikerk.service.IPaqueteService;

@Controller
@RequestMapping("/paquetes")
public class PaqueteController {

    @Autowired
    private IPaqueteService paqueteService;
    @Autowired
    private ICiudadService ciudadService;

    // Muestra la lista de paquetes
    @GetMapping
    public String listarPaquetes(Model model) {
        List<Paquete> paquetes = paqueteService.obtenerTodosLosPaquetes(); // Método para obtener todos los paquetes
        List<Ciudad> ciudades = ciudadService.getCiudades();
     // Verificar que la lista de ciudades no esté vacía
        System.out.println("Lista de ciudades: " + ciudades);
        
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("paquetes", paquetes);
        return "registrar_paquete"; // Vista para gestionar paquetes
    }

    // Procesa el formulario para registrar un nuevo paquete
    
    @PostMapping("/agregar")
    public String agregarPaquete(@ModelAttribute Paquete paquete, RedirectAttributes redirectAttributes) {
    	
        try {
            paqueteService.guardarPaquete(paquete);  // Guardamos el paquete
            redirectAttributes.addFlashAttribute("success", "Paquete registrado con éxito.");
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "Error de integridad de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar el paquete: " + e.getMessage());
            e.printStackTrace();
        }

        return "redirect:/paquetes";  // Redirigimos a la lista de paquetes
    }


    // Elimina un paquete por su id
    @PostMapping("/borrar/{id}")
    public String eliminarPaquete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            paqueteService.eliminarPaquete(id); // Llamada al servicio para eliminar el paquete
            redirectAttributes.addFlashAttribute("success", "Paquete eliminado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el paquete: " + e.getMessage());
        }
        return "redirect:/paquetes";
    }
}
