package co.uniquindio.edu.poo;

import co.uniquindio.edu.poo.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/** Punto de entrada de la aplicación JavaFX basada en FXML. */
public class Main extends Application {
    private static final Taller TALLER = new Taller("Taller de Bicicletas");
    static {
        cargarDatosEjemplo();
    }
    public static Taller getTaller() { return TALLER; }

    /** Datos iniciales para demostrar registros, asignaciones e historial. */
    private static void cargarDatosEjemplo() {
        Cliente ana = new Cliente("Ana María López", "1001001", "300123456", "Calle 10 # 20-15");
        Cliente juan = new Cliente("Juan David Pérez", "1001002", "301234567", "Carrera 15 # 8-30");
        Cliente sofia = new Cliente("Sofía Ramírez", "1001003", "302345678", "Calle 25 # 12-08");
        Cliente carlos = new Cliente("Carlos Gómez", "1001004", "303456789", "Avenida Bolívar # 34-20");
        TALLER.registrarCliente(ana); TALLER.registrarCliente(juan);
        TALLER.registrarCliente(sofia); TALLER.registrarCliente(carlos);

        Bicicleta ruta = new Bicicleta("Domane AL 2", "Rojo", "Trek", "SN-1001", 2023, TipoBicicleta.RUTA);
        Bicicleta mtb = new Bicicleta("Rockhopper", "Negro", "Specialized", "SN-1002", 2022, TipoBicicleta.MTB);
        Bicicleta urbana = new Bicicleta("City 7", "Azul", "GW", "SN-1003", 2024, TipoBicicleta.URBANA);
        Bicicleta electrica = new Bicicleta("E-Trail", "Gris", "Scott", "SN-1004", 2023, TipoBicicleta.ELECTRICA);
        TALLER.registrarBicicleta(ruta, ana); TALLER.registrarBicicleta(mtb, juan);
        TALLER.registrarBicicleta(urbana, sofia); TALLER.registrarBicicleta(electrica, carlos);

        Mecanico diego = new Mecanico("Diego Torres", "MEC-001", 1800000, "Frenos y transmisión");
        Mecanico laura = new Mecanico("Laura Sánchez", "MEC-002", 1950000, "Suspensión y MTB");
        Mecanico miguel = new Mecanico("Miguel Castro", "MEC-003", 2100000, "Bicicletas eléctricas");
        Mecanico paula = new Mecanico("Paula Ríos", "MEC-004", 1750000, "Mantenimiento general");
        TALLER.registrarMecanico(diego); TALLER.registrarMecanico(laura);
        TALLER.registrarMecanico(miguel); TALLER.registrarMecanico(paula);

        OrdenServicio orden1 = new OrdenServicio("ORD-001", "Ajuste de frenos", ruta);
        orden1.setMecanico(diego); orden1.setDiagnostico("Pastillas desgastadas");
        orden1.setEstado(EstadoOrden.FINALIZADA); orden1.setCostoTotal(85000);
        OrdenServicio orden2 = new OrdenServicio("ORD-002", "Mantenimiento de suspensión", mtb);
        orden2.setMecanico(laura); orden2.setDiagnostico("Lubricación de horquilla");
        orden2.setEstado(EstadoOrden.ENPROCESO); orden2.setCostoTotal(120000);
        OrdenServicio orden3 = new OrdenServicio("ORD-003", "Revisión del sistema eléctrico", electrica);
        orden3.setMecanico(miguel); orden3.setDiagnostico("Diagnóstico de batería");
        orden3.setEstado(EstadoOrden.RECIBIDA); orden3.setCostoTotal(0);
        TALLER.registrarOrdenServicio(orden1); TALLER.registrarOrdenServicio(orden2); TALLER.registrarOrdenServicio(orden3);
    }
    @Override public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/inicio.fxml"));
        stage.setScene(new Scene(loader.load(), 1050, 680));
        stage.setMinWidth(900); stage.setMinHeight(600); stage.setTitle("Taller de bicicletas"); stage.show();
    }
    public static void main(String[] args) { launch(args); }
}
