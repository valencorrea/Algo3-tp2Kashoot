package edu.fiuba.algo3.modelo;

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

        assertEquals(resultado,30);
    }
    @Test
    public void calcularPuntajeConUnaOpcionCorrectaYUnaIncorrectaDevuelveElPuntajeCorrecto(){
        Clasico clasico = new Clasico();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = clasico.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(resultado,0);
    }
    @Test
    public void calcularPuntajeConDosOpcionesCorrectasDeTresDevuelveElPuntajeCorrecto(){
        Clasico clasico = new Clasico();
        int cantidadOpcionesJugador = 2;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = clasico.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(resultado,0);
    }

}