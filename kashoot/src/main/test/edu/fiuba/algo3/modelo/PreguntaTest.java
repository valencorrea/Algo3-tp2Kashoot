package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {

    @Test
    public void preguntaVerdaderoFalsoClasicoSeCreaIndicandoLaRespuestaCorrecta() {

        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadPregunta(new Clasico()), "Soy pregunta?", opciones);

        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcionCorrecta);

        int puntosObtenidos = unaPregunta.responder(respuesta);

        assertEquals(10, puntosObtenidos);
    }

    @Test

    public void DadaUnPreguntaDelTipoVerdaderoOFalsoEnModoClasicoSeDevuelveElPuntaje() {

        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadPregunta(new Penalidad()), "Soy pregunta?", opciones);

        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcionCorrecta);

        //Respuesta otraRespuesta = new Respuesta();
        //otraRespuesta.agregarOpcion(opcionCorrecta);

        int resultado = unaPregunta.responder(respuesta);

        //  int otroResultado = unaPregunta.responder(otraRespuesta);

        assertEquals(10, resultado);
        //  assertEquals(0,otroResultado);

    }

    @Test

    public void seCreaUnaPreguntaDeVerdaderoFalsoConPenalidad() {

        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Pregunta unaPreguntaVoF = new Pregunta(new ModalidadPregunta(new Penalidad()), "Soy pregunta?", opciones);

        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcionCorrecta);

        int puntosObtenidos = unaPreguntaVoF.responder(respuesta);

        assertEquals(10, puntosObtenidos);

    }

    @Test
    public void SeCreaUnaPreguntaMultipleChoiceConFormatoClasico() {
        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion otraOpcionCorrecta = new Opcion(new OpcionCorrecta(), "SoyCorrecta");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");
        Opcion otraOpcionIncorrecta = new Opcion(new OpcionIncorrecta(), "SoyFalsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();

        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        opciones.add(otraOpcionCorrecta);
        opciones.add(otraOpcionIncorrecta);

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadPregunta(new Clasico()), "Soy una pregunta?", opciones);

        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcionCorrecta);
        respuesta.agregarOpcion(otraOpcionCorrecta);

        int puntosObtenidos = unaPreguntaMultipleChoice.responder(respuesta);

        assertEquals(20, puntosObtenidos);
    }

    @Test
    public void SeCreaUnaPreguntaMultipleChoiceConFormatoParcial(){
        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion otraOpcionCorrecta = new Opcion(new OpcionCorrecta(), "SoyCorrecta");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");
        Opcion otraOpcionIncorrecta = new Opcion(new OpcionIncorrecta(), "SoyFalsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();

        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        opciones.add(otraOpcionCorrecta);
        opciones.add(otraOpcionIncorrecta);

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadPregunta(new Parcial()), "Soy una pregunta?", opciones);

        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcionCorrecta);

        int puntosObtenidos = unaPreguntaMultipleChoice.responder(respuesta);

        assertEquals(10, puntosObtenidos);
    }
}