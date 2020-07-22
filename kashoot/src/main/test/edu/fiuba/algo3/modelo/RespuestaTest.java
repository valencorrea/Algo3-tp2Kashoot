package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTest {

    @Test
    public void unaRespuestaTipoCorrectaEsCorrecta(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new RespuestaCorrecta(), unContenido);

        assert(unaRespuesta.soyCorrecta());
    }

    @Test
    public void unaRespuestaTipoIncorrectaNoEsCorrecta(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new RespuestaIncorrecta(), unContenido);

        assert(!unaRespuesta.soyCorrecta());
    }

    @Test
    public void unaRespuestaDevuelveSuContenido(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new RespuestaIncorrecta(), unContenido);

        assertEquals(unaRespuesta.getContenido(),unContenido);
    }

    @Test
    public void unaRespuestaTipoCorrectaSuma10Puntos(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new RespuestaCorrecta(), unContenido);

        assertEquals(unaRespuesta.getPuntos(), 10);
    }

    @Test
    public void unaRespuestaTipoCorrectaResta10Puntos(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new RespuestaIncorrecta(), unContenido);

        assertEquals(unaRespuesta.getPuntos(), -10);
    }

}
