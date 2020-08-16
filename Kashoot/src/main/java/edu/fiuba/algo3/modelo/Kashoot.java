package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.vista.VistaKashoot;
import java.util.*;


public class Kashoot  {

    private int tamanio = 20;
    private Queue<Ronda> rondas = new LinkedList<Ronda>();
    private Queue<Jugador> jugadores = new LinkedList<Jugador>();

    public ArrayList<Opcion> getOpciones() {// antes llamar a getpregunta
        Ronda ronda = this.rondas.element();
        ArrayList<Opcion> opciones = ronda.getOpciones();
        return opciones;
    }

    public Pregunta getPregunta() {
        Ronda ronda = this.rondas.element();
        Pregunta pregunta = ronda.getPregunta();
        return pregunta;
    }

    public void agregarJugadores(Jugador jugador1, Jugador jugador2) {
        this.jugadores.add(jugador1);
        this.jugadores.add(jugador2);

    }

    public Jugador obtenerJugadorActual(){

        Jugador jugadorActual = jugadores.poll();

        jugadores.add(jugadorActual);

        return jugadorActual;
    }

    public void agregarRonda(Ronda ronda) {
        this.rondas.add(ronda);
    }

    public void actualizar(){

        rondas.element().aumentarturnos();
         if(!rondas.element().rondaContinua()){
             rondas.element().asignarPuntajes(jugadores);
             rondas.remove();
         }
         //si no hay rondas hay que cerrar el juego
    }

    public void jugarRondaConExclusividad() {

        Ronda rondaActual = this.rondas.element();
        rondaActual.jugarConExclusividad();
    }

}
