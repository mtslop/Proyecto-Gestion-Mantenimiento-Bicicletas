module Proyecto.Gestion.Mantenimiento.Bicicletas {
    requires javafx.controls;
    requires javafx.fxml;
    exports co.uniquindio.edu.poo;
    exports co.uniquindio.edu.poo.model;
    exports co.uniquindio.edu.poo.controller;
    opens co.uniquindio.edu.poo.controller to javafx.fxml;
}