package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medico;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Persona;

public class AtencionMedicoService {
    private final Clinica clinica;

    public AtencionMedicoService(Clinica clinica) {
        this.clinica = clinica;
    }

    public Medico obtenerMedico(String especialidad) {
        if (!clinica.getMedicosPorEspecialidad().get(especialidad).isEmpty()) {
            return clinica.getMedicosPorEspecialidad().get(especialidad).removeFirst();
        }
        return null;
    }

    public Persona obtenerPersona(String especialidad) {
        if (!clinica.getPersonasPorEspecialidad().get(especialidad).isEmpty()) {
            return clinica.getPersonasPorEspecialidad().get(especialidad).removeFirst();
        }
        return null;
    }

    public void devolverMedico(Medico medico) {
        clinica.getMedicosPorEspecialidad().get(medico.getEspecialidad()).add(medico);
    }
}