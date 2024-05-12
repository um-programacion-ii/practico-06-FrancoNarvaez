package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GestionPacienteService {
    private static GestionPacienteService instance;
    private Clinica clinica;

    public static GestionPacienteService getInstance() {
        if (instance == null) {
            instance = new GestionPacienteService();
        }
        return instance;
    }


    public void agregarPaciente(Paciente paciente) {
        String key = paciente.getEspecialidad().name() + "-" + paciente.getObraSocial().getNombre();
        Queue<Paciente> pacientes = clinica.getPacientesPorEspecialidadYTipo().computeIfAbsent(key, k -> new LinkedList<>());
        pacientes.add(paciente);
    }
}