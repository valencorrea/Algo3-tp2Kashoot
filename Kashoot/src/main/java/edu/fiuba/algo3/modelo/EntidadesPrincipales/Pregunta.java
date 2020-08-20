package edu.fiuba.algo3.modelo.EntidadesPrincipales;


import edu.fiuba.algo3.modelo.modalidades.Modalidad;

public class Pregunta {

    private Modalidad modalidad;
    private String contenido;
    private Respuesta respuestaCorrecta;

    public Pregunta(Modalidad unaModalidad, String unContenido, Respuesta respuestaCorrecta){
        this.modalidad = unaModalidad;
        this.contenido = unContenido;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int calcularPuntaje(Respuesta respuestaJugador){
        return (this.modalidad.calcularPuntaje(respuestaJugador, this.respuestaCorrecta));
    }

    public boolean puedeMultiplicar() {
        return this.modalidad.puedeMultiplicar();
    }

    public String getContenido(){
        return this.contenido;
    }
}

