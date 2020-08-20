package edu.fiuba.algo3.modelo.formatos;

public class GroupChoice extends TipoFormato {

    @Override
    public int calcularPuntaje(int cantidadOpcionesJugador, int cantidadAciertosJugador, int cantidadCorrectas) {

        if (cantidadAciertosJugador != cantidadCorrectas ) {
            return 0;
        }
        return this.puntaje;
    }
    @Override
    public boolean puedeMultiplicar(){
        return false;
    }
}
