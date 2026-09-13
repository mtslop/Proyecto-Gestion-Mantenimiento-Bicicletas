package co.uniquindio.edu.poo;

import co.uniquindio.edu.poo.model.Taller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/** Punto de entrada de la aplicación JavaFX basada en FXML. */
public class Main extends Application {
    private static final Taller TALLER = new Taller("Taller de Bicicletas");
    public static Taller getTaller() { return TALLER; }
    @Override public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/inicio.fxml"));
        stage.setScene(new Scene(loader.load(), 1050, 680));
        stage.setMinWidth(900); stage.setMinHeight(600); stage.setTitle("Taller de bicicletas"); stage.show();
    }
    public static void main(String[] args) { launch(args); }
}
