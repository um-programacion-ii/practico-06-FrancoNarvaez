package ar.edu.alumno.programacion2.curso2024.practico06.entidades;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clinica {
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private List<Persona> personas;
    private List<Medico> medicos;

}
