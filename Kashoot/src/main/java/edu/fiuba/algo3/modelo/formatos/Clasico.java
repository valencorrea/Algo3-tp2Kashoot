package edu.fiuba.algo3.modelo.formatos;

public class Clasico extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertosJugador, int cantidadCorrectas){

        if (cantidadCorrectas == cantidadAciertosJugador && cantidadOpcionesJugador == cantidadCorrectas){
            return (cantidadCorrectas * this.puntaje);
        }

        return 0;
    }
    @Override
    public boolean puedeMultiplicar(){
        return false;
    }
}
