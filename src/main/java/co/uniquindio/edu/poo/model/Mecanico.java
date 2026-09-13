package co.uniquindio.edu.poo.model;

public class Mecanico {

    private String nombre;
    private String codigoInterno;
    private double sueldo;
    private String especialidad;
    private boolean disponible;

    public Mecanico(String nombre, String codigoInterno, double sueldo, String especialidad) {
        this.nombre = nombre;
        this.codigoInterno = codigoInterno;
        this.sueldo = sueldo;
        this.especialidad = especialidad;
    }

    public void realizarTareasAsignadas() {
        System.out.println("El mecanico " + nombre + " (" + especialidad
                + ") esta realizando las tareas asignadas.");
    }

    // ---------- Getters y Setters ----------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Mecanico [nombre=" + nombre + ", codigoInterno=" + codigoInterno
                + ", especialidad=" + especialidad + "]";
    }
}