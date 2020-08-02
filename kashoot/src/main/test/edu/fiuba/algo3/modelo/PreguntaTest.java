package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

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

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "Soy pregunta?", respuestaCorrecta);

        int puntosObtenidos = unaPregunta.calcularPuntaje(respuestaIncorrecta);

        assertEquals(0, puntosObtenidos);
    }

    @Test

    public void DadaUnPreguntaDelTipoVerdaderoOFalsoEnModoClasicoSeDevuelveElPuntaje() {

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "Soy pregunta?", respuestaCorrecta);

        int resultado = unaPregunta.calcularPuntaje(respuestaCorrecta);

        assertEquals(10, resultado);
    }

    @Test

    public void seCreaUnaPreguntaDeVerdaderoFalsoConPenalidad() {

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPreguntaVoF = new Pregunta(new ModalidadSinOrden(new Penalidad()), "Soy pregunta?", respuestaCorrecta);

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

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadSinOrden(new Clasico()), "Soy una pregunta?", respuestaCorrecta);

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

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadSinOrden(new Parcial()), "Soy una pregunta?", respuestaCorrecta);

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

        Pregunta unaPreguntaMultipleChoice = new Pregunta(new ModalidadSinOrden(new Penalidad()), "Soy una pregunta?", respuestaCorrecta);

        Respuesta respuestaUsuario = new Respuesta();
        respuestaUsuario.agregarOpcion(opcionCorrecta);
        respuestaUsuario.agregarOpcion(opcionIncorrecta);

        int puntosObtenidos = unaPreguntaMultipleChoice.calcularPuntaje(respuestaUsuario);

        assertEquals(0, puntosObtenidos);
    }
}