/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.demo.controller;

import Tienda.demo.entity.Persona;
import Tienda.demo.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author valer
 */



@Controller
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/persona")
    public String index (Model model){
        List<Persona> listaPersona =personaService.getAllPersona();
        model.addAttribute("titulo","Tabla Personas");
         model.addAttribute("personas",listaPersona);
         return "personas";
    }
    
    
    
    
    
    
}
