package edu.fiuba.algo3.modelo.modalidades;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;

public interface Modalidad {

    int calcularPuntaje(Respuesta respuestaJugador, Respuesta respuestaCorrecta);

    boolean puedeMultiplicar();
}
