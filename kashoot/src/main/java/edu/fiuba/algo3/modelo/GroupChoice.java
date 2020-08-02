package edu.fiuba.algo3.modelo;

public class GroupChoice extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador, int cantidadAciertosJugador, int cantidadCorrectas) {

     if(cantidadAciertosJugador==cantidadCorrectas){
         return this.puntaje;
     }
}
