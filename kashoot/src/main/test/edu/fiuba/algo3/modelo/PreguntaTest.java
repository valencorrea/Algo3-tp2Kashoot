package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {

    @Test
    public void preguntaVerdaderoFalsoClasicoSeCreaIndicandoLaRespuestaCorrectaSeRespondeMal(){

        Opcion opcionCorrecta = new Opcion("Verdadero");
        Opcion opcionIncorrecta = new Opcion("Falsa");

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionIncorrecta);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadPregunta(new Clasico()), "Soy pregunta?", respuestaCorrecta);

        int puntosObtenidos = unaPregunta.calcularPuntaje(respuestaIncorrecta);

        assertEquals(0, puntosObtenidos);
    }

    @Test

    public void DadaUnPreguntaDelTipoVerdaderoOFalsoEnModoClasicoSeDevuelveElPuntaje() {

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadPregunta(new Penalidad()), "Soy pregunta?", respuestaCorrecta);

        int resultado = unaPregunta.calcularPuntaje(respuestaCorrecta);

        assertEquals(10, resultado);
    }

    @Test

    public void seCreaUnaPreguntaDeVerdaderoFalsoConPenalidad() {

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPreguntaVoF = new Pregunta(new ModalidadPregunta(new Penalidad()), "Soy pregunta?", respuestaCorrecta);

        int puntosObtenidos = unaPreguntaVoF.calcularPuntaje(respuestaCorrecta);

        assertEquals(10, puntosObtenidos);

    }

    @Test
    public void SeCreaUnaPreguntaMultipleChoiceConFormatoClasicoYSeRespondeCorrectamente() {
        Opcion opcionCorrecta = new Opcion("Verdadero");
        Opcion otraOpcionCorrecta = new Opcion("SoyCorrecta");
        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadPregunta(new Clasico()), "Soy una pregunta?", respuestaCorrecta);

        Respuesta respuestaUsuario = new Respuesta();
        respuestaUsuario.agregarOpcion(opcionCorrecta);
        respuestaUsuario.agregarOpcion(otraOpcionCorrecta);

        int puntosObtenidos = unaPreguntaMultipleChoice.calcularPuntaje(respuestaUsuario);

        assertEquals(20, puntosObtenidos);
    }


    @Test
    public void SeCreaUnaPreguntaMultipleChoiceConFormatoParcialYSeRespondeCorrectamente() {
        Opcion opcionCorrecta = new Opcion("Verdadero");
        Opcion opcionIncorrecta = new Opcion("Soy incorrecta");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadPregunta(new Parcial()), "Soy una pregunta?", respuestaCorrecta);

        Respuesta respuestaUnUsuario = new Respuesta();
        respuestaUnUsuario.agregarOpcion(opcionCorrecta);
        respuestaUnUsuario.agregarOpcion(opcionIncorrecta);

        Respuesta respuestaOtroUsuario = new Respuesta();
        respuestaOtroUsuario.agregarOpcion(opcionCorrecta);

        int puntosDeUnUsuario = unaPreguntaMultipleChoice.calcularPuntaje(respuestaUnUsuario);
        int puntosDeOtroUsuario = unaPreguntaMultipleChoice.calcularPuntaje(respuestaOtroUsuario);

        assertEquals(0, puntosDeUnUsuario);
        assertEquals(10, puntosDeOtroUsuario);

    }

   @Test
    public void SeCreaUnaPreguntaMultipleChoiceConFormatoPenalidadYSeRespondeUnaCorrectaYUnaIncorrecta(){
        Opcion opcionCorrecta = new Opcion("Verdadero");
        Opcion otraOpcionCorrecta = new Opcion("SoyCorrecta");
        Opcion opcionIncorrecta = new Opcion("Falsa");

       Respuesta respuestaCorrecta = new Respuesta();
       respuestaCorrecta.agregarOpcion(opcionCorrecta);
       respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadPregunta(new Penalidad()), "Soy una pregunta?", respuestaCorrecta);

        Respuesta respuestaUsuario = new Respuesta();
        respuestaUsuario.agregarOpcion(opcionCorrecta);
        respuestaUsuario.agregarOpcion(opcionIncorrecta);

        int puntosObtenidos = unaPreguntaMultipleChoice.calcularPuntaje(respuestaUsuario);

        assertEquals(0, puntosObtenidos);
    }
    @Test
    public void SeCreaUnaPreguntaOrderedYRespondeCorrectamenteEnOrdenEntoncesElPuntajeSeraElCorrecto() {
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcion1);
        respuestaCorrecta.agregarOpcion(opcion2);
        respuestaCorrecta.agregarOpcion(opcion3);

        Pregunta unaPreguntaOrdered = new Pregunta((new ModalidadPregunta(new Ordered())), "soy una pregunta ordenada?", respuestaCorrecta);

        Respuesta respuestaUsuario = new Respuesta();
        respuestaUsuario.agregarOpcion(opcion1);
        respuestaUsuario.agregarOpcion(opcion2);
        respuestaUsuario.agregarOpcion(opcion3);

        Respuesta respuestaUsuario2 = new Respuesta();
        respuestaUsuario.agregarOpcion(opcion3);
        respuestaUsuario.agregarOpcion(opcion2);
        respuestaUsuario.agregarOpcion(opcion1);

        int puntajeUsuario1 = unaPreguntaOrdered.calcularPuntaje(respuestaUsuario);
        int puntajeUsuario2 = unaPreguntaOrdered.calcularPuntaje(respuestaUsuario2);

        assertEquals(10, puntajeUsuario1);
        assertEquals(0, puntajeUsuario2);
    }

}