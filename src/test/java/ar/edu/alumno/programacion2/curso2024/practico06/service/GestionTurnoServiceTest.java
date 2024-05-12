package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medico;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Paciente;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Turno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GestionTurnoServiceTest {
    private GestionTurnoService gestionTurnoService;
    private Clinica clinica;

    @BeforeEach
    public void setup() {
        clinica = Mockito.mock(Clinica.class);
        gestionTurnoService = new GestionTurnoService();
        gestionTurnoService.setClinica(clinica);
    }

    @Test
    public void shouldManageTurn() {
        // Mocking the queues
        Queue<Paciente> pacientes = new LinkedList<>();
        Paciente paciente = Mockito.mock(Paciente.class);
        pacientes.add(paciente);

        Queue<Medico> medicos = new LinkedList<>();
        Medico medico = Mockito.mock(Medico.class);
        medicos.add(medico);

        // Mocking the maps
        Map<String, Queue<Paciente>> pacientesPorEspecialidadYTipo = new HashMap<>();
        pacientesPorEspecialidadYTipo.put("Especialidad1", pacientes);

        Map<String, Queue<Medico>> medicosPorEspecialidadYTipo = new HashMap<>();
        medicosPorEspecialidadYTipo.put("Especialidad1", medicos);

        // Mocking the methods
        when(clinica.getPacientesPorEspecialidadYTipo()).thenReturn(pacientesPorEspecialidadYTipo);
        when(clinica.getMedicosPorEspecialidadYTipo()).thenReturn(medicosPorEspecialidadYTipo);

        // Call the method to test
        Turno turno = gestionTurnoService.gestionarTurno();

        // Verify the results
        assertNotNull(turno);
        assertEquals(paciente, turno.getPaciente());
        assertEquals(medico, turno.getMedico());
    }
}