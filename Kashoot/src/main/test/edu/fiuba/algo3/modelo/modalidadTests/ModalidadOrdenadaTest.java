package edu.fiuba.algo3.modelo.modalidadTests;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.ModalidadOrdenada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModalidadOrdenadaTest {

    @Test
    public void dadaUnaModalidadOrdenadaCuandoUnJugadorRespondeBienEntoncesSuPuntajeSeraElCorrecto(){

        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcion1);
        respuestaCorrecta.agregarOpcion(opcion2);
        respuestaCorrecta.agregarOpcion(opcion3);

        Respuesta respuestaUsuario = new Respuesta();
        respuestaUsuario.agregarOpcion(opcion1);
        respuestaUsuario.agregarOpcion(opcion2);
        respuestaUsuario.agregarOpcion(opcion3);

        ModalidadOrdenada modalidadOrdenada = new ModalidadOrdenada();
        int resultado = modalidadOrdenada.calcularPuntaje(respuestaUsuario,respuestaCorrecta);

        assertEquals(10,resultado);

    }
    @Test
    public void dadaUnaModalidadOrdenadaCuandoUnJugadorRespondeMalEntoncesSuPuntajeSeraElCorrecto(){

        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");
        Opcion opcion3 = new Opcion("opcion3");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcion1);
        respuestaCorrecta.agregarOpcion(opcion2);
        respuestaCorrecta.agregarOpcion(opcion3);

        Respuesta respuestaUsuario = new Respuesta();
        respuestaUsuario.agregarOpcion(opcion1);
        respuestaUsuario.agregarOpcion(opcion3);
        respuestaUsuario.agregarOpcion(opcion2);

        ModalidadOrdenada modalidadOrdenada = new ModalidadOrdenada();
        int resultado = modalidadOrdenada.calcularPuntaje(respuestaUsuario,respuestaCorrecta);

        assertEquals(0,resultado);

    }
}
