package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medicamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GestionStockServiceTest {
    private GestionStockService gestionStockService;
    private Medicamento medicamento;

    @BeforeEach
    public void setup() {
        medicamento = Mockito.mock(Medicamento.class);
        gestionStockService = new GestionStockService();
        gestionStockService.setStockMedicamentosFarmacia(new HashMap<>());
    }

    @Test
    public void shouldAddStock() {
        gestionStockService.agregarStock(medicamento, 10);
        assertEquals(10, gestionStockService.obtenerStock(medicamento));
    }

    @Test
    public void shouldRemoveStock() {
        gestionStockService.agregarStock(medicamento, 10);
        gestionStockService.quitarStock(medicamento);
        assertEquals(null, gestionStockService.obtenerStock(medicamento));
    }

    @Test
    public void shouldModifyStock() {
        gestionStockService.agregarStock(medicamento, 10);
        gestionStockService.modificarStock(medicamento, 20);
        assertEquals(20, gestionStockService.obtenerStock(medicamento));
    }
}