/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.demo.service;

import Tienda.demo.entity.personas;
import Tienda.demo.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author valer
 */


@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personasRepository;

    @Override
    public List<personas> getAllpersonas() {
        return (List<personas>) personasRepository.findAll();
    }

    @Override
    public personas getpersonasById(long id) {
        return personasRepository.findById(id).orElse(null);
    }

    @Override
    public void savepersonas(personas personas) {
        personasRepository.save(personas);
    }

    @Override
    public void delete(long id) {
        personasRepository.deleteById(id);
    }

    @Override
    public personas findByNombre(String nombre) {
        return PersonaRepository.findByNombre(nombre);
    }

    @Override
    public List<personas> getAllPersona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public personas getPersonaById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void savePersona(personas persona) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public personas getPersonaByID(Long idpersonas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public personas getpersonasById(Long idpersonas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}