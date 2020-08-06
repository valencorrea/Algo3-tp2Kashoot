package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntajeAcumulado = 0;
    private ArrayList<Multiplicador> multiplicadores= new ArrayList<Multiplicador>();
    private Multiplicador multiplicadorActual;
    public Jugador(String unNombre){

        this.nombre = unNombre;
        this.inicializarMultiplicadores();
        this.multiplicadorActual = multiplicadores.get(0);

    }

    private void inicializarMultiplicadores() {

        this.multiplicadores.add(new MultiplicadorX1());
        this.multiplicadores.add(new MultiplicadorX2());
        this.multiplicadores.add(new MultiplicadorX3());

    }

    public void responder(Pregunta unaPregunta, Respuesta unaRespuesta){
        int puntaje = multiplicadorActual.multiplicar(unaPregunta.calcularPuntaje(unaRespuesta));
        multiplicadorActual = multiplicadores.get(0);
        puntajeAcumulado =+ puntaje;

    }
    public int getPuntajeAcumulado(){
        return this.puntajeAcumulado;
    }

    public void multiplicar(Pregunta unaPregunta, Multiplicador unMultiplicador){

         if(unaPregunta.puedeMultiplicar()){
            multiplicadorActual = unMultiplicador;
            return;
         }
         //faltaria lanzar una excepcion.
    }
    public void multiplicarX2(Pregunta unaPregunta) {

        this.multiplicar(unaPregunta,multiplicadores.get(1));
    }
    public void multiplicarX3(Pregunta unapregunta){

        this.multiplicar(unapregunta,multiplicadores.get(2));
    }


}
