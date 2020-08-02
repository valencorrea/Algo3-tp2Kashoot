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
        return this.formato.calcularPuntaje(respuestaJugador.obtenerTamanio(), cantidadAciertos, cantidadCorrectas);
    }

    private int cantidadCorrectas(Respuesta respuestaCorrecta) {
        return respuestaCorrecta.obtenerTamanio();
    }
}