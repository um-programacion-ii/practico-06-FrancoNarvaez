package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import ar.edu.alumno.programacion2.curso2024.practico06.service.GestionFarmaciaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {
    private String nombre;
    private String direccion;
    private String telefono;
    private HashMap<String, Medicamento> stockMedicamentosFarmacia;

    public void recibirPersona(Persona persona) {
        List<Receta> recetas = persona.getRecetas();
        GestionFarmaciaService gestionFarmaciaService = new GestionFarmaciaService();
        for (Receta receta : recetas) {
            gestionFarmaciaService.procesarReceta(receta, this);
        }
    }
}
