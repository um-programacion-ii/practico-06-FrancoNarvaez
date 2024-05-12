package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clinica {
    private String nombre;
    private String direccion;
    private String telefono;
    private Map<String, Queue<Medico>> medicosPorEspecialidadYTipo;
    private Map<String, Queue<Paciente>> pacientesPorEspecialidadYTipo;

    public Clinica(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.medicosPorEspecialidadYTipo = new HashMap<>();
        this.pacientesPorEspecialidadYTipo = new HashMap<>();

        for (Especialidad especialidad : Especialidad.values()) {
            for (String obraSocial : new String[]{"Medife", "Osde", "Particular"}) {
                String key = especialidad.name() + "-" + obraSocial;
                this.medicosPorEspecialidadYTipo.put(key, new LinkedList<>());
                this.pacientesPorEspecialidadYTipo.put(key, new LinkedList<>());
            }
        }
    }
}