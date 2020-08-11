package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntasYOpciones {

    private Pregunta pregunta;
    private ArrayList<Opcion> opciones;

    public PreguntasYOpciones(Pregunta pregunta, ArrayList<Opcion> opciones){
        this.pregunta = pregunta;
        this.opciones = opciones;
    }

    public Pregunta getPregunta(){
        return pregunta;
    }

    public ArrayList<Opcion> getOpciones(){
        return opciones;
    }

}
