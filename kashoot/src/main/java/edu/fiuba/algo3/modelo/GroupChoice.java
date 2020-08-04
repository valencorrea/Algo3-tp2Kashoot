package edu.fiuba.algo3.modelo;

public class GroupChoice extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador, int cantidadAciertosJugador, int cantidadCorrectas) {

        if (cantidadAciertosJugador != cantidadCorrectas /*&& cantidadAciertosJugador == cantidadCorrectas || cantidadAciertosJugador == 0*/) {
            return 0;
        }
        return this.puntaje;
    }
    @Override
    public boolean puedeMultiplicar(){
        return false;
    }
}
