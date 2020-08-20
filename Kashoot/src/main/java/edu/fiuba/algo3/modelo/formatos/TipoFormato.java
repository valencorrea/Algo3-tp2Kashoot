package edu.fiuba.algo3.modelo.formatos;

public abstract class TipoFormato {

    protected int puntaje = 10;

    public abstract int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertos, int cantidadCorrectas);

    public abstract boolean puedeMultiplicar();
}
