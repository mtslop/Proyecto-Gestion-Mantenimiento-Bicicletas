package co.uniquindio.edu.poo.controller;
import co.uniquindio.edu.poo.Main;
import co.uniquindio.edu.poo.model.OrdenServicio;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import java.time.LocalDate;
public class OrdenDiaController extends ControladorBase {
 @FXML private TextField txtFechaBusqueda; @FXML private TableView<OrdenServicio> tblOrdenesFecha; @FXML private TableColumn<OrdenServicio,String> colCodigo,colHora,colMotivo,colEstado,colCosto;
 @FXML public void initialize(){colCodigo.setCellValueFactory(c->new ReadOnlyStringWrapper(c.getValue().getCodigo()));colHora.setCellValueFactory(c->new ReadOnlyStringWrapper(c.getValue().getHoraIngreso().toLocalTime().toString()));colMotivo.setCellValueFactory(c->new ReadOnlyStringWrapper(c.getValue().getMotivoIngreso()));colEstado.setCellValueFactory(c->new ReadOnlyStringWrapper(c.getValue().getEstado().toString()));colCosto.setCellValueFactory(c->new ReadOnlyStringWrapper(String.valueOf(c.getValue().getCostoTotal())));}
 @FXML private void handleBuscarPorFecha(){try{tblOrdenesFecha.setItems(FXCollections.observableArrayList(Main.getTaller().buscarOrdenesPorFecha(LocalDate.parse(txtFechaBusqueda.getText().trim()))));}catch(Exception e){mensaje(Alert.AlertType.ERROR,"Use el formato AAAA-MM-DD.");}}
}
