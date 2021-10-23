
package co.com.capudc.service.impl;

import co.com.capudc.commons.GenericServiceImpl;
import co.com.capudc.dao.api.PersonaDaoApi;
import co.com.capudc.model.Persona;
import co.com.capudc.service.api.PersonaServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona,Long> implements PersonaServiceApi {
    
    @Autowired
    private PersonaDaoApi personaDaoApi;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaDaoApi;
    }
    
    
}
