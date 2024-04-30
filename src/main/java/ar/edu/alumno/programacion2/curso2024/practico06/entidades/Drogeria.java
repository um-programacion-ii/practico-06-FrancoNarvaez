package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drogeria {
    private String nombre;
    private String direccion;
    private String telefono;
    private HashMap<String, Medicamento> stockMedicamentosDrogeria;
}