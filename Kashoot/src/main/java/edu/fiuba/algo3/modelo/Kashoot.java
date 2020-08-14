package edu.fiuba.algo3.modelo;

//import edu.fiuba.algo3.resources.*;
import edu.fiuba.algo3.modelo.modalidades.*;
import edu.fiuba.algo3.modelo.formatos.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.*;


public class Kashoot  {

    private int tamanio = 20;
    ModeloObservable modelo;
    private ArrayList<PreguntasYOpciones> preguntasYOpciones;
    private Jugador jugador1;
    private Jugador jugador2;

    public Kashoot(ArrayList<PreguntasYOpciones> unasPreguntasYOpciones){
        //NOS FALTA RECIBIR TMB LOS JUGADORES
        this.preguntasYOpciones = unasPreguntasYOpciones;
    }

    private void inicializarModelo() {

        modelo = new ModeloObservable();
    }

    public ArrayList<Opcion> getOpciones() {// antes llamar a getpregunta
        PreguntasYOpciones preguntaYOpciones = this.preguntasYOpciones.get(preguntasYOpciones.size()-1);
        ArrayList<Opcion> opciones = preguntaYOpciones.getOpciones();
        this.preguntasYOpciones.remove(preguntasYOpciones.size()-1);
        return opciones;
    }

    public Pregunta getPregunta() {
        PreguntasYOpciones preguntaYOpciones = this.preguntasYOpciones.get(preguntasYOpciones.size()-1);
        Pregunta pregunta = preguntaYOpciones.getPregunta();
        return pregunta;
    }

    public void agregarJugadores(Jugador jugador1, Jugador jugador2) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
}
