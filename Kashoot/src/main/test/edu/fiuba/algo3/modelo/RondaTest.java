package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import edu.fiuba.algo3.modelo.formatos.Clasico;
import edu.fiuba.algo3.modelo.formatos.Parcial;
import edu.fiuba.algo3.modelo.formatos.Penalidad;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {

    @Test
    public void dadaUnaRondaConPreguntaVerdaderoOFalsoClasicoQueTerminaSeVerificanLosPuntajesDeLosJugadores(){

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

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

    @Test
    public void dadaUnaRondaConPreguntaVerdaderoOFalsoConPenalidadQueTerminaSeCalculanLosPuntajesYSonCorrectos(){

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionFalsa);
        opciones.add(opcionVerdadera);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

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
        assertEquals(-10, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dadaUnaRondaConPreguntaVMultipleChoiceConPenalidadQueTerminaSeCalculanLosPuntajesYSonCorrectos(){

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

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        Queue<Jugador> jugadores = new LinkedList<Jugador>();
        jugadores.add(unJugador);
        jugadores.add(otroJugador);

        Ronda ronda = new Ronda();
        ronda.agregarOpciones(opciones);
        ronda.agregarPregunta(unaPregunta);

        ronda.asignarPuntajes(jugadores);

        assertEquals(20, unJugador.getPuntajeAcumulado());
        assertEquals(-10, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dadaUnaRondaConPreguntaVerdaderoOFalsoConPenalidadYMultiplicadorX2QueTerminaSeCalculanLosPuntajesYSonCorrectos(){

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionVerdadera);
        opciones.add(opcionFalsa);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.multiplicarX2(respuestaCorrecta);
        otroJugador.multiplicarX2(respuestaIncorrecta);

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        Queue<Jugador> jugadores = new LinkedList<Jugador>();
        jugadores.add(unJugador);
        jugadores.add(otroJugador);

        Ronda ronda = new Ronda();
        ronda.agregarOpciones(opciones);
        ronda.agregarPregunta(unaPregunta);

        ronda.asignarPuntajes(jugadores);

        Assertions.assertEquals(20, unJugador.getPuntajeAcumulado());
        Assertions.assertEquals(-20, otroJugador.getPuntajeAcumulado());

    }

    @Test
    public void dadaUnaRondaConPreguntaVerdaderoOFalsoConPenalidadYMultiplicadorX3QueTerminaSeCalculanLosPuntajesYSonCorrectos(){

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcionVerdadera);
        opciones.add(opcionFalsa);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.multiplicarX3(respuestaCorrecta);
        otroJugador.multiplicarX3(respuestaIncorrecta);

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        Queue<Jugador> jugadores = new LinkedList<Jugador>();
        jugadores.add(unJugador);
        jugadores.add(otroJugador);

        Ronda ronda = new Ronda();
        ronda.agregarOpciones(opciones);
        ronda.agregarPregunta(unaPregunta);

        ronda.asignarPuntajes(jugadores);

        Assertions.assertEquals(30, unJugador.getPuntajeAcumulado());
        Assertions.assertEquals(-30, otroJugador.getPuntajeAcumulado());

    }

    @Test
    public void dadaUnaRondaConPreguntaMultipleChoiceConPuntajeParcialSeRespondeYLosPuntajesSonCorrectos(){

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

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        ronda.asignarPuntajes(jugadores);

        assertEquals(20, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());

    }

    @Test
    public void dadaUnaRondaConPreguntaMultipleChoiceConPuntajeParcialSeRespondeConUnaExclusividadYLosPuntajesSonCorrectos(){

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

        ronda.jugarConExclusividad();
        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        ronda.asignarPuntajes(jugadores);

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());

    }

    @Test
    public void dadaUnaRondaConPreguntaMultipleChoiceConPuntajeParcialSeRespondeConDosExclusividadesYLosPuntajesSonCorrectos(){
        
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

        ronda.jugarConExclusividad();
        ronda.jugarConExclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        ronda.asignarPuntajes(jugadores);

        assertEquals(80, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test 
    public void dadaUnaRondaQueSoloFueJugadaPorUnJugadorSePreguntaSiLaRondaContinuaYDevuelveQueSi(){
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

        Ronda ronda = new Ronda();
        ronda.agregarOpciones(opciones);
        ronda.agregarPregunta(unaPregunta);

        ronda.aumentarTurnos();

        assertTrue(ronda.rondaContinua());

    }

    @Test
    public void dadaUnaRondaJugadaPorAmbosJugadoresSePreguntaSiLaRondaContinuaYDevuelveQueNo(){
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

        Ronda ronda = new Ronda();
        ronda.agregarOpciones(opciones);
        ronda.agregarPregunta(unaPregunta);

        ronda.aumentarTurnos();
        ronda.aumentarTurnos();

        assertFalse(ronda.rondaContinua());
    }


}
