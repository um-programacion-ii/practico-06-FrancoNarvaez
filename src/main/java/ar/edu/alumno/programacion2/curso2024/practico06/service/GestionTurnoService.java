package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionTurnoService {
    private static GestionTurnoService instance;
    private AtencionMedicoService atencionMedicoService;
    private GestionPacienteService gestionPacienteService;
    private Clinica clinica;
    private Map<Integer, Turno> turnosTerminados;

    public static GestionTurnoService getInstance() {
        if (instance == null) {
            instance = new GestionTurnoService();
        }
        return instance;
    }

    public Turno gestionarTurno() {
        for (Map.Entry<String, Queue<Paciente>> entry : clinica.getPacientesPorEspecialidadYTipo().entrySet()) {
            Queue<Paciente> pacientes = entry.getValue();
            if (!pacientes.isEmpty()) {
                Paciente paciente = pacientes.poll();
                Queue<Medico> medicos = clinica.getMedicosPorEspecialidadYTipo().get(entry.getKey());
                if (medicos != null && !medicos.isEmpty()) {
                    Medico medico = medicos.poll();
                    Random random = new Random();
                    if (random.nextBoolean()) {
                        Receta receta = medico.hacerReceta(paciente);
                        Turno turno = new Turno(paciente, medico, receta);
                        terminarTurno(turno);
                        return turno;
                    }
                    Turno turno = new Turno(paciente, medico, Optional.empty());
                    terminarTurno(turno);
                    return turno;
                } else {
                    pacientes.add(paciente);
                }
            }
        }
        return null;
    }

    public void terminarTurno(Turno turno) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        notificarTurnoTerminado(turno);
    }


    public void notificarTurnoTerminado(Turno turno) {
        if (turno.getMedico().getEspecialidad() != null) {
            String key = turno.getMedico().getEspecialidad().name() + "-" + turno.getMedico().getObraSocial().getNombre();
            Queue<Medico> medicos = clinica.getMedicosPorEspecialidadYTipo().get(key);
            if (medicos != null) {
                medicos.add(turno.getMedico());
            }
            turnosTerminados.put(turno.getPaciente().getDni(), turno);
        }
    }
}
