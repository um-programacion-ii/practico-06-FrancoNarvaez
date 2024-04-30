package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private Persona paciente;
    private Medico medico;
}
