package edu.fiuba.algo3.modelo.formatoTests;

import edu.fiuba.algo3.modelo.formatos.Parcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcialTest {

    @Test
    public void calcularPuntajeConDosOpcionesCorrectasDe3DevuelveElPuntajeCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 2;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(20, resultado);
    }

    @Test
    public void calcularPuntajeConOpcionesCorrectasEIncorrectasDevuelveElPuntajeCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 2;
        int cantidadAciertos = 1;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0, resultado);
    }

    @Test
    public void calcularPuntajeConOpcionesCorrectasDevuelveElPuntajeCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 3;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(30, resultado);
    }

    @Test
    public void calcularPuntajeConOpcionesDelJugadorVaciasDevuelveElPuntajeCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 0;
        int cantidadAciertos = 0;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0, resultado);
    }

    @Test
    public void calcularPuntajeConTodasCorrectasYUnaIncorrectaDevuelveElPuntajeCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 4;
        int cantidadAciertos = 3;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0, resultado);
    }
}