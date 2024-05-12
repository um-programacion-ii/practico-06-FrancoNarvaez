package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private Paciente paciente;
    private Medico medico;
    private Receta recetas;


    public Turno(Paciente paciente, Medico medico, Optional<Receta> receta) {
        this.paciente = paciente;
        this.medico = medico;
        this.recetas = receta.orElse(null);
    }
}