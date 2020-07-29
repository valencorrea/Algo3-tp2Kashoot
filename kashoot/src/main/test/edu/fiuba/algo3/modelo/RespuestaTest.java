package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaTest {

    @Test

    public void dadaUnaRespuestaCorrectaDeUnVerdaderoFalsoConPenalidadSeDevuelveSuPuntaje(){

        Opcion opcionCorrecta = new Opcion("Verdadero");

        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);

        Respuesta respuesta = new Respuesta();
        respuesta.agregarOpcion(opcionCorrecta);

        Respuesta respuestaJugador= new Respuesta();
        respuestaJugador.agregarOpcion(opcionCorrecta);

        int aciertos = respuesta.calcularAciertos(respuestaJugador);


        assertEquals(1,aciertos);
    }
    /*
    @Test

    public void dadaUnaRespuestaCorrectaDeUnVerdaderoFalsoConPenalidadSeDevuelveSuPuntaje(){

        Respuesta respuesta = new Respuesta();
        Opcion opcion = new Opcion(new OpcionCorrecta(),"verdadero");
        TipoFormato penalidad = new Penalidad();
        respuesta.agregarOpcion(opcion);
        int puntaje = respuesta.calcularPuntaje(penalidad);
        assertEquals(10,puntaje);
    }

    @Test

    public void dadaUnaRespuestaIncorrectaDeUnVerdaderoFalsoConPenalidadSeDevuelveSuPuntaje(){

        Respuesta respuesta = new Respuesta();
        Opcion opcion = new Opcion(new OpcionIncorrecta(),"Falsa");
        TipoFormato penalidad = new Penalidad();
        respuesta.agregarOpcion(opcion);
        int puntaje = respuesta.calcularPuntaje(penalidad);
        assertEquals(-10,puntaje);

    }

    @Test

    public void dadaUnaRespuestaConMultiplesOpcionesConPenalidadSeCalculaElPuntaje(){

        Respuesta respuesta = new Respuesta();
        Opcion opcion1 = new Opcion(new OpcionIncorrecta(),"Uno");
        Opcion opcion2 = new Opcion(new OpcionCorrecta(),"Dos");
        Opcion opcion3 = new Opcion(new OpcionCorrecta(),"Tres");
        TipoFormato penalidad = new Penalidad();
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);
        respuesta.agregarOpcion(opcion3);
        int puntaje = respuesta.calcularPuntaje(penalidad);
        assertEquals(10,puntaje);

    }

    @Test

    public void dadaUnaRespuestaConMultiplesOpcionesClasicoSeCalculaElPuntaje(){

        Respuesta respuesta = new Respuesta();
        Opcion opcion1 = new Opcion(new OpcionIncorrecta(),"Uno");
        Opcion opcion2 = new Opcion(new OpcionCorrecta(),"Dos");
        Opcion opcion3 = new Opcion(new OpcionCorrecta(),"Tres");
        TipoFormato clasico = new Clasico();
        respuesta.agregarOpcion(opcion1);
        respuesta.agregarOpcion(opcion2);
        respuesta.agregarOpcion(opcion3);
        int puntaje = respuesta.calcularPuntaje(clasico);
        assertEquals(20,puntaje);

    }*/
/*
    @Test
    public void unaRespuestaTipoCorrectaEsCorrecta(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new OpcionCorrecta(), unContenido);

        assert(unaRespuesta.soyCorrecta());
    }

    @Test
    public void unaRespuestaTipoIncorrectaNoEsCorrecta(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new OpcionIncorrecta(), unContenido);

        assert(!unaRespuesta.soyCorrecta());
    }

    @Test
    public void unaRespuestaDevuelveSuContenido(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new OpcionIncorrecta(), unContenido);

        assertEquals(unaRespuesta.getContenido(),unContenido);
    }

    @Test
    public void unaRespuestaTipoCorrectaSuma10Puntos(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new OpcionCorrecta(), unContenido);

        assertEquals(unaRespuesta.getPuntos(), 10);
    }

    @Test
    public void unaRespuestaTipoCorrectaResta10Puntos(){
        String unContenido = "soy un contenido";
        Respuesta unaRespuesta = new Respuesta(new OpcionIncorrecta(), unContenido);

        assertEquals(unaRespuesta.getPuntos(), -10);
    }
*/
}
