package edu.fiuba.algo3.modelo.formatoTests;

import edu.fiuba.algo3.modelo.formatos.GroupChoice;
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

        assertEquals(10,resultado);
    }
    @Test
    public void DadaUnasOpcionesCorrectasSeEligeUnaIncorrectaYELPuntajeSeCalculaCorrectamente(){
        GroupChoice groupChoice = new GroupChoice();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 2;
        int cantidadCorrectas = 3;
        int resultado = groupChoice.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0,resultado);
    }
    @Test
    public void calcularPuntajeConCeroOpcionesCorrectasDeTresDevuelveElPuntajeCorrecto(){
        GroupChoice groupChoice = new GroupChoice();
        int cantidadOpcionesJugador = 3;
        int cantidadAciertos = 0;
        int cantidadCorrectas = 3;
        int resultado = groupChoice.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);

        assertEquals(0,resultado);
    }



}
