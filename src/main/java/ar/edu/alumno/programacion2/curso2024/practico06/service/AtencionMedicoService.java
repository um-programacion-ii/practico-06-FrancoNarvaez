package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Clinica;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.LinkedList;
import java.util.Queue;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtencionMedicoService {
    private static AtencionMedicoService instance;
    private Clinica clinica;



    public static AtencionMedicoService getInstance() {
        if (instance == null) {
            instance = new AtencionMedicoService();
        }
        return instance;
    }


    public void agregarMedico(Medico medico) {
        String key = medico.getEspecialidad().name() + "-" + medico.getObraSocial().getNombre();
        Queue<Medico> medicos = clinica.getMedicosPorEspecialidadYTipo().computeIfAbsent(key, k -> new LinkedList<>());
        medicos.add(medico);
    }
}
