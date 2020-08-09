package edu.fiuba.algo3.modelo.formatos;

public class Penalidad extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertosJugador, int cantidadCorrectas){

        return this.puntaje * ((cantidadAciertosJugador) - (cantidadOpcionesJugador - cantidadAciertosJugador));

    }
    @Override
    public boolean puedeMultiplicar(){
        return true;
    }
}
