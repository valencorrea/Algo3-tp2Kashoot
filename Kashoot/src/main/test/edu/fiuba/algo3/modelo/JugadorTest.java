package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import edu.fiuba.algo3.modelo.formatos.Clasico;
import edu.fiuba.algo3.modelo.formatos.GroupChoice;
import edu.fiuba.algo3.modelo.formatos.Parcial;
import edu.fiuba.algo3.modelo.formatos.Penalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadorTest {
/*
    @Test
    public void jugadoresRespondenVerdaderoFalsoClasicoRecibenPuntajeCorrecto() {

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);

        assertEquals(unResultado, 10);
        assertEquals(otroResultado, 0);
    }

    @Test
    public void jugadoresRespondenVerdaderoFalsoConPenalidadRecibenPuntajeCorrecto() {

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);

        assertEquals(unResultado, 10);
        assertEquals(otroResultado, -10);
    }

    @Test
    public void jugadoresRespondenMultipleChoiceClasicoRecibenPuntajeCorrecto() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionCorrectaDos);
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugador);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugador);

        assertEquals(20, unResultado);
        assertEquals(0, otroResultado);
    }

    @Test
    public void jugadoresRespondenMultipleChoiceParcialRecibenPuntajeCorrecto() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");
        Jugador tercerJugador = new Jugador("pepesito");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

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

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "hola soy una pregunta??", respuestaCorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugador);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugador);
        int tercerResultado = tercerJugador.responder(unaPregunta, respuestaTercerJugador);

        assertEquals(20, unResultado);
        assertEquals(0, otroResultado);
        assertEquals(10, tercerResultado);
    }

    @Test
    public void jugadoresRespondenMultipleChoiceConPenalidadRecibenPuntajeCorrecto() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaUnJugador.agregarOpcion(opcionCorrectaUno);
        respuestaUnJugador.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugador);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugador);

        assertEquals(20, unResultado);
        assertEquals(-10, otroResultado);
    }


    @Test
    public void UnjugadorElijeCorrectamenteLasOpcionesDEGROUPCHOICEParaCadaGrupoTomandoEncuentaElPrimerGrupoYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Rojo");
        Opcion opcionGrupo2_2 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();

        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaJugadorParaElGrupo1 = new Respuesta();

        respuestaJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        int unResultado = unJugador.responder(unaPregunta, respuestaJugadorParaElGrupo1);
        assertEquals(unResultado, 10);
    }

    @Test
    public void UnjugadorElijeIncorrectamenteLasOpcionesDEGROUPCHOICEParaElGrupo2YSeContabilizaCorrectamenteLosPuntos() {
        Jugador unJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Rojo");
        Opcion opcionGrupo2_2 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();

        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaJugadorParaElGrupo2 = new Respuesta();

        respuestaJugadorParaElGrupo2.agregarOpcion(opcionGrupo2_1);
        respuestaJugadorParaElGrupo2.agregarOpcion(opcionGrupo1_2);

        unJugador.responder(unaPregunta, respuestaJugadorParaElGrupo2);
        int unResultado = unJugador.getPuntajeAcumulado();
        assertEquals(unResultado, 0);
    }

    @Test
    public void UnjugadorNoEligeNingunaOpcionParaGroupChoiceYSeContabilizaCorrectamenteLosPuntos() {
        Jugador unJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Rojo");
        Opcion opcionGrupo2_2 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();

        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaJugadorParaElGrupo2 = new Respuesta();

        unJugador.responder(unaPregunta, respuestaJugadorParaElGrupo2);
        int unResultado = unJugador.getPuntajeAcumulado();
        assertEquals(0, unResultado);
    }


    //La siguiente prueba falla porque hay que volver a repensar el modelos.
    @Test
    public void UnjugadorElijeAlRevesLasRespuestasParaGroupChoiceYSeContabilizaCorrectamenteLosPuntos() {
        Jugador unJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("A");
        Opcion opcionGrupo1_2 = new Opcion("B");

        Opcion opcionGrupo2_1 = new Opcion("1");
        Opcion opcionGrupo2_2 = new Opcion("2");

        Respuesta respuestaCorrectaDeGrupo1 = new Respuesta();

        respuestaCorrectaDeGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeGrupo1.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Diferencia Numeros de Letras", respuestaCorrectaDeGrupo1);

        Respuesta respuestaJugadorParaElGrupo1 = new Respuesta();

        respuestaJugadorParaElGrupo1.agregarOpcion(opcionGrupo2_1);
        respuestaJugadorParaElGrupo1.agregarOpcion(opcionGrupo2_2);

        unJugador.responder(unaPregunta, respuestaJugadorParaElGrupo1);
        int unResultado = unJugador.getPuntajeAcumulado();
        assertEquals(0, unResultado); //UPPPPPPPPPPPPSSSSSSSSSSSSS HAY QUE REPLANTEARLO! :PANIC:
    }


    @Test
    public void jugadorRespondeVerdaderoFalsoConPenalidadYMultiplicadorX2RecibePuntajeCorrecto() {

        Jugador unJugador = new Jugador("pepe");

        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.multiplicarX2(respuestaCorrecta);
        otroJugador.multiplicarX2(respuestaIncorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);

        Assertions.assertEquals(20, unResultado);
        Assertions.assertEquals(-20, otroResultado);
    }

    @Test
    public void jugadorRespondeVerdaderoFalsoConFortatoClasicoYMultiplicadorX2RecibePuntajeCorrecto() {

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.multiplicarX2(respuestaCorrecta);
        otroJugador.multiplicarX2(respuestaIncorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);

        Assertions.assertEquals(10, unResultado);
        Assertions.assertEquals(0, otroResultado);
    }

    @Test
    public void jugadorRespondeVerdaderoFalsoConPenalidadYMultiplicadorX3RecibePuntajeCorrecto() {

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.multiplicarX3(respuestaCorrecta);
        otroJugador.multiplicarX3(respuestaIncorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);

        Assertions.assertEquals(30, unResultado);
        Assertions.assertEquals(-30, otroResultado);
    }

    @Test
    public void jugadorRespondeVerdaderoFalsoConFortatoClasicoYMultiplicadorX3RecibePuntajeCorrecto() {

        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        unJugador.multiplicarX2(respuestaCorrecta);
        otroJugador.multiplicarX2(respuestaIncorrecta);

        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);

        Assertions.assertEquals(10, unResultado);
        Assertions.assertEquals(0, otroResultado);
    }

    @Test
    public void jugadorElijeExclusividadYSeDuplicaSuPuntajeAlResponderCorrectamente() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");
        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");
        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);
        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();
        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);
        assertEquals(20, unJugador.getPuntajeAcumulado());
    }

    @Test
    public void jugadorElijeExclusividadYSeAnulaSuPuntajeAlResponderMal() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");
        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");
        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);
        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();
        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dosJugadoresElijenExclusividadYSeAnulaSuPuntajeAlResponderAmbosMal() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");
        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");
        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);
        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();
        int unResultado = unJugador.responder(unaPregunta, respuestaIncorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);
        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dosJugadoresElijenExclusividadYSeAnulaSuPuntajeAlResponderAmbosBien() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");
        Opcion opcionVerdadera = new Opcion("Verdadera");
        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);
        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();
        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaCorrecta);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);
        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void ambosJugadoresElijenExclusividadYUnoRespondeBien() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionVerdadera = new Opcion("Verdadera");
        Opcion opcionFalsa = new Opcion("Falsa");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionVerdadera);

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionFalsa);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = unJugador.usarExclusividad();
        cantExclusividades += otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaCorrecta);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaIncorrecta);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void unJugadorElijeExclusividadYRespondeBienUnChoiceClasico() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = respuestaCorrecta;

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugador);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void unJugadorElijeExclusividadYRespondeMalUnChoiceClasico() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);

        Respuesta respuestaUnJugador = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionIncorrectaTres);

        Respuesta respuestaOtroJugador = new Respuesta();
        respuestaOtroJugador.agregarOpcion(opcionIncorrectaTres);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugador);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void unJugadorElijeExclusividadYRespondeMejorQueOtroEnFormatoParcial() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

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

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugador);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dosJugadoresElijenExclusividadesYRespondenAmbosBien() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

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

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = unJugador.usarExclusividad();
        cantExclusividades += otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugador);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void dosJugadoresElijenExclusividadesYRespondenAmbosMal() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepito");

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

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Parcial()), "hola soy una pregunta??", respuestaCorrecta);

        int cantExclusividades = unJugador.usarExclusividad();
        cantExclusividades += otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugador);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugador);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenUnaPreguntaTipoGroupChoiceUtilizandoUnaExclusividadYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo2_1);

        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);

        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);
        assertEquals(20, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenCorrectamenteUnaPreguntaTipoGroupChoiceUtilizandoUnaExclusividadYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        int cantExclusividades = unJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenUnaPreguntaTipoGroupChoiceUtilizandoDosExclusividadesYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Opcion opcionGrupo2_1 = new Opcion("Naranja");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo2_1);

        int cantExclusividades = unJugador.usarExclusividad();
        cantExclusividades += otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(40, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenCorrectamenteUnaPreguntaTipoGroupChoiceUtilizandoDosExclusividadesYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_2);

        int cantExclusividades = unJugador.usarExclusividad();
        cantExclusividades += otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenIncorrectamenteUnaPreguntaTipoGroupChoiceUtilizandoUnaExclusividadYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);

        int cantExclusividades = unJugador.usarExclusividad();
        cantExclusividades += otroJugador.usarExclusividad();
        Exclusividad unaExclusividad = new Exclusividad();

        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }

    @Test
    public void JugadoresRespondenIncorrectamenteUnaPreguntaTipoGroupChoiceUtilizandoDosExclusividadesYSeCalculaBienElPuntaje() {
        Jugador unJugador = new Jugador("pepe");
        Jugador otroJugador = new Jugador("pepe");

        Opcion opcionGrupo1_1 = new Opcion("Celeste");
        Opcion opcionGrupo1_2 = new Opcion("Azul");

        Respuesta respuestaCorrectaDeUnGrupo = new Respuesta();
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_1);
        respuestaCorrectaDeUnGrupo.agregarOpcion(opcionGrupo1_2);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Colores frios y calidos??", respuestaCorrectaDeUnGrupo);

        Respuesta respuestaUnJugadorParaElGrupo1 = new Respuesta();
        respuestaUnJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);

        Respuesta respuestaOtroJugadorParaElGrupo1 = new Respuesta();
        respuestaOtroJugadorParaElGrupo1.agregarOpcion(opcionGrupo1_1);

        int cantExclusividades = unJugador.usarExclusividad();
        cantExclusividades += otroJugador.usarExclusividad();

        Exclusividad unaExclusividad = new Exclusividad();
        int unResultado = unJugador.responder(unaPregunta, respuestaUnJugadorParaElGrupo1);
        int otroResultado = otroJugador.responder(unaPregunta, respuestaOtroJugadorParaElGrupo1);
        unaExclusividad.determinarPuntaje(unJugador, otroJugador, unResultado, otroResultado, cantExclusividades);

        assertEquals(0, unJugador.getPuntajeAcumulado());
        assertEquals(0, otroJugador.getPuntajeAcumulado());
    }*/
}