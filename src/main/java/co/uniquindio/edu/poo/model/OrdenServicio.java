package co.uniquindio.edu.poo.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenServicio {

    private String codigo;
    private String motivoIngreso;
    private LocalDateTime horaIngreso;
    private String diagnostico;
    private EstadoOrden estado;
    private List<Tarea> listaTareas;
    private double costoTotal;
    private Bicicleta bicicleta;
    private Mecanico mecanico;

    // Constructor: al crear la orden, esta queda en estado RECIBIDA y con
    // la lista de tareas vacia, y la hora de ingreso queda en el momento actual.
    public OrdenServicio(String codigo, String motivoIngreso, Bicicleta bicicleta) {
        this.codigo = codigo;
        this.motivoIngreso = motivoIngreso;
        this.bicicleta = bicicleta;
        this.horaIngreso = LocalDateTime.now();
        this.estado = EstadoOrden.RECIBIDA;
        this.listaTareas = new ArrayList<>();
        this.costoTotal = 0.0;
    }

    public double calcularManoObra() {
        double totalManoObra = 0.0;
        for (Tarea tarea : listaTareas) {
            totalManoObra = totalManoObra + tarea.calcularValorTareas();
        }
        return totalManoObra;
    }

    public double calcularRepuestos() {
        return 0.0;
    }

    public double calcularCostototal() {
        double manoObra = calcularManoObra();
        double repuestos = calcularRepuestos();
        this.costoTotal = manoObra + repuestos;
        return this.costoTotal;
    }

    public void cambiarEstadoOrden(EstadoOrden nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void asignarTareasAMecanico() {
        if (this.mecanico != null) {
            this.mecanico.realizarTareasAsignadas();
        } else {
            System.out.println("La orden " + codigo + " no tiene un mecanico asignado todavia.");
        }
    }

    public void mostrarEstadoBicicleta() {
        if (this.bicicleta != null) {
            System.out.println("Bicicleta serial " + bicicleta.getSerial() + " (" + bicicleta.getMarca()
                    + " " + bicicleta.getModelo() + ") -> Estado de la orden: " + estado);
        } else {
            System.out.println("La orden " + codigo + " no tiene una bicicleta asociada.");
        }
    }

    // ---------- Getters y Setters ----------

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalDateTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return "OrdenServicio [codigo=" + codigo + ", estado=" + estado + ", costoTotal=" + costoTotal + "]";
    }
}