package co.uniquindio.edu.poo.controller;
import co.uniquindio.edu.poo.Main;
import co.uniquindio.edu.poo.model.Mecanico;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class RegistroMecanicoController extends ControladorBase {
 @FXML private TextField txtNombre,txtCodigoInterno,txtSueldo,txtEspecialidad;
 @FXML private void handleRegistrarMecanico(){try{requerido(txtNombre,txtCodigoInterno,txtSueldo,txtEspecialidad);if(Main.getTaller().buscarMecanicoPorCodigo(txtCodigoInterno.getText().trim())!=null)throw new IllegalArgumentException("Ese código ya está registrado.");Main.getTaller().registrarMecanico(new Mecanico(txtNombre.getText().trim(),txtCodigoInterno.getText().trim(),Double.parseDouble(txtSueldo.getText().trim()),txtEspecialidad.getText().trim()));limpiar(txtNombre,txtCodigoInterno,txtSueldo,txtEspecialidad);mensaje(Alert.AlertType.INFORMATION,"Mecánico registrado.");}catch(NumberFormatException e){mensaje(Alert.AlertType.ERROR,"El sueldo debe ser numérico.");}catch(IllegalArgumentException e){mensaje(Alert.AlertType.ERROR,e.getMessage());}}
}
