package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {

    private ArrayList<Respuesta> respuestas;
    private TipoPregunta tipo;
    private String contenido;


    public Pregunta(TipoPregunta unTipo, String unContenido){
        this.tipo = unTipo;
        this.contenido = unContenido;
        this.respuestas = new ArrayList<Respuesta>();
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
    //modelar respuesta(Generica) y opciones.
    // cambiar lo de correcta e incorrecta
    public Respuesta buscarContenido(String unContenido){
        Respuesta respuestaBuscada = null; /*PREGUNTAR SI ESTA BIEN INICIALIZAR CON NULL Y NUNCA CHEQUEAR QUE NO LO SEA*/

        for(Respuesta respuesta: this.respuestas){
            if(respuesta.getContenido().equals(unContenido)){
                respuestaBuscada = respuesta;
            }
        }

        return respuestaBuscada;
    }

    public void agregarRespuestaCorrecta(String contenido) {

         this.agregarRespuesta(new Respuesta(new RespuestaCorrecta(),contenido));
    }

    public void agregarRespuesta(Respuesta unaRespuesta){

        this.respuestas.add(unaRespuesta);
    }

    public void agregarRespuestaIncorrecta(String contenido) {

        this.agregarRespuesta(new Respuesta(new RespuestaIncorrecta(),contenido));
    }
}

