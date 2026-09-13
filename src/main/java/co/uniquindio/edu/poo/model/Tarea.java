package co.uniquindio.edu.poo.model;

public class Tarea {

    private String descripcionTarea;
    private Double costoTarea;

    public Tarea(String descripcionTarea, Double costoTarea) {
        this.descripcionTarea = descripcionTarea;
        this.costoTarea = costoTarea;
    }


    public double calcularValorTareas() {
        if (this.costoTarea == null) {
            return 0.0;
        }
        return this.costoTarea;
    }

    // ---------- Getters y Setters ----------

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public Double getCostoTarea() {
        return costoTarea;
    }

    public void setCostoTarea(Double costoTarea) {
        this.costoTarea = costoTarea;
    }

    @Override
    public String toString() {
        return "Tarea [descripcion=" + descripcionTarea + ", costo=" + costoTarea + "]";
    }
}