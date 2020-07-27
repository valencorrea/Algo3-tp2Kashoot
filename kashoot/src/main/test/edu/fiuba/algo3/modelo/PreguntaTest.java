package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {
/*
    @Test
    public void preguntaVerdaderoFalsoClasicoSeCreaIndicandoLaRespuestaCorrecta(){


        Pregunta pregunta = new Pregunta(new VerdaderoFalso(new Clasico()),"hola soy una pregunta??");
        pregunta.agregarRespuestaCorrecta("verdadero");
        pregunta.agregarRespuestaIncorrecta("Falsa");
        String contenidoObtenido = pregunta.getCorrecta().getContenido();

        assertEquals("verdadero",contenidoObtenido);

    }

    @Test
    public void seQuiereBuscarUnContenidoEntoncesSeraElCorrecto(){

        Pregunta unaPregunta = new Pregunta(new VerdaderoFalso(new Clasico()),"hola soy una pregunta??");
        unaPregunta.agregarRespuestaCorrecta("verdadero");
        unaPregunta.agregarRespuestaIncorrecta("Falsa");

        Respuesta respuestaABuscar = unaPregunta.buscarContenido("verdadero");

        assertEquals("verdadero", respuestaABuscar.getContenido());

    }

    @Test

    public void DadaUnPreguntaDelTipoVerdaderoOFalsoEnModoClasicoSeDevuelveElPuntaje(){

        Pregunta unaPregunta = new Pregunta(new VerdaderoFalso(new Clasico()),"hola soy una pregunta??");
        unaPregunta.agregarRespuestaCorrecta("verdadero");
        unaPregunta.agregarRespuestaIncorrecta("falsa");

        int resultado = unaPregunta.responder("verdadero");
        int otroResultado = unaPregunta.responder("falsa");

        assertEquals(10,resultado);
        assertEquals(0,otroResultado);

    }
*/
    @Test

    public void seCreaUnaPreguntaDeVerdaderoFalsoConPenalidad(){

        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(),"Verdadero");
        Opcion opcionIncorrecta = new Opcion(new OpcionIncorrecta(),"Falsa");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Pregunta unaPregunta = new Pregunta(new VerdaderoFalso(new Penalidad()),"Soy pregunta?",opciones);

        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcionCorrecta);

        int puntosObtenidos = unaPregunta.responder(respuesta);

        assertEquals(10,puntosObtenidos);

    }

}
