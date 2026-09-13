package co.uniquindio.edu.poo.controller;

import co.uniquindio.edu.poo.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class InicioController {
    @FXML private StackPane contenedorVistas;
    @FXML public void initialize() { cargarRegistroCliente(); }
    @FXML public void cargarRegistroCliente() { cargar("registroCliente.fxml"); }
    @FXML public void cargarRegistroBicicleta() { cargar("registroBicicleta.fxml"); }
    @FXML public void cargarRegistroMecanico() { cargar("registroMecanico.fxml"); }
    @FXML public void cargarMecanicosDisponibles() { cargar("mecanicosDisponibles.fxml"); }
    @FXML public void cargarOrdenServicio() { cargar("crearOrdenServicio.fxml"); }
    @FXML public void cargarHistorial() { cargar("historialServicios.fxml"); }
    @FXML public void cargarOrdenesDia() { cargar("buscarOrdenDia.fxml"); }
    private void cargar(String vista) {
        try { Node contenido = FXMLLoader.load(Main.class.getResource("view/" + vista)); contenedorVistas.getChildren().setAll(contenido); }
        catch (IOException e) { throw new IllegalStateException("No se pudo cargar la vista " + vista, e); }
    }
}
