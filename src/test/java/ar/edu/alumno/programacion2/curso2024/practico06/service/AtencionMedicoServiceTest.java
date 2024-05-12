package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Especialidad;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medico;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.ObraSocial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class AtencionMedicoServiceTest {
    private AtencionMedicoService atencionMedicoService;
    private Clinica clinica;
    private Medico medico;
    private ObraSocial obraSocial;

    @BeforeEach
    public void setup() {
        clinica = mock(Clinica.class);
        medico = mock(Medico.class);
        obraSocial = mock(ObraSocial.class);
        when(medico.getEspecialidad()).thenReturn(Especialidad.NEUROLOGIA);
        when(medico.getObraSocial()).thenReturn(obraSocial);
        when(obraSocial.getNombre()).thenReturn("OSDE");

        atencionMedicoService = AtencionMedicoService.getInstance();
        atencionMedicoService.setClinica(clinica);
    }

    @Test
    public void shouldAddMedicoToClinica() {
        atencionMedicoService.agregarMedico(medico);

        verify(clinica).getMedicosPorEspecialidadYTipo();
    }

    @Test
    public void shouldNotAddMedicoIfAlreadyExists() {
        when(clinica.getMedicosPorEspecialidadYTipo()).thenReturn(new HashMap<>());

        atencionMedicoService.agregarMedico(medico);
        atencionMedicoService.agregarMedico(medico);

        verify(clinica, times(2)).getMedicosPorEspecialidadYTipo();
    }

    @Test
    public void shouldReturnExistingInstance() {
        AtencionMedicoService firstInstance = AtencionMedicoService.getInstance();
        AtencionMedicoService secondInstance = AtencionMedicoService.getInstance();

        assertSame(firstInstance, secondInstance);
    }
}