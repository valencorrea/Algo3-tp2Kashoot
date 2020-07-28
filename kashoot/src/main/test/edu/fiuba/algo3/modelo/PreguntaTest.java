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
    public void SeCreaUnaPreguntaMultipleChoiceConFormatoClasicoYSeRespondeCorrectamente() {
        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion otraOpcionCorrecta = new Opcion(new OpcionCorrecta(), "SoyCorrecta");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");
        Opcion otraOpcionIncorrecta = new Opcion(new OpcionIncorrecta(), "SoyFalsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();

        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
        opciones.add(otraOpcionCorrecta);
        opciones.add(otraOpcionIncorrecta);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadPregunta(new Clasico()), "Soy una pregunta?", opciones, respuestaCorrecta);

        Respuesta respuestaUsuario = new Respuesta();
        respuestaUsuario.agregarOpcion(opcionCorrecta);
        respuestaUsuario.agregarOpcion(otraOpcionCorrecta);

        int puntosObtenidos = unaPreguntaMultipleChoice.calcularPuntaje(respuestaUsuario);

        assertEquals(20, puntosObtenidos);
    }

   @Test
    public void SeCreaUnaPreguntaMultipleChoiceConFormatoPenalidadYSeRespondeUnaCorrectaYUnaIncorrecta(){
        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Opcion otraOpcionCorrecta = new Opcion(new OpcionCorrecta(), "SoyCorrecta");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(), "Falsa");
        Opcion otraOpcionIncorrecta = new Opcion(new OpcionIncorrecta(), "SoyFalsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();

        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

       Respuesta respuestaCorrecta = new Respuesta();
       respuestaCorrecta.agregarOpcion(opcionCorrecta);
       respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadPregunta(new Penalidad()), "Soy una pregunta?", opciones, respuestaCorrecta);

        Respuesta respuestaUsuario = new Respuesta();
        respuestaUsuario.agregarOpcion(opcionCorrecta);
        respuestaUsuario.agregarOpcion(opcionIncorrecta);

        int puntosObtenidos = unaPreguntaMultipleChoice.calcularPuntaje(respuestaUsuario);

        assertEquals(0, puntosObtenidos);
    }
}