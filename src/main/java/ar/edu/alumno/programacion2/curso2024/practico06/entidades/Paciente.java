package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import ar.edu.alumno.programacion2.curso2024.practico06.service.GestionFarmaciaService;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private String nombre;
    private String apellido;
    private Integer dni;
    private boolean usaObraSocial;
    private ObraSocial obraSocial;
    private Especialidad especialidad;
    private List<Receta> recetas;

    public void agregarReceta(Receta receta) {
        recetas.add(receta);
    }

    public void comprarMedicamentos(Farmacia farmacia){
        Receta receta = recetas.remove(0);
        farmacia.procesarReceta(receta);
    }
}
