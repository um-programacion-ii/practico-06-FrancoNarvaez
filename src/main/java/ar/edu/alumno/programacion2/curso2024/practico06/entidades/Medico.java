package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private String nombre;
    private String apellido;
    private String matricula;
    private String especialidad;

    public Receta hacerReceta(Persona paciente, Map<Medicamento, Integer> medicamentos) {
        Receta receta = new Receta(paciente, this, medicamentos);
        paciente.agregarReceta(receta);
        return receta;
    }
}