package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {

    private ModalidadPregunta modalidad;
    private String contenido;
    private Respuesta respuestaCorrecta;

    //la pregunta no deberia saber cuales opciones son correctas o incorrectas, solo se las guarda en un array
    public Pregunta(ModalidadPregunta unaModalidad, String unContenido,Respuesta respuestaCorrecta){
        this.modalidad = unaModalidad;
        this.contenido = unContenido;
        this.respuestaCorrecta = respuestaCorrecta;
    }
/*
    public int responder(Respuesta respuestaJugador) {
        return this.modalidad.calcularPuntaje(respuestaJugador);
    }
*/
    //modelar respuesta(Generica) y opciones.
    // cambiar lo de correcta e incorrecta

    public int calcularPuntaje(Respuesta respuestaJugador){
        int cantidadAciertos = this.respuestaCorrecta.calcularAciertos(respuestaJugador);
        int cantidadCorrectas = this.cantidadCorrectas();
        return this.modalidad.calcularPuntaje(respuestaJugador.obtenerTamanio(), cantidadAciertos, cantidadCorrectas);
    }

    private int cantidadCorrectas() {
        return this.respuestaCorrecta.obtenerTamanio();
    }

}

