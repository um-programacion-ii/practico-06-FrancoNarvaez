package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receta {
    private Persona paciente;
    private Medico medico;
    private Map<Medicamento, Integer> medicamentos;

    public Receta(Persona paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
        this.medicamentos = new HashMap<>();
    }

    public void agregarMedicamento(Medicamento medicamento, Integer cantidad) {
        this.medicamentos.put(medicamento, cantidad);
    }
}