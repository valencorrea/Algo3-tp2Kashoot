package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.vista.VistaKashoot;
import java.util.*;


public class Kashoot  {

    private int tamanio = 20;
    VistaKashoot modelo;
    private ArrayList<Ronda> rondas = new ArrayList<Ronda>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private ListIterator jugadorActual = jugadores.listIterator();
    //private Jugador jugador1;
    //private Jugador jugador2;
    //private Jugador jugadorActual;
    // private ArrayList<PreguntasYOpciones> preguntasYOpciones;
/*
    public Kashoot(ArrayList<PreguntasYOpciones> unasPreguntasYOpciones){
        //NOS FALTA RECIBIR TMB LOS JUGADORES
        this.preguntasYOpciones = unasPreguntasYOpciones;
    }
*/
    private void inicializarModelo() {

        modelo = new VistaKashoot();
    }

    public ArrayList<Opcion> getOpciones() {// antes llamar a getpregunta
        Ronda ronda = this.rondas.get(rondas.size()-1);
        ArrayList<Opcion> opciones = ronda.getOpciones();
        return opciones;
    }

    public Pregunta getPregunta() {
        Ronda ronda = this.rondas.get(rondas.size()-1);
        Pregunta pregunta = ronda.getPregunta();
        return pregunta;
    }

    public void agregarJugadores(Jugador jugador1, Jugador jugador2) {
        this.jugadores.add(jugador1);
        this.jugadores.add(jugador2);

       // this.jugador1 = jugador1;
       // this.jugador2 = jugador2;
    }
//cambiar esta medio rancio
    public Jugador obtenerJugadorActual(){

        if(jugadorActual.hasNext()){

            return (Jugador) this.jugadorActual.next();

        }
        this.jugadorActual.next();
        return (Jugador) this.jugadorActual.previous();
    }

    public void agregarRonda(Ronda ronda) {

        this.rondas.add(ronda);

    }
}
