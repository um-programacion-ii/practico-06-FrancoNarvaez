package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Persona;

public class GestionPacienteService {
    private static GestionPacienteService instance;
    private final AtencionMedicoService atencionMedicoService;

    private GestionPacienteService(AtencionMedicoService atencionMedicoService) {
        this.atencionMedicoService = atencionMedicoService;
    }

    public static GestionPacienteService getInstance(AtencionMedicoService atencionMedicoService) {
        if (instance == null) {
            instance = new GestionPacienteService(atencionMedicoService);
        }
        return instance;
    }

    public void producirPersona(Persona persona) {
        atencionMedicoService.agregarPersona(persona);
    }
}