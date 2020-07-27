package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {

    private ArrayList<Opcion> opciones;
    private ModalidadPregunta modalidad;
    private String contenido;

    //la pregunta no deberia saber cuales opciones son correctas o incorrectas, solo se las guarda en un array
    public Pregunta(ModalidadPregunta unaModalidad, String unContenido,ArrayList<Opcion> opciones){
        this.modalidad = unaModalidad;
        this.contenido = unContenido;
        this.opciones = opciones;
    }

    public int responder(Respuesta respuesta) {
        return this.modalidad.calcularPuntaje(respuesta);
    }

    //modelar respuesta(Generica) y opciones.
    // cambiar lo de correcta e incorrecta
}

