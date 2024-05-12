package ar.edu.alumno.programacion2.curso2024.practico06.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drogeria {
    private String nombre;
    private String direccion;

    public static Drogeria getInstance() {
        return new Drogeria("Drogeria", "Doblando la esquina");
    }

    public Medicamento getMedicamento(String nombre) {
        Medicamento medicamento = new Medicamento();
        medicamento.setNombre(nombre);
        medicamento.setCantidad(100);
        return medicamento;
    }
}