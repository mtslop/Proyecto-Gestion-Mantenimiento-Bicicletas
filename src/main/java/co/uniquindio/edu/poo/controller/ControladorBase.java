package co.uniquindio.edu.poo.controller;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
abstract class ControladorBase {
    void requerido(TextField... campos) { for (TextField campo : campos) if (campo.getText().isBlank()) throw new IllegalArgumentException("Complete todos los campos."); }
    void limpiar(TextField... campos) { for (TextField campo : campos) campo.clear(); }
    void mensaje(Alert.AlertType tipo, String texto) { Alert alerta = new Alert(tipo, texto); alerta.setHeaderText(null); alerta.showAndWait(); }
}
