package ar.edu.alumno.programacion2.curso2024.practico06.service;

import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Drogeria;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Farmacia;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Medicamento;
import ar.edu.alumno.programacion2.curso2024.practico06.entidades.Receta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.HashMap;
import java.util.Map;
import static org.mockito.Mockito.*;

public class GestionFarmaciaServiceTest {
    private GestionFarmaciaService gestionFarmaciaService;
    private Farmacia farmacia;
    private Receta receta;
    private Medicamento medicamento;
    private Drogeria drogeria;

    @BeforeEach
    public void setup() {
        Drogeria drogeria = Drogeria.getInstance();
        farmacia = mock(Farmacia.class);
        receta = mock(Receta.class);
        medicamento = mock(Medicamento.class);
        gestionFarmaciaService = GestionFarmaciaService.getInstance();

        Drogeria spyDrogeria = Mockito.spy(drogeria);
        Mockito.doReturn(medicamento).when(spyDrogeria).getMedicamento(anyString());
        Mockito.when(medicamento.getNombre()).thenReturn("Ibuprofeno");
    }

    @Test
    public void shouldProcessRecetaWhenStockIsEnough() {
        Map<Medicamento, Integer> medicamentos = new HashMap<>();
        medicamentos.put(medicamento, 5);
        when(receta.getMedicamentos()).thenReturn(medicamentos);
        when(farmacia.getStockMedicamentosFarmacia(medicamento)).thenReturn(10);

        gestionFarmaciaService.procesarReceta(receta, farmacia);

        verify(farmacia).modificarStock(medicamento, 5);
    }
}