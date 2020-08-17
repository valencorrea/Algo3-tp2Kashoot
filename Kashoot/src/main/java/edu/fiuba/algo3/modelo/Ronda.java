package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Queue;

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
    }

    public void jugarConExclusividad() {
        if(this.exclusividad == null){
            this.exclusividad = new Exclusividad();
        }
        this.cantidadExclusividades += 1;
    }

    public void asignarPuntajes(Queue<Jugador> jugadores) {
        Jugador jugador1 = jugadores.poll();
        jugadores.add(jugador1);
        Jugador jugador2 = jugadores.poll();
        jugadores.add(jugador2);

        if(this.exclusividad != null){
            exclusividad.determinarPuntaje(jugador1,jugador2,jugador1.getPuntajeRonda(),jugador2.getPuntajeRonda(),this.cantidadExclusividades);
            return;
        }
        jugador1.asignarPuntajeRonda(jugador1.getPuntajeRonda());
        jugador2.asignarPuntajeRonda(jugador2.getPuntajeRonda());



    }
}
