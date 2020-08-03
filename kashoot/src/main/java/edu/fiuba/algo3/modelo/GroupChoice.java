package edu.fiuba.algo3.modelo;

public class GroupChoice extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador, int cantidadAciertosJugador, int cantidadCorrectas) {
        if(cantidadOpcionesJugador != cantidadCorrectas){
            return 0;
        }

        if (cantidadAciertosJugador == cantidadCorrectas || cantidadAciertosJugador == 0) {
            return this.puntaje;
        }
        return 0;
    }
}
