package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModalidadPreguntaTest {

    @Test
     public void DadaUnaModalidadDelTipoClasicoSeDevuelveElPuntajeCorrectoParaDosJugadoresQueResponden(){
        int cantidadOpcionesJugador = 1;
        int cantidadAciertos = 1;
        int cantidadOpcionesCorrectas = 1;

        ModalidadSinOrden unaModalidad = new ModalidadSinOrden(new Clasico());
        int resultado = unaModalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos,cantidadOpcionesCorrectas);

        assertEquals(10,resultado);
    }

    @Test
    public void DadaUnaModalidadDelTipoPenalidadSeDevuelveElPuntajeCorrectoParaDosJugadoresQueResponden(){
        int cantidadOpcionesJugador = 1;
        int cantidadAciertos = 0;
        int cantidadOpcionesCorrectas = 1;

        ModalidadSinOrden unaModalidad = new ModalidadSinOrden(new Penalidad());
        int resultado = unaModalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos,cantidadOpcionesCorrectas);

        assertEquals(-10,resultado);
    }

    @Test
    public void DadaUnaModalidadDelTipoParcialSeDevuelveElPuntajeCorrectoParaDosJugadoresQueResponden(){
        int cantidadOpcionesJugador = 1;
        int cantidadAciertos = 1;
        int cantidadOpcionesCorrectas = 2;

        ModalidadSinOrden unaModalidad = new ModalidadSinOrden(new Parcial());
        int resultado = unaModalidad.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos,cantidadOpcionesCorrectas);

        assertEquals(10,resultado);
    }

/*
    @Test

    public void DadaUnaModalidadPreguntaDelTipoChoiceClasicoEntoncesElPuntajeSeraElCorrecto(){

        ModalidadPregunta modalidadChoice = new ModalidadPregunta(new Clasico());
        Opcion opcionCorrecta = new Opcion(new OpcionCorrecta(), "Verdadero");
        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcionCorrecta);

        int resultado = modalidadChoice.calcularPuntaje(respuesta);

        assertEquals(10,resultado);

    }
*/
}
