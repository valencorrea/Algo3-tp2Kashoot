package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import edu.fiuba.algo3.modelo.formatos.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class JugadorTest {

    @Test
    public void jugadoresRespondenVerdaderoFalsoClasicoRecibenPuntajeCorrecto() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "El numero 1 es impar?", respuestaCorrecta);

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(10, unJugador.getPuntajeAcumulado());
        assertEquals(otroJugador.getPuntajeAcumulado(), 0);
    }

    @Test
    public void jugadoresRespondenVerdaderoFalsoConPenalidadRecibenPuntajeCorrecto() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "El numero dos es par?", respuestaCorrecta);

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(10, unJugador.getPuntajeAcumulado());
        assertEquals(-10, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadoresRespondenMultipleChoiceClasicoRecibenPuntajeCorrecto() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("Cuatro");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionCorrectaDos);
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "Que numeros son primos??", respuestaCorrecta);

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(20, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadoresRespondenMultipleChoiceParcialRecibenPuntajeCorrecto() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Jugador tercerJugador = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("cuatro");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionCorrectaDos);
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Respuesta respuestaTercerJugador = new Respuesta();
        respuestaTercerJugador.agregarOpcion(opcionCorrectaUno);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "Que numeros son primos?", respuestaCorrecta);

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);
        tercerJugador.responder(unaPregunta, respuestaTercerJugador);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();
        tercerJugador.asignarPuntajeRonda();

        assertEquals(20, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
        assertEquals(10, tercerJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadoresRespondenMultipleChoiceConPenalidadRecibenPuntajeCorrecto() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("cuatro");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "Que numeros son primos?", respuestaCorrecta);

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(20, unJugador.getPuntajeAcumulado());
        assertEquals(-10, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void UnjugadorEligeCorrectamenteLasOpcionesDeGroupChoiceParaCadaGrupoTomandoEncuentaElPrimerGrupoYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Rojo");
        Opcion opcionGrupo2_2 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();

        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaJugadorParaElGrupo1 = new Respuesta();

        respuestaJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        unJugador.responder(unaPregunta, respuestaJugadorParaElGrupo1);

        unJugador.asignarPuntajeRonda();

        assertEquals(10, unJugador.getPuntajeAcumulado());
    }

    @Test
    public void UnjugadorEligeIncorrectamenteLasOpcionesDeGroupChoiceParaElGrupo2YSeContabilizaCorrectamenteLosPuntos() {
        Jugador unJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Rojo");
        Opcion opcionGrupo2_2 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();

        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaJugadorParaElGrupo2 = new Respuesta();

        respuestaJugadorParaElGrupo2.agregarOpcion(opcionGrupo2_1);
        respuestaJugadorParaElGrupo2.agregarOpcion(opcionGrupo1_2);

        unJugador.responder(unaPregunta, respuestaJugadorParaElGrupo2);

        unJugador.asignarPuntajeRonda();

        assertEquals(0, unJugador.getPuntajeAcumulado());
    }

    @Test
    public void UnjugadorNoEligeNingunaOpcionParaGroupChoiceYSeContabilizaCorrectamenteLosPuntos() {
        Jugador unJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Rojo");
        Opcion opcionGrupo2_2 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();

        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaJugadorParaElGrupo2 = new Respuesta();

        unJugador.responder(unaPregunta, respuestaJugadorParaElGrupo2);

        unJugador.asignarPuntajeRonda();

        assertEquals(0, unJugador.getPuntajeAcumulado());
    }

    @Test
    public void UnjugadorEligeAlRevesLasRespuestasParaGroupChoiceYSeContabilizaCorrectamenteLosPuntos() {
        Jugador unJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("A");
        Opcion opcionGrupo1_2 = new Opcion("B");

        Opcion opcionGrupo2_1 = new Opcion("1");
        Opcion opcionGrupo2_2 = new Opcion("2");

        Respuesta respuestaCorrectaDeGrupo1 = new Respuesta();

        respuestaCorrectaDeGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeGrupo1.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Diferencia entre numeros y letras. Seleccione las letras", respuestaCorrectaDeGrupo1);

        Respuesta respuestaJugadorParaElGrupo1 = new Respuesta();

        respuestaJugadorParaElGrupo1.agregarOpcion(opcionGrupo2_1);
        respuestaJugadorParaElGrupo1.agregarOpcion(opcionGrupo2_2);

        unJugador.responder(unaPregunta, respuestaJugadorParaElGrupo1);

        unJugador.asignarPuntajeRonda();

        assertEquals(0,  unJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadorRespondeVerdaderoFalsoConPenalidadYMultiplicadorX2RecibePuntajeCorrecto() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta?", respuestaCorrecta);

        unJugador.multiplicarX2(respuestaCorrecta);
        otroJugador.multiplicarX2(respuestaIncorrecta);

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        Assertions.assertEquals(20, unJugador.getPuntajeAcumulado());
        Assertions.assertEquals(-20, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadorRespondeVerdaderoFalsoConPenalidadYMultiplicadorX3RecibePuntajeCorrecto() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.multiplicarX3(respuestaCorrecta);
        otroJugador.multiplicarX3(respuestaIncorrecta);

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        Assertions.assertEquals(30, unJugador.getPuntajeAcumulado());
        Assertions.assertEquals(-30, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadorEligeExclusividadYSeDuplicaSuPuntajeAlResponderCorrectamente() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta?", respuestaCorrecta);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);
        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(20, unJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadorEligeExclusividadYSeAnulaSuPuntajeAlResponderMal() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");
        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dosJugadoresEligenExclusividadYSeAnulaSuPuntajeAlResponderAmbosMal() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaIncorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        unaExclusividad.determinarPuntaje(unJugador,otroJugador,cantExclusividades);
        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void unJugadorEligeExclusividadYSeAnulaSuPuntajeAlResponderAmbosJugadoresBien() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Opcion opcionVerdadera = new Opcion("Verdadera");
        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaCorrecta);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void ambosJugadoresEligenExclusividadYUnoRespondeBien() {
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = 2;
        unJugador.usarExclusividad();
        otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaCorrecta);
        otroJugador.responder(unaPregunta, respuestaIncorrecta);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador,cantExclusividades);
        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void unJugadorEligeExclusividadYRespondeBienUnChoiceClasico() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("cuatro");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = respuestaCorrecta;

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "Que numeros son primos?", respuestaCorrecta);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador,cantExclusividades);
        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void unJugadorEligeExclusividadYRespondeMalUnChoiceClasico() {
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("cuatro");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionIncorrectaTres);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "Que numeros son primos?", respuestaCorrecta);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void unJugadorEligeExclusividadYRespondeMejorQueOtroEnFormatoParcial() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionCorrectaUno);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "Que numeros son primos?", respuestaCorrecta);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);
        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dosJugadoresEligenExclusividadesYRespondenAmbosBien() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionCorrectaUno);
        respuestaOtroJugador.agregarOpcion(opcionCorrectaDos);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "Que numeros son primos?", respuestaCorrecta);

        int cantExclusividades = 2;
        unJugador.usarExclusividad();
        otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dosJugadoresEligenExclusividadesYRespondenAmbosMal() {
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");
        Opcion opcionCorrectaCuatro = new Opcion("cuatro");


        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionIncorrectaTres);
        respuestaUnJugador.agregarOpcion(opcionCorrectaCuatro);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "Por cuales numeros puede dividirse el cuatro y resultar en un entero?", respuestaCorrecta);

        int cantExclusividades = 2;
        unJugador.usarExclusividad();
        otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugador);
        otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenUnaPreguntaTipoGroupChoiceUtilizandoUnaExclusividadYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo2_1);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);
        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(20, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenCorrectamenteUnaPreguntaTipoGroupChoiceUtilizandoUnaExclusividadYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        int cantExclusividades = 1;
        unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);

        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenUnaPreguntaTipoGroupChoiceUtilizandoDosExclusividadesYSeCalculaBienElPuntaje() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? Seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo2_1);

        int cantExclusividades = 2;
        unJugador.usarExclusividad();
        otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);
        unJugador.asignarPuntajeRonda();
        otroJugador.asignarPuntajeRonda();

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenCorrectamenteUnaPreguntaTipoGroupChoiceUtilizandoDosExclusividadesYSeCalculaBienElPuntaje() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        int cantExclusividades = 2;
        unJugador.usarExclusividad();
        otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenIncorrectamenteUnaPreguntaTipoGroupChoiceUtilizandoUnaExclusividadYSeCalculaBienElPuntaje() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? Seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);

        int cantExclusividades = 2;
        unJugador.usarExclusividad();
        otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador,cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenIncorrectamenteUnaPreguntaTipoGroupChoiceUtilizandoDosExclusividadesYSeCalculaBienElPuntaje() {

        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos? Seleccione los frios", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);

        int cantExclusividades = 2;
        unJugador.usarExclusividad();
        otroJugador.usarExclusividad();

        Exclusividad unaExclusividad = new Exclusividad();
        unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador,cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadorNoPuedeUsarExclusividadLuegoDeDosUsos(){

        Jugador unJugador = new Jugador();

        unJugador.usarExclusividad();
        unJugador.usarExclusividad();

        assertFalse(unJugador.tieneExclusividad());
    }

    @Test
    public void jugadorNoPuedeUsarMultiplicadorX2NiX3LuegoDeUnUso(){

        Jugador unJugador = new Jugador();

        Opcion opcionUno = new Opcion("uno");
        Opcion opcionDos = new Opcion("dos");
        Opcion opcionTres = new Opcion("tres");
        Opcion opcionCuatro = new Opcion("cuatro");


        Respuesta unaRespuesta = new Respuesta();
        unaRespuesta.agregarOpcion(opcionUno);
        unaRespuesta.agregarOpcion(opcionDos);

        Respuesta otraRespuesta = new Respuesta();
        otraRespuesta.agregarOpcion(opcionTres);
        otraRespuesta.agregarOpcion(opcionCuatro);

        unJugador.multiplicarX2(unaRespuesta);
        unJugador.multiplicarX3(otraRespuesta);

        assertFalse(unJugador.tieneMultiplicadorX2());
        assertFalse(unJugador.tieneMultiplicadorX3());

    }

}
