/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.demo.service;

import Tienda.demo.entity.personas;
import java.util.List;

/**
 *
 * @author valer
 */
public interface IPersonaService {
    public List<personas> getAllPersona();
    public personas getPersonaById (long id);
    public void savePersona(personas persona);
    public void delete (long id);
    public personas findByNombre (String Nombre);
}
    
   

