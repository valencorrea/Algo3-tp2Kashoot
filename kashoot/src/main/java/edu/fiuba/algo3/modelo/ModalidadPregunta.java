package edu.fiuba.algo3.modelo;

public class ModalidadPregunta {

    private TipoFormato formato;

    public ModalidadPregunta(TipoFormato unFormato){
        this.formato = unFormato;
    }

    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertos, int cantidadCorrectas){
        return this.formato.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);
    }
}
