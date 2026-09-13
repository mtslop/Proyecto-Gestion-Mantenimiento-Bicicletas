package co.uniquindio.edu.poo.controller;
import co.uniquindio.edu.poo.Main;
import co.uniquindio.edu.poo.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.*;
public class OrdenServicioController extends ControladorBase {
 @FXML private TextField txtCodigo,txtMotivoIngreso,txtFechaIngreso,txtHoraIngreso,txtDiagnostico;
 @FXML private ComboBox<Bicicleta> cmbBicicleta; @FXML private ComboBox<Mecanico> cmbMecanico; @FXML private ComboBox<EstadoOrden> cmbEstado;
 @FXML public void initialize(){cmbBicicleta.setItems(FXCollections.observableArrayList(Main.getTaller().getListaBicicletas()));cmbMecanico.setItems(FXCollections.observableArrayList(Main.getTaller().getListaMecanicos()));cmbEstado.setItems(FXCollections.observableArrayList(EstadoOrden.values()));cmbEstado.setValue(EstadoOrden.RECIBIDA);}
 @FXML private void handleCrearOrden(){try{requerido(txtCodigo,txtMotivoIngreso);if(cmbBicicleta.getValue()==null||cmbMecanico.getValue()==null)throw new IllegalArgumentException("Seleccione bicicleta y mecánico.");if(Main.getTaller().buscarOrdenPorCodigo(txtCodigo.getText().trim())!=null)throw new IllegalArgumentException("Ese código ya está registrado.");OrdenServicio o=new OrdenServicio(txtCodigo.getText().trim(),txtMotivoIngreso.getText().trim(),cmbBicicleta.getValue());o.setMecanico(cmbMecanico.getValue());o.setEstado(cmbEstado.getValue());o.setDiagnostico(txtDiagnostico.getText().trim());if(!txtFechaIngreso.getText().isBlank())o.setHoraIngreso(LocalDateTime.of(LocalDate.parse(txtFechaIngreso.getText().trim()),txtHoraIngreso.getText().isBlank()?LocalTime.now():LocalTime.parse(txtHoraIngreso.getText().trim())));Main.getTaller().registrarOrdenServicio(o);mensaje(Alert.AlertType.INFORMATION,"Orden creada.");}catch(Exception e){mensaje(Alert.AlertType.ERROR,"Revise los datos. Fecha: AAAA-MM-DD y hora: HH:MM.");}}
}
