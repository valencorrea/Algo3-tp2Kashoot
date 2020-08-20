package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import edu.fiuba.algo3.vista.contenedores.ContenedorFinalDelJuego;
import edu.fiuba.algo3.vista.contenedores.ContenedorPreguntas;


import java.util.ArrayList;

public class VistaKashoot {

    private ContenedorPreguntas contenedorPreguntas;
    private ContenedorFinalDelJuego contenedorFinal;
    private Kashoot kashoot;
    private Respuesta respuestaActual;
    private Pregunta pregunta;
    private ArrayList<Opcion> opciones;

    public VistaKashoot(Kashoot kashoot, ContenedorPreguntas contenedorPreguntas, ContenedorFinalDelJuego contenedorFinal){
        this.respuestaActual = new Respuesta();
        this.kashoot = kashoot;
        this.pregunta = kashoot.getPregunta();
        this.opciones = kashoot.getOpciones();
        this.contenedorPreguntas = contenedorPreguntas;
        this.contenedorFinal = contenedorFinal;

    }

    public void actualizar(){

        this.respuestaActual = new Respuesta();
        if(!this.kashoot.terminoJuego()) {
            this.pregunta = kashoot.getPregunta();
            this.opciones = kashoot.getOpciones();
        }
        contenedorPreguntas.actualizar();
    }

    public ArrayList<Opcion> getOpciones() {
       return this.opciones;

    }

    public Respuesta getRespuesta() {
        return this.respuestaActual;
    }

    public Pregunta getPregunta(){
        return this.pregunta;

    }

    public boolean terminoJuego() {
        return kashoot.terminoJuego();
    }

    public void setDatosFinales() {
        this.contenedorFinal.setDatosFinales();
    }
}
