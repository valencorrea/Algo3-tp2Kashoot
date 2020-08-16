package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;


import java.util.ArrayList;
import java.util.Observable;

public class VistaKashoot {

    private Kashoot kashoot;
    private Respuesta respuestaActual;
    private Pregunta pregunta;
    private ArrayList<Opcion> opciones;

    public VistaKashoot(Kashoot kashoot){
        this.respuestaActual = new Respuesta();
        this.kashoot = kashoot;
        this.pregunta = kashoot.getPregunta();
        this.opciones = kashoot.getOpciones();

    }

    public void actualizar(){
        this.kashoot.actualizar();
        this.respuestaActual = new Respuesta();
        this.pregunta = kashoot.getPregunta();
        this.opciones = kashoot.getOpciones();
    }

    public ArrayList<Opcion> getOpciones() {
       return this.opciones;
        // return kashoot.getOpciones();
    }

    public Respuesta getRespuesta() {
        return this.respuestaActual;
    }
    public Pregunta getPregunta(){
        return this.pregunta;
        //return this.kashoot.getPregunta();
    }
}
