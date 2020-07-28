package edu.fiuba.algo3.modelo;

public abstract class TipoFormato {
    public abstract int puntajeIncorrecto();

    public abstract int calcularPuntaje(int cantidadAciertos, int cantidadCorrectas);
}
