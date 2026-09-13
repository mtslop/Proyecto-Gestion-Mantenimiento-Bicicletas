
import co.uniquindio.edu.poo.model.Bicicleta;
import co.uniquindio.edu.poo.model.Cliente;
import co.uniquindio.edu.poo.model.TipoBicicleta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Pruebas unitarias para la clase Cliente*/
class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void inicializarCliente() {
        cliente = new Cliente("Sofia Ramirez", "C-500", "3201234567", "Calle 45 # 12-08");
    }

    @Test
    @DisplayName("Vincular una bicicleta la agrega a la lista personal del cliente")
    void testVincularBicicletaAgregadaALaListaDelCliente() {
        Bicicleta bicicleta = new Bicicleta("Urbana Confort", "Vinotinto", "GW", "BIC-200",
                2023, TipoBicicleta.URBANA);

        cliente.vincularBicicleta(bicicleta);

        assertEquals(1, cliente.getListaBicicletas().size());
        assertTrue(cliente.getListaBicicletas().contains(bicicleta));
        assertEquals(cliente, bicicleta.getCliente());
    }

    @Test
    @DisplayName("Vincular varias bicicletas al mismo cliente las agrega todas a su lista")
    void testVincularVariasBicicletasAlMismoCliente() {
        Bicicleta bicicleta1 = new Bicicleta("Ruta Carbono", "Negro", "Specialized",
                "BIC-201", 2022, TipoBicicleta.RUTA);
        Bicicleta bicicleta2 = new Bicicleta("Electrica Plegable", "Blanco", "Xiaomi",
                "BIC-202", 2024, TipoBicicleta.ELECTRICA);

        cliente.vincularBicicleta(bicicleta1);
        cliente.vincularBicicleta(bicicleta2);

        assertEquals(2, cliente.getListaBicicletas().size());
        assertTrue(cliente.getListaBicicletas().contains(bicicleta1));
        assertTrue(cliente.getListaBicicletas().contains(bicicleta2));
    }
}
