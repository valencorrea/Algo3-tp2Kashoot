package edu.fiuba.algo3.modelo;

public class ModalidadPregunta {

    private TipoFormato formato;

    public ModalidadPregunta(TipoFormato unFormato){
        this.formato = unFormato;
    }

    public int calcularPuntaje(Respuesta respuestaJugador, int cantidadAciertos, int cantidadCorrectas){
        //return respuestaJugador.calcularPuntaje(this.formato);
        return this.formato.calcularPuntaje(cantidadAciertos, cantidadCorrectas);
    }
}
