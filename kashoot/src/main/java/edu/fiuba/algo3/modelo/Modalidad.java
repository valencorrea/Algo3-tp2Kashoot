package edu.fiuba.algo3.modelo;

public interface Modalidad {

    int calcularPuntaje(Respuesta respuestaJugador, Respuesta respuestaCorrecta);

    boolean puedeMultiplicar();
}
