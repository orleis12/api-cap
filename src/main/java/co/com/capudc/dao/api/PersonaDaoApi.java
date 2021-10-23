
package co.com.capudc.dao.api;

import co.com.capudc.model.Persona;
import org.springframework.data.repository.CrudRepository;


public interface PersonaDaoApi extends  CrudRepository<Persona,Long>{
    
}
