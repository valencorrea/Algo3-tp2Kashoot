package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParcialTest {
    @Test
    public void calcularPunatjeConDosOpcionesCorrectasDe3DevuelveElPuntajeCCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 2;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(resultado,20);
    }
    @Test
    public void calcularPunatjeConOpcionesCorrectasEIncorrectasDevuelveElPuntajeCCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 2;
        int cantidadAciertos = 1;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(resultado,0);
    }
    @Test
    public void calcularPunatjeConOpcionesCorrectasDevuelveElPuntajeCCorrecto(){

        Parcial parcial = new Parcial();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 3;
        int cantidadCorrectas = 3;
        int resultado = parcial.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(resultado,30);
    }


}