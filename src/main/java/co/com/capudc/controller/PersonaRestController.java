
package co.com.capudc.controller;

import co.com.capudc.model.Persona;
import co.com.capudc.service.api.PersonaServiceApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/persona/")
@CrossOrigin("*")
public class PersonaRestController {
    
    @Autowired
    private PersonaServiceApi personaServiceApi;
    
    @GetMapping(value = "/all")
    public List<Persona> getAll() {
        return personaServiceApi.getAll(); // convierte la listado el resultado en formato JSON automaticamente
    }
    
    @GetMapping(value = "/find/{idPersona}")
    public Persona find(@PathVariable Long idPersona) {
        Persona obj = personaServiceApi.get(idPersona);
        
        if(obj!=null){
            return obj;
        }else {
            return null;
        }
    }
    
    @PostMapping(value = "/save") // puede guardar y/o actualizar
    public ResponseEntity<Persona> save(@RequestBody Persona persona) { // recibe en el parametro en obj JSON y el requestBody lo convierte en obj persona
        Persona obj = personaServiceApi.save(persona); // guarda o actualiza el obj persona y lo retorna por si lo necesitas
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete/{idPersona}")
    public ResponseEntity<Persona> delete(@PathVariable Long idPersona) {
        Persona persona = personaServiceApi.get(idPersona);
        if (persona != null) {
            personaServiceApi.delete(idPersona);
        } else { // si no existe el valor manda un error 500
            return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
    
    
}
