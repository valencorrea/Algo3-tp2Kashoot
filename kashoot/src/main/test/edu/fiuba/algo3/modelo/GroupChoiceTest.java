package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void DadaCuatroOpcionesElJugadorColocaCorrectamenteLasOpcionesEnLosGruposCorrespondientes(){
        GroupChoice groupChoice = new GroupChoice();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 3;
        int cantidadCorrectas = 3;
        int resultado = groupChoice.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(resultado,10);
    }
    @Test
    public void calcularPuntajeConUnaOpcionCorrectaYUnaIncorrectaDevuelveElPuntajeCorrecto(){
        GroupChoice groupChoice = new GroupChoice();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = groupChoice.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(resultado,0);
    }
    @Test
    public void calcularPuntajeConDosOpcionesCorrectasDeTresDevuelveElPuntajeCorrecto(){
        GroupChoice groupChoice = new GroupChoice();
        int cantidadOpcionesJugador = 2;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = groupChoice.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(resultado,0);
    }


}
