package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class JugadorTest {

    @Test
    public void jugadoresRespondenVerdaderoFalsoRecibenPuntajeCorrecto(){

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Respuesta respuestaCorrecta = new Respuesta(new RespuestaCorrecta(), "holis soy correcta :D");
        Respuesta respuestaIncorrecta = new Respuesta(new RespuestaIncorrecta(), "soy incorrecta :c");
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaCorrecta);
        respuestas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(new VerdaderoFalso(new Clasico()), respuestas, "hola soy una pregunta??");

        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta.getContenido());
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta.getContenido());

        assertEquals(unResultado, 10);
        assertEquals(otroResultado, 0);

    }

}
