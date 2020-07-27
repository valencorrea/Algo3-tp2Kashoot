package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaIncorrectaTest {

    @Test
    public void unTipoIncorrectoNoEsCorrecto(){
        assert(!new OpcionIncorrecta().soyCorrecta());
    }

    @Test
    public void unTipoIncorrectoResta10Puntos(){
        assertEquals(new OpcionIncorrecta().getPuntos(), -10);
    }
}