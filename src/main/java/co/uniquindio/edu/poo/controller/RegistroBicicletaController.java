package co.uniquindio.edu.poo.controller;
import co.uniquindio.edu.poo.Main;
import co.uniquindio.edu.poo.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
public class RegistroBicicletaController extends ControladorBase {
 @FXML private TextField txtNombreCliente,txtTelefonoCliente,txtMarca,txtModelo,txtColor,txtSerial,txtAnio;
 @FXML private void handleRegistrarBicicleta(){try{requerido(txtNombreCliente,txtMarca,txtModelo,txtColor,txtSerial,txtAnio);Cliente cliente=Main.getTaller().getListaClientes().stream().filter(c->c.getNombre().equalsIgnoreCase(txtNombreCliente.getText().trim())).findFirst().orElseThrow(()->new IllegalArgumentException("Primero registre el cliente o escriba su nombre exacto."));if(Main.getTaller().buscarBicicletaPorSerial(txtSerial.getText().trim())!=null)throw new IllegalArgumentException("Ese serial ya está registrado.");Bicicleta b=new Bicicleta(txtModelo.getText().trim(),txtColor.getText().trim(),txtMarca.getText().trim(),txtSerial.getText().trim(),Integer.parseInt(txtAnio.getText().trim()),TipoBicicleta.URBANA);Main.getTaller().registrarBicicleta(b,cliente);limpiar(txtNombreCliente,txtTelefonoCliente,txtMarca,txtModelo,txtColor,txtSerial,txtAnio);mensaje(Alert.AlertType.INFORMATION,"Bicicleta registrada.");}catch(NumberFormatException e){mensaje(Alert.AlertType.ERROR,"El año debe ser numérico.");}catch(IllegalArgumentException e){mensaje(Alert.AlertType.ERROR,e.getMessage());}}
}
