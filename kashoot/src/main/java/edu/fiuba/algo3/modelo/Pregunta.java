package edu.fiuba.algo3.modelo;


public class Pregunta {

    private ModalidadPregunta modalidad;
    private String contenido;
    private Respuesta respuestaCorrecta;

    public Pregunta(ModalidadPregunta unaModalidad, String unContenido,Respuesta respuestaCorrecta){
        this.modalidad = unaModalidad;
        this.contenido = unContenido;
        this.respuestaCorrecta = respuestaCorrecta;
    }


    public int calcularPuntaje(Respuesta respuestaJugador){
        int cantidadAciertos = this.respuestaCorrecta.calcularAciertos(respuestaJugador);
        int cantidadCorrectas = this.cantidadCorrectas();
        return this.modalidad.calcularPuntaje(respuestaJugador.obtenerTamanio(), cantidadAciertos, cantidadCorrectas);
    }

    private int cantidadCorrectas() {
        return this.respuestaCorrecta.obtenerTamanio();
    }

}

