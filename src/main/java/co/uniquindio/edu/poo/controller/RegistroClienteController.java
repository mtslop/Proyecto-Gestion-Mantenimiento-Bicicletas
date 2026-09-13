package co.uniquindio.edu.poo.controller;
import co.uniquindio.edu.poo.Main;
import co.uniquindio.edu.poo.model.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class RegistroClienteController extends ControladorBase {
 @FXML private TextField txtNombre,txtId,txtTelefono,txtDireccion;
 @FXML private void handleRegistrarCliente(){try{requerido(txtNombre,txtId,txtTelefono,txtDireccion);if(Main.getTaller().buscarClientePorId(txtId.getText().trim())!=null)throw new IllegalArgumentException("Ese ID ya está registrado.");Main.getTaller().registrarCliente(new Cliente(txtNombre.getText().trim(),txtId.getText().trim(),txtTelefono.getText().trim(),txtDireccion.getText().trim()));limpiar(txtNombre,txtId,txtTelefono,txtDireccion);mensaje(Alert.AlertType.INFORMATION,"Cliente registrado.");}catch(IllegalArgumentException e){mensaje(Alert.AlertType.ERROR,e.getMessage());}}
}
