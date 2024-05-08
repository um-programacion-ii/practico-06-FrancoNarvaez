package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import ar.edu.alumno.programacion2.curso2024.practico06.service.GestionTurnoService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turno {
    private Persona paciente;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String dniPaciente;
    private Medico medico;
    private String nombreMedico;
    private String apellidoMedico;
    private String especialidadMedico;
    private String obraSocial;
    private boolean terminado;
    private boolean recetaGenerada;
    private GestionTurnoService gestor;

    public Turno(Persona paciente, Medico medico, GestionTurnoService gestor) {
        this.nombrePaciente = paciente.getNombre();
        this.apellidoPaciente = paciente.getApellido();
        this.dniPaciente = paciente.getDni();
        this.nombreMedico = medico.getNombre();
        this.apellidoMedico = medico.getApellido();
        this.especialidadMedico = medico.getEspecialidad();
        this.obraSocial = paciente.isUsaObraSocial() ? paciente.getObraSocial() : "null";
        this.terminado = false;
        this.gestor = gestor;
        this.recetaGenerada = false;
    }

    public void generarReceta(Map<Medicamento, Integer> medicamentos) {
        this.medico.hacerReceta(this.paciente, medicamentos);
        this.recetaGenerada = true;
    }

    public void terminarTurno() {
        this.terminado = true;
        gestor.notificarTurnoTerminado(this);
    }
}