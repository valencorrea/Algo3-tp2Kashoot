package edu.fiuba.algo3.modelo;

public class Clasico extends TipoFormato{

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertosJugador, int cantidadCorrectas){

        if (cantidadCorrectas == cantidadAciertosJugador){
            return (cantidadCorrectas * this.puntaje);
        }

        return 0;
    }
    @Override
    public boolean puedeMultiplicar(){
        return false;
    }
}
