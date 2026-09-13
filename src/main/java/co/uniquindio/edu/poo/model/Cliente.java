package co.uniquindio.edu.poo.model;


import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String id;
    private int telefono;
    private String direccion;
    private List<Bicicleta> listaBicicletas;

    // Constructor: al crear un cliente se inicializa su lista de bicicletas vacia
    public Cliente(String nombre, String id, int telefono, String direccion) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listaBicicletas = new ArrayList<>();
    }
    public void vincularBicicleta(Bicicleta bicicleta) {
        if (bicicleta != null) {
            this.listaBicicletas.add(bicicleta);
            bicicleta.setCliente(this);
        }
    }

    // ---------- Getters y Setters ----------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Bicicleta> getListaBicicletas() {
        return listaBicicletas;
    }

    public void setListaBicicletas(List<Bicicleta> listaBicicletas) {
        this.listaBicicletas = listaBicicletas;
    }

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", id=" + id + ", telefono=" + telefono
                + ", direccion=" + direccion + "]";
    }
}