package edu.fiuba.algo3.modelo;

public class GroupChoice extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador, int cantidadAciertosJugador, int cantidadCorrectas) {

        if (cantidadOpcionesJugador == cantidadCorrectas && cantidadAciertosJugador == cantidadCorrectas || cantidadAciertosJugador == 0) {
            return this.puntaje;
        }
        return 0;
    }
    @Override
    public boolean puedeMultiplicar(){
        return false;
    }
}
