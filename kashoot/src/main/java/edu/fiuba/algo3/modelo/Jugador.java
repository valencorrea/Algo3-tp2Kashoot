package edu.fiuba.algo3.modelo;

public class Jugador {

    private String nombre;
    private int puntajeAcumulado = 0;
    public Jugador(String unNombre){
        this.nombre = unNombre;
    }

    public void responder(Pregunta unaPregunta,Respuesta unaRespuesta){
        puntajeAcumulado =+ unaPregunta.calcularPuntaje(unaRespuesta);
    }
    public int getPuntajeAcumulado(){
        return this.puntajeAcumulado;
    }

}
