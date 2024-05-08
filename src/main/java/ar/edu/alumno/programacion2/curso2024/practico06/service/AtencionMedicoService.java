package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medico;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Persona;

public class AtencionMedicoService {
    private final Clinica clinica;

    public AtencionMedicoService(Clinica clinica) {
        this.clinica = clinica;
    }

    public Medico obtenerMedico() {
        if (!clinica.getMedicos().isEmpty()) {
            return clinica.getMedicos().removeFirst();
        }
        return null;
    }

    public Persona obtenerPersona() {
        if (!clinica.getPersonas().isEmpty()) {
            return clinica.getPersonas().removeFirst();
        }
        return null;
    }

    public void devolverMedico(Medico medico) {
        clinica.getMedicos().add(medico);
    }
}