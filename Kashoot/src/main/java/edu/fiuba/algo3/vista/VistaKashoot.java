package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;


import java.util.ArrayList;
import java.util.Observable;

public class VistaKashoot {

    private Kashoot kashoot;
    private Respuesta respuestaActual;

    public VistaKashoot(Kashoot kashoot){
        this.respuestaActual = new Respuesta();
        this.kashoot = kashoot;
    }

    public void actualizar(){

        this.kashoot.actualizar();
        this.respuestaActual = new Respuesta();

    }

    public ArrayList<Opcion> getOpciones() {
        return kashoot.getOpciones();
    }

    public Respuesta getRespuesta() {
        return this.respuestaActual;
    }
}
