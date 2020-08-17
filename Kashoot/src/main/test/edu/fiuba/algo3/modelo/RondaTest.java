package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.formatos.Clasico;
import edu.fiuba.algo3.modelo.formatos.GroupChoice;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {

    @Test
    public void dadaUnaRondaQueTerminaSeVerificanLosPuntajesDeLosJugadores(){

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionFalsa);
        opciones.add(opcionVerdadera);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        Queue<Jugador> jugadores = new LinkedList<Jugador>();
        jugadores.add(unJugador);
        jugadores.add(otroJugador);

        Ronda ronda = new Ronda();
        ronda.agregarOpciones(opciones);
        ronda.agregarPregunta(unaPregunta);

        ronda.asignarPuntajes(jugadores);

        assertEquals(10, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

}
