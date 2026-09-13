package co.uniquindio.edu.poo.controller;

import co.uniquindio.edu.poo.Main;
import co.uniquindio.edu.poo.model.Mecanico;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MecanicosDisponiblesController {
    @FXML private TableView<Mecanico> tblMecanicos;
    @FXML private TableColumn<Mecanico, String> colNombre;
    @FXML private TableColumn<Mecanico, String> colEspecialidad;
    @FXML private TableColumn<Mecanico, String> colCodigo;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getNombre()));
        colEspecialidad.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getEspecialidad()));
        colCodigo.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getCodigoInterno()));
        tblMecanicos.setItems(FXCollections.observableArrayList(Main.getTaller().obtenerMecanicosDisponibles()));
    }
}
