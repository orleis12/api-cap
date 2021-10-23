
package co.com.capudc.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long idPersona;
    
    @Column
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido; 
    
    @NotEmpty
    private String fechaNacimiento;
    
    @NotEmpty
    private String genero;
    
    @NotEmpty
    private String telefono;
    
    @NotEmpty
    @Email
    private String correo;
    
    @NotEmpty
    private String direccion;
    
}
