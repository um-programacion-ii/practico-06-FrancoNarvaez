package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Farmacia;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medicamento;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Receta;

import java.util.Map;


public class GestionFarmaciaService {


    public void procesarReceta(Receta receta, Farmacia farmacia) {
        Map<Medicamento, Integer> medicamentos = receta.getMedicamentos();
        for (Map.Entry<Medicamento, Integer> entry : medicamentos.entrySet()) {
            Medicamento medicamento = entry.getKey();
            Integer cantidadNecesaria = entry.getValue();
            if (!farmacia.getStockMedicamentosFarmacia().containsKey(medicamento.getNombre()) ||
                    farmacia.getStockMedicamentosFarmacia().get(medicamento.getNombre()).getCantidad() < cantidadNecesaria) {
                GestionStockService gestionStockService = new GestionStockService();
                gestionStockService.pedirMedicamento(medicamento, cantidadNecesaria, farmacia);
            }
        }
    }
}
