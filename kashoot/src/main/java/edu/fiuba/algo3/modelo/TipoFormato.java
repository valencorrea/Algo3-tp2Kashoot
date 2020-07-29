package edu.fiuba.algo3.modelo;

public abstract class TipoFormato {

    protected int puntaje = 10;//preguntar si es mejor constante

    public abstract int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertos, int cantidadCorrectas);
}
