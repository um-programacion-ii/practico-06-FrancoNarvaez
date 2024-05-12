package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medicamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionStockService {
    private static GestionStockService instance;
    private HashMap<Medicamento, Integer> stockMedicamentosFarmacia;
    public static GestionStockService getInstance() {
        if (instance == null) {
            instance = new GestionStockService();
        }
        return instance;
    }

    public void agregarStock(Medicamento medicamento, Integer cantidad) {
        stockMedicamentosFarmacia.put(medicamento, cantidad);
    }

    public void quitarStock(Medicamento medicamento) {
        stockMedicamentosFarmacia.remove(medicamento);
    }

    public void modificarStock(Medicamento medicamento, Integer cantidad) {
        stockMedicamentosFarmacia.put(medicamento, cantidad);
    }

    public Integer obtenerStock(Medicamento medicamento) {
        return stockMedicamentosFarmacia.get(medicamento);
    }
}