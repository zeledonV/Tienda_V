
package Tienda.demo.repository;

import Tienda.demo.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author valer
 */
@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    
}
