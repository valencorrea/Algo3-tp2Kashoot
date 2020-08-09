package edu.fiuba.algo3.modelo.formatos;

public class Parcial extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertosJugador, int cantidadCorrectas){

        if((cantidadCorrectas == cantidadOpcionesJugador && (cantidadCorrectas - cantidadAciertosJugador) != 0) | (cantidadOpcionesJugador-cantidadAciertosJugador)>0){
            return 0;
        }

        return this.puntaje * cantidadAciertosJugador;
    }
    @Override
    public boolean puedeMultiplicar(){
        return false;
    }
}

