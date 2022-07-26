/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.demo.controller;

import Tienda.demo.entity.Pais;
import Tienda.demo.entity.personas;
import Tienda.demo.service.IPaisService;
import Tienda.demo.service.IPersonaService;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**

 * @author Andra Mckenzie Araya
 */
@Controller//definimos que es tipo controller
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;

    //Metodo que arrastra los datos de base de datos al htnml
    @GetMapping("/persona")
    public String index(Model model) {
        List<personas> listaPersona = personaService.getAllpersonas();
        model.addAttribute("titulo", "Tabla Personas");
        model.addAttribute("personas", listaPersona);
        return "personas";
    }

    //Metodo que crear una nueva persona
    @GetMapping("/personaN")
    public String crearPersona(Model model) {
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("personas", new personas());
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute personas persona) {
        personaService.savepersonas(persona);
        return "redirect:/personas";//redirige a persona
    }

    //Metodo que edita
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        personas persona = personaService.getpersonasById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPaises);
        return "crear";//redirige a persona
    }

    //Metodo que elimina
    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona) {
        personaService.delete(idPersona);
        return "redirect:/persona";//redirige a persona
    }

}