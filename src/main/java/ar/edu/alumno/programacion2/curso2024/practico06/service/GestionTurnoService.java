package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medico;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Turno;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Persona;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class GestionTurnoService {
    private static GestionTurnoService instance;
    private final AtencionMedicoService atencionMedicoService;
    private final List<Turno> logTurnos;


    public static GestionTurnoService getInstance(AtencionMedicoService atencionMedicoService) {
        if (instance == null) {
            instance = new GestionTurnoService(atencionMedicoService);
        }
        return instance;
    }


    private GestionTurnoService(AtencionMedicoService atencionMedicoService) {
        this.atencionMedicoService = atencionMedicoService;
        this.logTurnos = new ArrayList<>();
    }


    public void producirMedico(Medico medico) {
        atencionMedicoService.agregarMedico(medico);
    }


    public Turno gestionarTurno(String especialidad, boolean atiendePorObraSocial) {
        Persona paciente = atencionMedicoService.obtenerPersona(especialidad);
        Medico medico = atencionMedicoService.obtenerMedico(especialidad);

        if (paciente == null || medico == null) {
            return null;
        }

        return new Turno(paciente, medico, this);
    }

    public void notificarTurnoTerminado(Turno turno) {
        atencionMedicoService.devolverMedico(turno.getMedico());
        this.logTurnos.add(turno);
    }
}

    //Logico que el log deberia guardarlo en un archivo o base de datos,
    // pero no se pide en el enunciado el uso de base de datos.

