package ar.unrn.oop2.modelo;

import java.time.LocalDate;

public class Concurso {
    private int id;
    private String nombreConcurso;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Concurso(int id, String nombreConcurso, LocalDate fechaInicio, LocalDate fechaFin) {
        if(validarFechas(fechaInicio, fechaFin)){
            throw new RuntimeException("La fecha de inicio no puede superar a la fecha de cierre");
        }
        this.id = id;
        this.nombreConcurso = nombreConcurso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    private boolean validarFechas(LocalDate fechaInicio, LocalDate fechaFin){
        return (fechaInicio.isAfter(fechaFin) || fechaInicio.equals(fechaFin));
    }

    public boolean estaAbierto(){
        return ((LocalDate.now().isAfter(fechaInicio)||LocalDate.now().isEqual(fechaInicio))&&LocalDate.now().isBefore(fechaFin));
    }

    public int id() {
        return id;
    }

    public String nombreConcurso() {
        return nombreConcurso;
    }
}