package edu.fiuba.algo3.modelo;


public class Pregunta {

    private Modalidad modalidad;
    private String contenido;
    private Respuesta respuestaCorrecta;

    public Pregunta(ModalidadSinOrden unaModalidad, String unContenido, Respuesta respuestaCorrecta){
        this.modalidad = unaModalidad;
        this.contenido = unContenido;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int calcularPuntaje(Respuesta respuestaJugador){
        return (this.modalidad.calcularPuntaje(respuestaJugador, this.respuestaCorrecta));
    }
}

