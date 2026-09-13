package co.uniquindio.edu.poo.model;


public enum EstadoOrden {

    RECIBIDA(0),
    ENPROCESO(1),
    FINALIZADA(2),
    ENTREGADA(3);

    // Atributo interno que guarda el codigo numerico asociado a cada estado
    private int codigoEstado;

    // Constructor del enum: se ejecuta una sola vez por cada constante declarada
    EstadoOrden(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }
}