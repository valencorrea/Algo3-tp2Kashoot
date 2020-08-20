package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import edu.fiuba.algo3.modelo.formatos.Parcial;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class KahootTest {

    @Test
    public void luegoDeQueJuegueUnoDeLosJugadoresSeActualizaKashootYSeActualizaCorrectamente() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Ronda ronda = new Ronda();

        Kashoot kashoot = new Kashoot();

        kashoot.agregarJugadores(jugador1, jugador2);
        kashoot.agregarRonda(ronda);

        kashoot.actualizar();

        assertFalse(kashoot.terminoJuego());
        assertEquals(jugador2, kashoot.obtenerJugadorActual());
    }

    @Test
    public void luegoDeQueJueganAmbosJugadoresConSoloUnaRondaSeActualizaKashootYSeTerminaElJuego() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Ronda ronda = new Ronda();

        Kashoot kashoot = new Kashoot();

        kashoot.agregarJugadores(jugador1, jugador2);
        kashoot.agregarRonda(ronda);

        kashoot.actualizar();
        kashoot.actualizar();

        assertTrue(kashoot.terminoJuego());
    }


    @Test
    public void luegoDeQueJueganAmbosJugadoresTodasLasRondasSeActualizaKashootYSeTerminaElJuego() {
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Ronda ronda1 = new Ronda();
        Ronda ronda2 = new Ronda();
        Ronda ronda3 = new Ronda();

        Kashoot kashoot = new Kashoot();

        kashoot.agregarJugadores(jugador1, jugador2);
        kashoot.agregarRonda(ronda1);
        kashoot.agregarRonda(ronda2);
        kashoot.agregarRonda(ronda3);

        /*juegan la primer ronda*/
        kashoot.actualizar();
        kashoot.actualizar();

        /*juegan la segunda ronda*/
        kashoot.actualizar();
        kashoot.actualizar();

        /*juegan la tercer ronda*/
        kashoot.actualizar();
        kashoot.actualizar();

        assertTrue(kashoot.terminoJuego());
    }

    @Test
    public void seJuegaUnaRondaConExclusividadYLosPuntajesDeAmbosJugadoresSonCorrectosCorrectos() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionCorrectaUno);
        opciones.add(opcionCorrectaDos);
        opciones.add(opcionIncorrectaTres);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = respuestaCorrecta;

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "hola soy una pregunta??", respuestaCorrecta);
        Queue<Jugador> jugadores = new LinkedList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Ronda ronda = new Ronda();
        ronda.agregarOpciones(opciones);
        ronda.agregarPregunta(unaPregunta);

        Kashoot kashoot = new Kashoot();

        kashoot.agregarJugadores(jugador1, jugador2);
        kashoot.agregarRonda(ronda);

        /*ambos jugadores juegan la ronda*/

        kashoot.jugarRondaConExclusividad(jugador1,unaPregunta, respuestaUnJugador);
        kashoot.jugarRondaSinExclusividad(jugador2,unaPregunta, respuestaOtroJugador);


        assertEquals(40, jugador1.getPuntajeAcumulado());
        assertEquals(0, jugador2.getPuntajeAcumulado());
    }
}


