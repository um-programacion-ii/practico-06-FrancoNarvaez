package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medico;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Turno;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Persona;
import lombok.Getter;


import java.util.List;

@Getter
public class GestionTurnoService {
    private Clinica clinica;
    private List<Turno> logTurnos;
    public Turno GestionarTurno(Clinica clinica) {
        this.clinica = clinica;
        if (clinica.getMedicos().isEmpty() || clinica.getPersonas().isEmpty()) {
            return null;
        }

        Persona paciente = clinica.getPersonas().removeFirst();
        Medico medico = clinica.getMedicos().removeFirst();

        return new Turno(paciente, medico, this);
    }

    public void notificarTurnoTerminado(Turno turno) {
        clinica.getMedicos().add(turno.getMedico());
        this.logTurnos.add(turno);
    }

    //Logico que el log deberia guardarlo en un archivo o base de datos,
    // pero no se pide en el enunciado el uso de base de datos.

}
