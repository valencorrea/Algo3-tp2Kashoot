package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;


import java.util.ArrayList;
import java.util.Observable;

public class VistaKashoot {

    private final ContenedorPreguntas contenedor;
    private Kashoot kashoot;
    private Respuesta respuestaActual;
    private Pregunta pregunta;
    private ArrayList<Opcion> opciones;

    public VistaKashoot(Kashoot kashoot,ContenedorPreguntas contenedor){
        this.respuestaActual = new Respuesta();
        this.kashoot = kashoot;
        this.pregunta = kashoot.getPregunta();
        this.opciones = kashoot.getOpciones();
        this.contenedor = contenedor;

    }

    public void actualizar(){
        this.kashoot.actualizar();
        this.respuestaActual = new Respuesta();
        if(!this.kashoot.terminoJuego()) {
            this.pregunta = kashoot.getPregunta();
            this.opciones = kashoot.getOpciones();
        }
        contenedor.actualizar();
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

    public boolean terminoJuego() {
        return kashoot.terminoJuego();
    }


}
