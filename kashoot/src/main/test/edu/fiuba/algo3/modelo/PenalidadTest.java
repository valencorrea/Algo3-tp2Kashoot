package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenalidadTest {

    @Test
    public void seCalculaElPuntajeParaUnaRespuestaConTodasLasOpcionesAcertadasDevuelveElPuntajeCorrecto(){

        int cantidadOpcionesCorrectas = 3;
        int cantidadAciertosJugador = 3;
        int cantidadOpcionesJugador = 3;

        Penalidad penalidad = new Penalidad();

        int puntajeobtenido = penalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertosJugador,cantidadOpcionesCorrectas);

        assertEquals(30,puntajeobtenido);
    }

    @Test
    public void seCalculaElPuntajeParaUnaRespuestaConUnaOpcionDesacertadaDevuelveElPuntajeCorrecto(){

        int cantidadOpcionesCorrectas = 3;
        int cantidadAciertosJugador = 2;
        int cantidadOpcionesJugador = 3;

        Penalidad penalidad = new Penalidad();

        int puntajeobtenido = penalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertosJugador,cantidadOpcionesCorrectas);

        assertEquals(10,puntajeobtenido);
    }

    @Test
    public void seCalculaElPuntajeParaUnaRespuestaConMenosOpcionesSeleccionadasQueLasCorrectasDevuelveElPuntajeCorrecto(){

        int cantidadOpcionesCorrectas = 3;
        int cantidadAciertosJugador = 2;
        int cantidadOpcionesJugador = 2;

        Penalidad penalidad = new Penalidad();

        int puntajeobtenido = penalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertosJugador,cantidadOpcionesCorrectas);

        assertEquals(20,puntajeobtenido);
    }
}
