package co.uniquindio.edu.poo.model;

// TipoBicicleta.java

/**
 * Enum que clasifica el tipo de bicicleta que ingresa al taller.
 * Permite categorizar el trabajo y las tarifas segun el tipo de bicicleta.
 */
public enum TipoBicicleta {

    RUTA(0),
    MTB(1),
    URBANA(2),
    ELECTRICA(3);

    // Codigo numerico interno de cada tipo de bicicleta
    private int codigoTipo;

    TipoBicicleta(int codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public int getCodigoTipo() {
        return codigoTipo;
    }
}