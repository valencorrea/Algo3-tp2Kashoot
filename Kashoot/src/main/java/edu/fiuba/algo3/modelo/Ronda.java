package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ronda {

    private Pregunta pregunta;
    private ArrayList<Opcion> opciones;
    private int turnosJugados = 0;
    private Exclusividad exclusividad = null;
    private int cantidadExclusividades = 0;

    //private ArrayList<int> puntajes = new ArrayList<int>();

    public void agregarOpciones(ArrayList<Opcion> opciones){
        this.opciones = opciones;
    }

    public void agregarPregunta(Pregunta pregunta){
        this.pregunta = pregunta;
    }

    public void jugarRonda(Jugador jugador){

        this.turnosJugados += 1;
    }

    public boolean rondaContinua(){
        return (this.turnosJugados < 2);
    }

    public ArrayList<Opcion> getOpciones() {
        return this.opciones;
    }

    public Pregunta getPregunta() {
        return this.pregunta;
    }


    public void aumentarturnos() {

        this.turnosJugados += 1;

    public void jugarConExclusividad(){
        if(this.exclusividad == null){
            this.exclusividad = new Exclusividad();
        }
        this.cantidadExclusividades += 1;
    }
}
