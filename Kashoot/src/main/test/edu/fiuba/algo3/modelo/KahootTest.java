package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.formatos.Parcial;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class KahootTest {
/*
    @Test
    public void se(){


actualizarJugadorActual
obtenerJugadorActual
actualizar
jugarRondaConExclusividad
terminoJuego

    }

*/
    @Test
    public void luegoDeQueJuegueUnoDeLosJugadoresSeActualizaKashootYSeActualizaCorrectamente(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Ronda ronda = new Ronda();

        Kashoot kashoot = new Kashoot();

        kashoot.agregarJugadores(jugador1,jugador2);
        kashoot.agregarRonda(ronda);

        kashoot.actualizar();

        assertFalse(kashoot.terminoJuego());
        assertEquals(jugador2,kashoot.obtenerJugadorActual());
    }

    @Test
    public void luegoDeQueJueganAmbosJugadoresConSoloUnaRondaSeActualizaKashootYSeTerminaElJuego(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Ronda ronda = new Ronda();

        Kashoot kashoot = new Kashoot();

        kashoot.agregarJugadores(jugador1,jugador2);
        kashoot.agregarRonda(ronda);

        kashoot.actualizar();
        kashoot.actualizar();

        assertTrue(kashoot.terminoJuego());
    }

    @Test
    public void luegoDeQueJueganAmbosJugadoresTodasLasRondasSeActualizaKashootYSeTerminaElJuego(){
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Ronda ronda1 = new Ronda();
        Ronda ronda2 = new Ronda();
        Ronda ronda3 = new Ronda();

        Kashoot kashoot = new Kashoot();

        kashoot.agregarJugadores(jugador1,jugador2);
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
/*
    @Test
    public void seJuegaUnaRondaConExclusividadYLosPuntajesDeAmbosJugadoresSonCorrectosCorrectos(){

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

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
        jugadores.add(unJugador);
        jugadores.add(otroJugador);

        Ronda ronda = new Ronda();
        ronda.agregarOpciones(opciones);
        ronda.agregarPregunta(unaPregunta);

        kashoot.
        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        ronda.asignarPuntajes(jugadores);

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());

    }*/
}
