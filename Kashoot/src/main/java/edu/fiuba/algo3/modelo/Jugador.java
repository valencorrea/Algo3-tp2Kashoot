package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntajeAcumulado = 0;
    private ArrayList<Multiplicador> multiplicadores= new ArrayList<Multiplicador>();

    public Jugador(String unNombre){

        this.nombre = unNombre;
        this.inicializarMultiplicadores();

    }

    private void inicializarMultiplicadores() {

        this.multiplicadores.add(new MultiplicadorX2());
        this.multiplicadores.add(new MultiplicadorX3());

    }
//ver como quedaria mandar el la respuesta su multiplicador.
    // no tener una referencia al multiplicador actual sino ver tener la el vector solo
    public void responder(Pregunta unaPregunta, Respuesta unaRespuesta){
        int puntaje = unaPregunta.calcularPuntaje(unaRespuesta);
        if(unaPregunta.puedeMultiplicar()){
            puntaje = unaRespuesta.multiplicar(puntaje);
        }
        puntajeAcumulado =+ puntaje;
        }
    public int getPuntajeAcumulado(){
        return this.puntajeAcumulado;
    }

    //NUNCA SE DA EL CASO DE QUE EL JUGADOR ELIJA MULTIPLICAR CUANDO NO ESTE YA QUE NO VA A ESTAR EN LA VISTA.
    //UNA VEZ QUE LO USA DESAPARECE DEL JUEGO
    public void multiplicarX2(Respuesta unaRespuesta) {

        MultiplicadorX2 multiplicador = new MultiplicadorX2();
        this.modificarMultiplicador(unaRespuesta, multiplicador);
        return;

    }
    public void multiplicarX3(Respuesta unaRespuesta) {

        MultiplicadorX3 multiplicador = new MultiplicadorX3();
        this.modificarMultiplicador(unaRespuesta, multiplicador);
        return;
    }
    public void modificarMultiplicador(Respuesta unaRespuesta, Multiplicador unMultiplicador){

        multiplicadores.remove(unMultiplicador);
        unaRespuesta.modificarMultiplicador(unMultiplicador);
        return;
    }

}
