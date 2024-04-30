package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private String nombre;
    private String apellido;
    private String matricula;
    private String especialidad;

}
