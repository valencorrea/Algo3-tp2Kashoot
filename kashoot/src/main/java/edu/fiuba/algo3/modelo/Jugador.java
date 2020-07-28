package edu.fiuba.algo3.modelo;

public class Jugador {

    private String nombre;

    public Jugador(String unNombre){
        this.nombre = unNombre;
    }

    public int responder(Pregunta unaPregunta,Respuesta unaRespuesta){
        return unaPregunta.calcularPuntaje(unaRespuesta);
    }

}
