package edu.fiuba.algo3.modelo.formatoTests;

import edu.fiuba.algo3.modelo.formatos.Penalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenalidadTest {

    @Test
    public void seCalculaElPuntajeParaUnaRespuestaConTodasLasOpcionesAcertadasDevuelveElPuntajeCorrecto(){

        int cantidadOpcionesCorrectas = 3;
        int cantidadAciertosJugador = 3;
        int cantidadOpcionesJugador = 3;

        Penalidad penalidad = new Penalidad();

        int puntajeObtenido = penalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertosJugador,cantidadOpcionesCorrectas);

        assertEquals(30,puntajeObtenido);
    }

    @Test
    public void seCalculaElPuntajeParaUnaRespuestaConUnaOpcionIncorrectaDevuelveElPuntajeCorrecto(){

        int cantidadOpcionesCorrectas = 3;
        int cantidadAciertosJugador = 2;
        int cantidadOpcionesJugador = 3;

        Penalidad penalidad = new Penalidad();

        int puntajeObtenido = penalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertosJugador,cantidadOpcionesCorrectas);

        assertEquals(10,puntajeObtenido);
    }

    @Test
    public void seCalculaElPuntajeParaUnaRespuestaConMenosOpcionesSeleccionadasQueLasCorrectasDevuelveElPuntajeCorrecto(){

        int cantidadOpcionesCorrectas = 3;
        int cantidadAciertosJugador = 2;
        int cantidadOpcionesJugador = 2;

        Penalidad penalidad = new Penalidad();

        int puntajeObtenido = penalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertosJugador,cantidadOpcionesCorrectas);

        assertEquals(20,puntajeObtenido);
    }

    @Test
    public void seCalculaElPuntajePara2RespuestasBienDelJugadorYDosMalDeUnTotalDeDosCorrectasYDevuelveElPuntajeCorrecto(){

        int cantidadOpcionesCorrectas = 2;
        int cantidadAciertosJugador = 2;
        int cantidadOpcionesJugador = 4;

        Penalidad penalidad = new Penalidad();

        int puntajeObtenido = penalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertosJugador,cantidadOpcionesCorrectas);

        assertEquals(0,puntajeObtenido);
    }

    @Test
    public void seCalculaElPuntajePara2RespuestasIncorrectasDelJugadorDeUnaPreguntaConUnaCorrectaDevuelveElPuntajeCorrecto(){

        int cantidadOpcionesCorrectas = 2;
        int cantidadAciertosJugador = 0;
        int cantidadOpcionesJugador = 2;

        Penalidad penalidad = new Penalidad();

        int puntajeObtenido = penalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertosJugador,cantidadOpcionesCorrectas);

        assertEquals(-20,puntajeObtenido);
    }

}
