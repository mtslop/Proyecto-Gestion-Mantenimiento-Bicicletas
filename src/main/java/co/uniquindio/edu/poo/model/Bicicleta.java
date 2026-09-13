package co.uniquindio.edu.poo.model;

public class Bicicleta {

    private String modelo;
    private String color;
    private String marca;
    private String serial;
    private int anio;
    private TipoBicicleta tipo;
    private Cliente cliente;

    // Constructor con los datos basicos de la bicicleta. El cliente se asocia
    // despues, normalmente mediante el metodo vincularBicicleta() de Cliente.
    public Bicicleta(String modelo, String color, String marca, String serial, int anio, TipoBicicleta tipo) {
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.serial = serial;
        this.anio = anio;
        this.tipo = tipo;
    }

    // ---------- Getters y Setters ----------

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public TipoBicicleta getTipo() {
        return tipo;
    }

    public void setTipo(TipoBicicleta tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Bicicleta [modelo=" + modelo + ", marca=" + marca + ", serial=" + serial
                + ", color=" + color + ", anio=" + anio + ", tipo=" + tipo + "]";
    }
}