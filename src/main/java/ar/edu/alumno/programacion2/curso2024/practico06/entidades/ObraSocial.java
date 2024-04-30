package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraSocial {
    private String nombre;
    private String direccion;
    private String telefono;


}
