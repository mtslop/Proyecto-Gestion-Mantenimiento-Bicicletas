package co.uniquindio.edu.poo.controller;

import co.uniquindio.edu.poo.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;

public class InicioController {

    @FXML
    private StackPane contenedorVistas;

    @FXML
    public void initialize() {
        mostrarPantallaInicial();
    }

    private void mostrarPantallaInicial() {
        VBox inicioBox = new VBox(15);
        inicioBox.setAlignment(Pos.CENTER);

        Label lblTitulo = new Label("BIKE CARE");
        lblTitulo.setStyle("-fx-text-fill: #FF5722; -fx-font-size: 48px; -fx-font-weight: bold;");

        Label lblSubtitulo = new Label("Sistema de Gestión y Control de Taller");
        lblSubtitulo.setStyle("-fx-text-fill: #A0A5AD; -fx-font-size: 16px;");

        Label lblInstruccion = new Label("Selecciona una opción del menú lateral para comenzar");
        lblInstruccion.setStyle("-fx-text-fill: #5C626D; -fx-font-size: 13px; -fx-padding: 20 0 0 0;");

        inicioBox.getChildren().addAll(lblTitulo, lblSubtitulo, lblInstruccion);

        contenedorVistas.getChildren().setAll(inicioBox);
    }

    @FXML public void cargarRegistroCliente() { cargar("registroCliente.fxml"); }
    @FXML public void cargarRegistroBicicleta() { cargar("registroBicicleta.fxml"); }
    @FXML public void cargarRegistroMecanico() { cargar("registroMecanico.fxml"); }
    @FXML public void cargarMecanicosDisponibles() { cargar("mecanicosDisponibles.fxml"); }
    @FXML public void cargarOrdenServicio() { cargar("crearOrdenServicio.fxml"); }
    @FXML public void cargarHistorial() { cargar("historialServicios.fxml"); }
    @FXML public void cargarOrdenesDia() { cargar("buscarOrdenDia.fxml"); }
    private void cargar(String vista) {
       //Validación de carga de ventana
        try {

            System.out.println("Intentando cargar: view/" + vista);

            URL resource = Main.class.getResource("view/" + vista);

            if (resource == null) {
                System.err.println("ERROR CRÍTICO: No se encontró el archivo FXML en la ruta: view/" + vista);
                return;
            }

            FXMLLoader loader = new FXMLLoader(resource);
            Node contenido = loader.load();

            contenedorVistas.getChildren().setAll(contenido);
            System.out.println("Cargado con éxito: " + vista);

        } catch (Exception e) {
            System.err.println("Error interno al cargar la vista " + vista + ":");
            e.printStackTrace();
        }
    }
}