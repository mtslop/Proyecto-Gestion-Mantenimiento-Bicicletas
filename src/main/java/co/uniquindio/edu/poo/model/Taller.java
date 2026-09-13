package co.uniquindio.edu.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Taller {

    private String nombre;
    private List<Cliente> listaClientes;
    private List<Mecanico> listaMecanicos;
    private List<OrdenServicio> listaOrdenesServicio;
    private List<Bicicleta> listaBicicletas;

    public Taller(String nombre) {
        this.nombre = nombre;
        this.listaClientes = new ArrayList<>();
        this.listaMecanicos = new ArrayList<>();
        this.listaOrdenesServicio = new ArrayList<>();
        this.listaBicicletas = new ArrayList<>();
    }

    // Registra un nuevo cliente en el taller
    public void registrarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
    }


    public void registrarBicicleta(Bicicleta bicicleta, Cliente cliente) {
        cliente.vincularBicicleta(bicicleta);
        this.listaBicicletas.add(bicicleta);
    }

    // Registra un nuevo mecanico en el taller
    public void registrarMecanico(Mecanico mecanico) {
        this.listaMecanicos.add(mecanico);
    }

    // Registra una nueva orden de servicio en el taller
    public void registrarOrdenServicio(OrdenServicio orden) {
        this.listaOrdenesServicio.add(orden);
    }


    public void asignarMecanicoOrden(String codigoOrden, Mecanico mecanico) {
        OrdenServicio ordenEncontrada = buscarOrdenPorCodigo(codigoOrden);
        if (ordenEncontrada != null) {
            ordenEncontrada.setMecanico(mecanico);
        } else {
            System.out.println("No se encontro ninguna orden con el codigo " + codigoOrden);
        }
    }


    public void cambiarMecanico(String codigoOrden, Mecanico nuevoMecanico) {
        OrdenServicio ordenEncontrada = buscarOrdenPorCodigo(codigoOrden);
        if (ordenEncontrada != null) {
            ordenEncontrada.setMecanico(nuevoMecanico);
        } else {
            System.out.println("No se encontro ninguna orden con el codigo " + codigoOrden);
        }
    }


    public OrdenServicio buscarOrdenPorCodigo(String codigoOrden) {
        for (OrdenServicio orden : listaOrdenesServicio) {
            if (orden.getCodigo().equals(codigoOrden)) {
                return orden;
            }
        }
        return null;
    }

    public Bicicleta buscarBicicletaPorSerial(String serial) {
        for (Bicicleta bicicleta : listaBicicletas) {
            if (bicicleta.getSerial().equals(serial)) {
                return bicicleta;
            }
        }
        return null;
    }

    public Cliente buscarClientePorId(String id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public Mecanico buscarMecanicoPorCodigo(String codigoInterno) {
        for (Mecanico mecanico : listaMecanicos) {
            if (mecanico.getCodigoInterno().equals(codigoInterno)) {
                return mecanico;
            }
        }
        return null;
    }

    public List<Mecanico> obtenerMecanicosDisponibles() {
        List<Mecanico> disponibles = new ArrayList<>();
        for (Mecanico mecanico : listaMecanicos) {
            if (mecanico.isDisponible()) {
                disponibles.add(mecanico);
            }
        }
        return disponibles;
    }


    public List<OrdenServicio> buscarOrdenesPorFecha(LocalDate fecha) {
        List<OrdenServicio> ordenesEncontradas = new ArrayList<>();
        for (OrdenServicio orden : listaOrdenesServicio) {
            LocalDate fechaOrden = orden.getHoraIngreso().toLocalDate();
            if (fechaOrden.equals(fecha)) {
                ordenesEncontradas.add(orden);
            }
        }
        return ordenesEncontradas;
    }


    public List<OrdenServicio> obtenerHistorialServicios(String serialBicicleta) {
        List<OrdenServicio> historial = new ArrayList<>();
        for (OrdenServicio orden : listaOrdenesServicio) {
            Bicicleta bicicletaDeLaOrden = orden.getBicicleta();
            if (bicicletaDeLaOrden != null && bicicletaDeLaOrden.getSerial().equals(serialBicicleta)) {
                historial.add(orden);
            }
        }
        return historial;
    }

    // ---------- Getters y Setters ----------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Mecanico> getListaMecanicos() {
        return listaMecanicos;
    }

    public void setListaMecanicos(List<Mecanico> listaMecanicos) {
        this.listaMecanicos = listaMecanicos;
    }

    public List<OrdenServicio> getListaOrdenesServicio() {
        return listaOrdenesServicio;
    }

    public void setListaOrdenesServicio(List<OrdenServicio> listaOrdenesServicio) {
        this.listaOrdenesServicio = listaOrdenesServicio;
    }

    public List<Bicicleta> getListaBicicletas() {
        return listaBicicletas;
    }

    public void setListaBicicletas(List<Bicicleta> listaBicicletas) {
        this.listaBicicletas = listaBicicletas;
    }
}
