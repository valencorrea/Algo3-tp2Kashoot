package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class JugadorTest {

    @Test
    public void jugadoresRespondenVerdaderoFalsoRecibenPuntajeCorrecto(){

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion(new OpcionCorrecta(),"Verdadera");
        Opcion opcionFalsa = new Opcion(new OpcionIncorrecta(),"Falsa");
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionFalsa);
        opciones.add(opcionVerdadera);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadPregunta(new Clasico()),"hola soy una pregunta??",opciones,respuestaCorrecta);

        int unResultado = unJugador.responder(unaPregunta,respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta,respuestaIncorrecta);

        assertEquals(unResultado, 10);
        assertEquals(otroResultado, 0);

    }

}
