package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import ar.edu.alumno.programacion2.curso2024.practico06.service.GestionFarmaciaService;
import ar.edu.alumno.programacion2.curso2024.practico06.service.GestionStockService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {
    private String nombre;
    private String direccion;
    private GestionStockService gestorDeStock;
    private GestionFarmaciaService gestorDeFarmacia;
    private List<Medicamento> medicamentosExistentes;

    public void procesarReceta(Receta receta) {
        gestorDeFarmacia.procesarReceta(receta, this);
    }

    public void agregarMedicamento(Medicamento medicamento) {
        medicamentosExistentes.add(medicamento);
    }

    public void quitarMedicamento(Medicamento medicamento) {
        medicamentosExistentes.remove(medicamento);
    }

    public void modificarMedicamento(Medicamento medicamentoAntiguo, Medicamento medicamentoNuevo) {
        int index = medicamentosExistentes.indexOf(medicamentoAntiguo);
        if (index != -1) {
            medicamentosExistentes.set(index, medicamentoNuevo);
        }
    }
    public void agregarStock(Medicamento medicamento, Integer cantidad) {
        gestorDeStock.agregarStock(medicamento, cantidad);
    }

    public Integer getStockMedicamentosFarmacia(Medicamento medicamento) {
        return gestorDeStock.obtenerStock(medicamento);
    }

    public void modificarStock(Medicamento medicamento, Integer cantidad) {
        gestorDeStock.modificarStock(medicamento, cantidad);
    }
}
