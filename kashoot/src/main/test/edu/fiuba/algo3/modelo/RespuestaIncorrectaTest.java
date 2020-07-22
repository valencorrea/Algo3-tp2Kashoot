package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaIncorrectaTest {

    @Test
    public void unTipoIncorrectoNoEsCorrecto(){
        assert(!new RespuestaIncorrecta().soyCorrecta());
    }

    @Test
    public void unTipoIncorrectoResta10Puntos(){
        assertEquals(new RespuestaIncorrecta().getPuntos(), -10);
    }
}