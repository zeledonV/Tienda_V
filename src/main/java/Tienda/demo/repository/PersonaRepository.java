
package Tienda.demo.repository;


import Tienda.demo.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

       
        
@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    Persona findByNombre (String nombre);
}
        
