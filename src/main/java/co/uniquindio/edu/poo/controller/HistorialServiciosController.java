package co.uniquindio.edu.poo.controller;
import co.uniquindio.edu.poo.Main;
import co.uniquindio.edu.poo.model.OrdenServicio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.ReadOnlyStringWrapper;
public class HistorialServiciosController extends ControladorBase {
 @FXML private TextField txtSerialBusqueda; @FXML private TableView<OrdenServicio> tblHistorial; @FXML private TableColumn<OrdenServicio,String> colCodigo,colFecha,colMotivo,colEstado,colCosto;
 @FXML public void initialize(){colCodigo.setCellValueFactory(c->new ReadOnlyStringWrapper(c.getValue().getCodigo()));colFecha.setCellValueFactory(c->new ReadOnlyStringWrapper(c.getValue().getHoraIngreso().toLocalDate().toString()));colMotivo.setCellValueFactory(c->new ReadOnlyStringWrapper(c.getValue().getMotivoIngreso()));colEstado.setCellValueFactory(c->new ReadOnlyStringWrapper(c.getValue().getEstado().toString()));colCosto.setCellValueFactory(c->new ReadOnlyStringWrapper(String.valueOf(c.getValue().getCostoTotal())));}
 @FXML private void handleBuscarHistorial(){tblHistorial.setItems(FXCollections.observableArrayList(Main.getTaller().obtenerHistorialServicios(txtSerialBusqueda.getText().trim())));}
}
