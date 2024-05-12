package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Especialidad;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.ObraSocial;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class GestionPacienteServiceTest {
    private GestionPacienteService gestionPacienteService;
    private Clinica clinica;
    private Paciente paciente;
    private ObraSocial obraSocial;

    @BeforeEach
    public void setup() {
        clinica = mock(Clinica.class);
        paciente = mock(Paciente.class);
        obraSocial = mock(ObraSocial.class);
        when(paciente.getObraSocial()).thenReturn(obraSocial);
        when(obraSocial.getNombre()).thenReturn("HealthPlus");
        when(paciente.getEspecialidad()).thenReturn(Especialidad.OFTALMOLOGIA);
        gestionPacienteService = new GestionPacienteService();
        gestionPacienteService.setClinica(clinica);
    }

    @Test
    public void shouldAddPacienteWhenQueueDoesNotExist() {
        // La idea probar un caso en el que la cola de pacientes no exista
        // y se cree una nueva cola para agregar al paciente
        when(clinica.getPacientesPorEspecialidadYTipo()).thenReturn(new HashMap<>());

        gestionPacienteService.agregarPaciente(paciente);

        String key = "OFTALMOLOGIA-HealthPlus";
        Queue<Paciente> pacientes = clinica.getPacientesPorEspecialidadYTipo().get(key);
        if (pacientes == null) {
            fail("La cola de pacientes no fue creada");
        }
        assertEquals(1, pacientes.size());
        assertEquals(paciente, pacientes.peek());

        verify(clinica, times(2)).getPacientesPorEspecialidadYTipo();
    }

    @Test
    public void shouldAddPacienteToCorrectQueue() {
        String key = "OFTALMOLOGIA-HealthPlus";
        gestionPacienteService = mock(GestionPacienteService.class);
        when(gestionPacienteService.getClinica()).thenReturn(clinica);
        when(clinica.getPacientesPorEspecialidadYTipo()).thenReturn(Collections.emptyMap());
        when(paciente.getEspecialidad()).thenReturn(Especialidad.OFTALMOLOGIA);
        when(paciente.getObraSocial().getNombre()).thenReturn("HealthPlus");


        gestionPacienteService.agregarPaciente(paciente);

        verify(gestionPacienteService).agregarPaciente(paciente);
    }
}
