package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {

    @Test
    public void preguntaVerdaderoFalsoClasicoSeCreaIndicandoLaRespuestaCorrecta(){

        String contenidoCorrecto = "hola soy correcta";

        Respuesta respuestaCorrecta = new Respuesta(new RespuestaCorrecta(), contenidoCorrecto);
        Respuesta respuestaIncorrecta = new Respuesta(new RespuestaIncorrecta(), "soy incorrecta :c");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        respuestas.add(respuestaIncorrecta);
        respuestas.add(respuestaCorrecta);

        Pregunta pregunta = new Pregunta(new VerdaderoFalso(new Clasico()), respuestas, "hola soy una pregunta??");
        String contenidoObtenido = pregunta.getCorrecta().getContenido();


        assert(contenidoCorrecto.equals(contenidoObtenido));

    }
    @Test
    public void seQuiereBuscarUnContenidoEntoncesSeraElCorrecto(){

        String contenidoCorrecto = "soy correcto";
        String contenidoIncorrecto = "soy incorrecto";
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();



        Respuesta unaRespuestaCorrecta = new Respuesta(new RespuestaCorrecta(),contenidoCorrecto);
        Respuesta unaRespuestaIncorrecta = new Respuesta(new RespuestaIncorrecta(),contenidoIncorrecto);
        respuestas.add(unaRespuestaIncorrecta);
        respuestas.add(unaRespuestaCorrecta);
        Pregunta unaPregunta = new Pregunta(new VerdaderoFalso(new Clasico()), respuestas, "soy una pregunta");

        Respuesta respuestaABuscar = unaPregunta.buscarContenido(contenidoCorrecto);

        assertEquals(contenidoCorrecto, respuestaABuscar.getContenido());


    }
    @Test

    public void DadaUnPreguntaDelTipoVerdaderoOFalsoEnModoClasicoSeDevuelveElPuntaje(){

        String contenidoCorrecto = "soy correcto";
        String contenidoIncorrecto = "soy incorrecto";
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        Respuesta unaRespuestaCorrecta = new Respuesta(new RespuestaCorrecta(),contenidoCorrecto);
        Respuesta unaRespuestaIncorrecta = new Respuesta(new RespuestaIncorrecta(),contenidoIncorrecto);
        respuestas.add(unaRespuestaIncorrecta);
        respuestas.add(unaRespuestaCorrecta);
        Pregunta unaPregunta = new Pregunta(new VerdaderoFalso(new Clasico()), respuestas, "soy una pregunta");

        int resultado = unaPregunta.responder(contenidoCorrecto);
        int otroResultado = unaPregunta.responder(contenidoIncorrecto);

        assertEquals(resultado,10);
        assertEquals(otroResultado,0);

    }

}
