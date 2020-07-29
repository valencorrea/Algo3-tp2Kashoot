package edu.fiuba.algo3.modelo;

public class Parcial extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertos, int cantidadCorrectas){

        if((cantidadCorrectas == cantidadOpcionesJugador && (cantidadCorrectas - cantidadAciertos) != 0) | (cantidadOpcionesJugador-cantidadAciertos)>0){
            return 0;
        }

        return this.puntaje * cantidadAciertos;
    }
}

