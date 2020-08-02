package edu.fiuba.algo3.modelo;

public class Penalidad extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertosJugador, int cantidadCorrectas){

        return this.puntaje * ((cantidadAciertosJugador) - (cantidadOpcionesJugador - cantidadAciertosJugador));

    }
}
