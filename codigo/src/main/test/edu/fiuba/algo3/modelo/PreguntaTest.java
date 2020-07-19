package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PreguntaTest {

    @Test
    public void preguntaVerdaderoFalsoClasicoSeCreaIndicandoLaRespuestaCorrecta(){

        String contenidoCorrecto = "hola soy correcta";

        Respuesta respuestaCorrecta = new Respuesta(new RespuestaCorrecta(), contenidoCorrecto);
        Respuesta respuestaIncorrecta = new Respuesta(new RespuestaIncorrecta(), "soy incorrecta :c");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        respuestas.add(respuestaIncorrecta);
        respuestas.add(respuestaCorrecta);

        Pregunta pregunta = new Pregunta(new VerdaderoFalso(), respuestas, "hola soy una pregunta??");
        String contenidoObtenido = pregunta.getCorrecta().getContenido();


        assert(contenidoCorrecto.equals(contenidoObtenido));

    }

}
