package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private ObraSocial obraSocial;
    private Farmacia farmacia;

    public Receta hacerReceta(Paciente paciente) {
        List<Medicamento> medicamentosExistentes = farmacia.getMedicamentosExistentes();
        Map<Medicamento, Integer> medicamentosReceta = new HashMap<>();
        Random random = new Random();

        for (Medicamento medicamento : medicamentosExistentes) {
            int cantidad = random.nextInt(10) + 1; // Genera una cantidad aleatoria entre 1 y 10
            medicamentosReceta.put(medicamento, cantidad);
        }

        Receta receta = new Receta(medicamentosReceta);
        paciente.agregarReceta(receta);
        return receta;
    }
}