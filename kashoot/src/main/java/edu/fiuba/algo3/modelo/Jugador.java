package edu.fiuba.algo3.modelo;

public class Jugador {

    private String nombre;

    public Jugador(String unNombre){
        this.nombre = unNombre;
    }

    public int responder(Pregunta unaPregunta, String unContenido){
        return unaPregunta.responder(unContenido);
    }

}
