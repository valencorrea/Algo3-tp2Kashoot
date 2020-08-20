package edu.fiuba.algo3.modelo.modalidades;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import edu.fiuba.algo3.modelo.formatos.TipoFormato;

public class ModalidadSinOrden implements Modalidad {

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

    @Override
    public boolean puedeMultiplicar(){

        return this.formato.puedeMultiplicar();
    }

    private int cantidadCorrectas(Respuesta respuestaCorrecta) {
        return respuestaCorrecta.obtenerTamanio();
    }
}
