package edu.fiuba.algo3.modelo;

public class ModalidadSinOrden implements Modalidad{

    private TipoFormato formato;

    public ModalidadSinOrden(TipoFormato unFormato){
        this.formato = unFormato;
    }

    @Override
    public int calcularPuntaje(Respuesta respuestaJugador, Respuesta respuestaCorrecta){

        int cantidadAciertos = respuestaCorrecta.calcularAciertos(respuestaJugador);
        int cantidadCorrectas = this.cantidadCorrectas(respuestaCorrecta);
        int cantidadOpcionesJugador = respuestaJugador.obtenerTamanio();

        return this.formato.calcularPuntaje(cantidadOpcionesJugador, cantidadAciertos, cantidadCorrectas);
    }

    private int cantidadCorrectas(Respuesta respuestaCorrecta) {
        return respuestaCorrecta.obtenerTamanio();
    }
}
