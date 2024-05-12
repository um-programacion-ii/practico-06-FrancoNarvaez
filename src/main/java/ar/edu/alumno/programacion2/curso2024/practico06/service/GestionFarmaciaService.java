package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.*;
import java.util.Map;

public class GestionFarmaciaService {
    private static GestionFarmaciaService instance;
    private Drogeria drogeria = Drogeria.getInstance();
    public static  GestionFarmaciaService getInstance() {
        if (instance == null) {
            instance = new GestionFarmaciaService();
        }
        return instance;
    }

    public void procesarReceta(Receta receta, Farmacia farmacia) {
        for (Map.Entry<Medicamento, Integer> entry : receta.getMedicamentos().entrySet()) {
            Medicamento medicamento = entry.getKey();
            Integer cantidad = entry.getValue();
            if (farmacia.getStockMedicamentosFarmacia(medicamento) < cantidad) {
                Medicamento medicamentoSolicitado = drogeria.getMedicamento(medicamento.getNombre());
                farmacia.agregarStock(medicamentoSolicitado, medicamentoSolicitado.getCantidad());
            }
            farmacia.modificarStock(medicamento, farmacia.getStockMedicamentosFarmacia(medicamento) - cantidad);
        }
    }
}