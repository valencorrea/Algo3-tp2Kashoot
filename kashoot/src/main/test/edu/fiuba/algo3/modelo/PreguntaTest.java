package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {

    @Test
    public void preguntaVerdaderoFalsoClasicoSeCreaIndicandoLaRespuestaCorrectaSeRespondeMal() {

        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionIncorrecta);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadPregunta(new Clasico()), "Soy pregunta?", opciones, respuestaCorrecta);

        int puntosObtenidos = unaPregunta.calcularPuntaje(respuestaIncorrecta);

        assertEquals(0, puntosObtenidos);
    }

    @Test

    public void DadaUnPreguntaDelTipoVerdaderoOFalsoEnModoClasicoSeDevuelveElPuntaje() {

        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadPregunta(new Penalidad()), "Soy pregunta?", opciones, respuestaCorrecta);

        int resultado = unaPregunta.calcularPuntaje(respuestaCorrecta);

        assertEquals(10, resultado);
    }

    @Test

    public void seCreaUnaPreguntaDeVerdaderoFalsoConPenalidad() {

        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPreguntaVoF = new Pregunta(new ModalidadPregunta(new Penalidad()), "Soy pregunta?", opciones, respuestaCorrecta);

        int puntosObtenidos = unaPreguntaVoF.calcularPuntaje(respuestaCorrecta);

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

   /* @Test
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
    }*/
}