package edu.fiuba.algo3.modelo;

public abstract class TipoOpcion {

    protected int puntaje = 10;

    public abstract int calcularPuntaje(TipoFormato formatoPregunta);
}
