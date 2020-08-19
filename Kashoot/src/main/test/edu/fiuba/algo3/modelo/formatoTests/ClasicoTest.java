package edu.fiuba.algo3.modelo.formatoTests;

import edu.fiuba.algo3.modelo.formatos.Clasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClasicoTest {

    @Test
    public void calcularPuntajeConOpcionesCorrectasDevuelveElPuntajeCorrecto(){
        Clasico clasico = new Clasico();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 3;
        int cantidadCorrectas = 3;
        int resultado = clasico.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(30,resultado);
    }

    @Test
    public void calcularPuntajeConUnaOpcionCorrectaYUnaIncorrectaDevuelveElPuntajeCorrecto(){
        Clasico clasico = new Clasico();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = clasico.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0,resultado);
    }

    @Test
    public void calcularPuntajeConTresCorrectasJugadorSeleccionaDosBienYUnaMal(){
        Clasico clasico = new Clasico();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = clasico.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0,resultado);
    }

    @Test
    public void calcularPuntajeConOpcionesJugadorNoContestaNadaSuPuntajeEs0(){
        Clasico clasico = new Clasico();
        int cantidadOpcionesJugador = 0;
        int cantidadAciertos = 0;
        int cantidadCorrectas = 3;
        int resultado = clasico.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0, resultado);
    }

}