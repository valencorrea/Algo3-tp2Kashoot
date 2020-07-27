package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {

    private ArrayList<Opcion> opciones;
    private TipoPregunta tipo;
    private String contenido;

    //la pregunta no deberia saber cuales opciones son correctas o incorrectas, solo se las guarda en un array
    public Pregunta(TipoPregunta unTipo, String unContenido,ArrayList<Opcion> opciones){
        this.tipo = unTipo;
        this.contenido = unContenido;
        this.opciones = opciones;
    }
/*
    public Respuesta getCorrecta(){

        Respuesta respuestaCorrecta = null;

        for(Respuesta respuesta: this.respuestas){
            if(respuesta.soyCorrecta()){
                respuestaCorrecta = respuesta;
            }
        }

        return respuestaCorrecta;
    }
*/
    public int responder(Respuesta respuesta) {
        return 10;
    }
    /*
 */
    //modelar respuesta(Generica) y opciones.
    // cambiar lo de correcta e incorrecta


   /* public void agregarRespuestaCorrecta(String contenido) {

         this.agregarRespuesta(new Respuesta(new OpcionCorrecta(),contenido));
    }

    public void agregarRespuesta(Respuesta unaRespuesta){

        this.respuestas.add(unaRespuesta);
    }

    public void agregarRespuestaIncorrecta(String contenido) {

        this.agregarRespuesta(new Respuesta(new OpcionIncorrecta(),contenido));
    }

    */
}

