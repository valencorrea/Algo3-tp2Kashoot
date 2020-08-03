package edu.fiuba.algo3.modelo;

public abstract class TipoFormato {

    protected int puntaje = 10;

    public abstract int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertosJugador, int cantidadCorrectas);
}
