package edu.fiuba.algo3.modelo;

public class Penalidad extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertos, int cantidadCorrectas){

        return this.puntaje * ((cantidadAciertos) - (cantidadOpcionesJugador - cantidadAciertos));

    }
}
