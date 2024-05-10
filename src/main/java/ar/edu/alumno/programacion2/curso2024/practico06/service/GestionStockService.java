package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Drogeria;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Farmacia;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medicamento;

public class GestionStockService {
    private static GestionStockService instance;

    private GestionStockService() {}

    public static GestionStockService getInstance() {
        if (instance == null) {
            instance = new GestionStockService();
        }
        return instance;
    }

    public void pedirMedicamento(Medicamento medicamento, Integer cantidad, Farmacia farmacia) {
        Drogeria drogeria = new Drogeria();
        Medicamento medicamentoNuevo = drogeria.getStockMedicamentosDrogeria().get(medicamento.getNombre());
        medicamentoNuevo.setCantidad(cantidad);
        farmacia.getStockMedicamentosFarmacia().put(medicamentoNuevo.getNombre(), medicamentoNuevo);
    }
}