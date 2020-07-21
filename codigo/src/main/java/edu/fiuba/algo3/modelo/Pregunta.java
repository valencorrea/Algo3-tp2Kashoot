package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {

    private final ArrayList<Respuesta> respuestas;
    private TipoPregunta tipo;
    private String contenido;

    public Pregunta(TipoPregunta unTipo, ArrayList<Respuesta> unasRespuestas, String unContenido){
        this.tipo = unTipo;
        this.respuestas = unasRespuestas;
        this.contenido = unContenido;
    }

    public Respuesta getCorrecta(){

        Respuesta respuestaCorrecta = null;

        for(Respuesta respuesta: this.respuestas){
            if(respuesta.soyCorrecta()){
                respuestaCorrecta = respuesta;
            }
        }

        return respuestaCorrecta;
    }

    public int responder(String unContenido) {

        Respuesta unaRespuesta = this.buscarContenido(unContenido);

        return this.tipo.calcularPuntaje(unaRespuesta);
    }

    public Respuesta buscarContenido(String unContenido){
        Respuesta respuestaBuscada = null; /*PREGUNTAR SI ESTA BIEN INICIALIZAR CON NULL Y NUNCA CHEQUEAR QUE NO LO SEA*/

        for(Respuesta respuesta: this.respuestas){
            if(respuesta.getContenido().equals(unContenido)){
                respuestaBuscada = respuesta;
            }
        }

        return respuestaBuscada;
    }

}
