package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Random;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private String nombre;
    private String apellido;
    private String matricula;
    private String especialidad;
    private boolean atiendePorObraSocial;
    private boolean estaAtendiendo;

    public Receta hacerReceta(Persona paciente, List<Medicamento> medicamentosExistentes) {
        Random random = new Random();
        Receta receta = new Receta(paciente, this);
        for (Medicamento medicamento : medicamentosExistentes) {
            // Decide aleatoriamente si agregar este medicamento a la receta
            if (random.nextBoolean()) {
                // Decide aleatoriamente la cantidad de este medicamento
                int cantidad = random.nextInt(10) + 1; // Genera un número entre 1 y 10
                receta.agregarMedicamento(medicamento, cantidad);
            }
        }
        // Si la receta no tiene medicamentos, devuelve null
        return receta.getMedicamentos().isEmpty() ? null : receta;
    }
}