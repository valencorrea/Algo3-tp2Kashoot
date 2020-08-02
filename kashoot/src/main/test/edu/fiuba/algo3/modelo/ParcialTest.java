package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParcialTest {
    @Test
    public void calcularPuntajeConDosOpcionesCorrectasDe3DevuelveElPuntajeCCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 2;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(20,resultado);
    }
    @Test
    public void calcularPunatjeConOpcionesCorrectasEIncorrectasDevuelveElPuntajeCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 2;
        int cantidadAciertos = 1;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0,resultado);
    }
    @Test
    public void calcularPunatjeConOpcionesCorrectasDevuelveElPuntajeCCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 3;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(30,resultado);
    }


}