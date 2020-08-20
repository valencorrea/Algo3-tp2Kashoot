package edu.fiuba.algo3.modelo.modalidadTests;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import edu.fiuba.algo3.modelo.formatos.Clasico;
import edu.fiuba.algo3.modelo.formatos.Parcial;
import edu.fiuba.algo3.modelo.formatos.Penalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModalidadSinOrdenTest {

    /*Tests formato clasico*/
    @Test
     public void DadaUnaModalidadDelTipoClasicoSeDevuelveElPuntajeCorrectoParaJugadorQueRespondeUnaBien(){
        ModalidadSinOrden modalidadChoiceParcial = new ModalidadSinOrden(new Clasico());

        Opcion opcionCorrecta = new Opcion("verde");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);;

        int puntaje = modalidadChoiceParcial.calcularPuntaje(respuestaJugador, respuestaCorrecta);

        assertEquals(10, puntaje);
    }

    @Test
    public void DadaUnaModalidadDelTipoClasicoSeDevuelveElPuntajeCorrectoParaJugadorQueRespondeDosBien(){
        ModalidadSinOrden modalidadChoiceParcial = new ModalidadSinOrden(new Clasico());

        Opcion opcionCorrecta = new Opcion("verde");
        Opcion otraOpcionCorrecta = new Opcion("rojo");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);
        respuestaJugador.agregarOpcion(otraOpcionCorrecta);

        int puntaje = modalidadChoiceParcial.calcularPuntaje(respuestaJugador, respuestaCorrecta);

        assertEquals(20, puntaje);
    }

    @Test
    public void DadaUnaModalidadDelTipoClasicoSeDevuelveElPuntajeCorrectoParaJugadorQueRespondeUnaBienUnaMal(){

        ModalidadSinOrden modalidadChoiceParcial = new ModalidadSinOrden(new Clasico());

        Opcion opcionCorrecta = new Opcion("verde");
        Opcion opcionIncorrecta = new Opcion("rojo");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);
        respuestaJugador.agregarOpcion(opcionIncorrecta);

        int puntaje = modalidadChoiceParcial.calcularPuntaje(respuestaJugador, respuestaCorrecta);

        assertEquals(0, puntaje);
    }

    @Test
    public void DadaUnaModalidadPreguntaDelTipoChoiceClasicoEntoncesElPuntajeSeraElCorrecto(){

        ModalidadSinOrden modalidadChoiceClasico = new ModalidadSinOrden(new Clasico());

        Opcion opcionCorrecta = new Opcion("verde");
        Opcion otraOpcionCorrecta = new Opcion("rojo");

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);
        respuestaJugador.agregarOpcion(otraOpcionCorrecta);

        int puntaje = modalidadChoiceClasico.calcularPuntaje(respuestaJugador, respuestaJugador);

        assertEquals(20, puntaje);

    }

    /*Tests formato penalidad*/
    @Test
    public void DadaUnaModalidadDelTipoPenalidadSeDevuelveElPuntajeCorrectoParaJugadorQueRespondeDosBien(){
        ModalidadSinOrden modalidadChoiceParcial = new ModalidadSinOrden(new Penalidad());

        Opcion opcionCorrecta = new Opcion("verde");
        Opcion otraOpcionCorrecta = new Opcion("rojo");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);
        respuestaJugador.agregarOpcion(opcionCorrecta);

        int puntaje = modalidadChoiceParcial.calcularPuntaje(respuestaJugador, respuestaCorrecta);

        assertEquals(20, puntaje);
    }

    @Test
    public void DadaUnaModalidadDelTipoPenalidadSeDevuelveElPuntajeCorrectoParaJugadorQueRespondeDosMal(){
        ModalidadSinOrden modalidadChoiceParcial = new ModalidadSinOrden(new Penalidad());

        Opcion opcionCorrecta = new Opcion("verde");
        Opcion otraOpcionCorrecta = new Opcion("rojo");
        Opcion opcionIncorrecta = new Opcion("azul");
        Opcion otraOpcionIncorrecta = new Opcion("amarillo");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionIncorrecta);
        respuestaJugador.agregarOpcion(otraOpcionIncorrecta);

        int puntaje = modalidadChoiceParcial.calcularPuntaje(respuestaJugador, respuestaCorrecta);

        assertEquals(-20, puntaje);
    }

    @Test
    public void DadaUnaModalidadDelTipoPenalidadSeDevuelveElPuntajeCorrectoParaJugadorQueRespondeUnaBienUnaMal(){
        ModalidadSinOrden modalidadChoiceParcial = new ModalidadSinOrden(new Penalidad());

        Opcion opcionCorrecta = new Opcion("verde");
        Opcion otraOpcionCorrecta = new Opcion("rojo");
        Opcion opcionIncorrecta = new Opcion("amarillo");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);
        respuestaJugador.agregarOpcion(opcionIncorrecta);

        int puntaje = modalidadChoiceParcial.calcularPuntaje(respuestaJugador, respuestaCorrecta);

        assertEquals(0, puntaje);
    }

    /*Tests formato parcial*/
    @Test
    public void DadaUnaModalidadDelTipoParcialSeDevuelveElPuntajeCorrectoCuandoContestaUnaBien(){
        ModalidadSinOrden modalidadChoiceParcial = new ModalidadSinOrden(new Parcial());

        Opcion opcionCorrecta = new Opcion("verde");
        Opcion otraOpcionCorrecta = new Opcion("rojo");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);

        int puntaje = modalidadChoiceParcial.calcularPuntaje(respuestaJugador, respuestaCorrecta);

        assertEquals(10, puntaje);
    }

    @Test
    public void DadaUnaModalidadDelTipoParcialSeDevuelveElPuntajeCorrectoCuandoContestaUnaBienUnaMal(){
        ModalidadSinOrden modalidadChoiceParcial = new ModalidadSinOrden(new Parcial());

        Opcion opcionCorrecta = new Opcion("verde");
        Opcion otraOpcionCorrecta = new Opcion("rojo");
        Opcion opcionIncorrecta = new Opcion("amarillo");

        Respuesta respuestaJugador = new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);
        respuestaJugador.agregarOpcion(opcionIncorrecta);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        respuestaCorrecta.agregarOpcion(otraOpcionCorrecta);

        int puntaje = modalidadChoiceParcial.calcularPuntaje(respuestaJugador, respuestaCorrecta);

        assertEquals(0, puntaje);
    }

}
