package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medico;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;



public class AtencionMedicoService {
    private static AtencionMedicoService instance;
    private final Clinica clinica;
    private final Map<String, Queue<Medico>> medicosPorEspecialidad;
    private final Map<String, Queue<Persona>> personasPorEspecialidad;

    private AtencionMedicoService(Clinica clinica) {
        this.clinica = clinica;
        this.medicosPorEspecialidad = new ConcurrentHashMap<>();
        this.personasPorEspecialidad = new ConcurrentHashMap<>();
    }

    public static AtencionMedicoService getInstance(Clinica clinica) {
        if (instance == null) {
            instance = new AtencionMedicoService(clinica);
        }
        return instance;
    }

    public void agregarMedico(Medico medico) {
        Queue<Medico> colaMedicos = medicosPorEspecialidad.computeIfAbsent(medico.getEspecialidad(), k -> new ConcurrentLinkedQueue<>());
        colaMedicos.add(medico);
    }

    public Medico obtenerMedico(String especialidad) {
        Queue<Medico> colaMedicos = medicosPorEspecialidad.get(especialidad);
        if (colaMedicos != null && !colaMedicos.isEmpty()) {
            return colaMedicos.poll();
        }
        return null;
    }

    public void agregarPersona(Persona persona) {
        Queue<Persona> colaPersonas = personasPorEspecialidad.computeIfAbsent(persona.getEspecialidad(), k -> new ConcurrentLinkedQueue<>());
        colaPersonas.add(persona);
    }

    public Persona obtenerPersona(String especialidad) {
        Queue<Persona> colaPersonas = personasPorEspecialidad.get(especialidad);
        if (colaPersonas != null && !colaPersonas.isEmpty()) {
            return colaPersonas.poll();
        }
        return null;
    }

    public void devolverMedico(Medico medico) {
        medico.setEstaAtendiendo(false);
    }
}