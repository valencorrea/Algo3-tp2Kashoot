package edu.fiuba.algo3.modelo;

public class Clasico extends TipoFormato{

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertos, int cantidadCorrectas){

        if (cantidadCorrectas == cantidadAciertos){
            return (cantidadCorrectas * this.puntaje);
        }

        return 0;
    }
}
