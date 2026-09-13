package co.uniquindio.edu.poo.prueba;

import co.uniquindio.edu.poo.model.Bicicleta;
import co.uniquindio.edu.poo.model.EstadoOrden;
import co.uniquindio.edu.poo.model.OrdenServicio;
import co.uniquindio.edu.poo.model.Tarea;
import co.uniquindio.edu.poo.model.TipoBicicleta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/** Pruebas unitarias para la clase Orden Servicio. */
class OrdenServicioTest {

    private OrdenServicio orden;

    @BeforeEach
    void inicializarOrden() {
        Bicicleta bicicleta = new Bicicleta("Ruta Endurance", "Rojo", "Giant", "BIC-100",
                2022, TipoBicicleta.RUTA);
        orden = new OrdenServicio("ORD-100", "Revision periodica", bicicleta);
    }

    @Test
    @DisplayName("Calcular la mano de obra suma correctamente el costo de todas las tareas")
    void testCalcularManoObraSumaCorrecta() {
        orden.getListaTareas().add(new Tarea("Ajuste de frenos", 50000.0));
        orden.getListaTareas().add(new Tarea("Cambio de cadena", 30000.0));
        orden.getListaTareas().add(new Tarea("Lubricacion general", 20000.0));

        assertEquals(100000.0, orden.calcularManoObra());
    }

    @Test
    @DisplayName("Calcular el costo total de la orden coincide con la mano de obra y actualiza el atributo")
    void testCalcularCostoTotalConTareasRegistradas() {
        orden.getListaTareas().add(new Tarea("Cambio de llanta", 40000.0));
        orden.getListaTareas().add(new Tarea("Centrado de rines", 60000.0));

        double costoTotal = orden.calcularCostototal();

        assertEquals(100000.0, costoTotal);
        assertEquals(100000.0, orden.getCostoTotal());
    }

    @Test
    @DisplayName("Calcular la mano de obra de una orden sin tareas retorna cero")
    void testCalcularManoObraSinTareasRetornaCero() {
        assertEquals(0.0, orden.calcularManoObra());
    }

    @Test
    @DisplayName("Cambiar el estado de la orden actualiza correctamente su estado actual")
    void testCambiarEstadoOrdenActualizaEstado() {
        assertEquals(EstadoOrden.RECIBIDA, orden.getEstado());

        orden.cambiarEstadoOrden(EstadoOrden.ENPROCESO);

        assertEquals(EstadoOrden.ENPROCESO, orden.getEstado());
        assertNotEquals(EstadoOrden.RECIBIDA, orden.getEstado());
    }
}
