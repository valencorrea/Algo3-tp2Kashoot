package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    public void agregarOpcion(Opcion opcion){
        opciones.add(opcion);
    }

    public int obtenerTamanio(){
        return this.opciones.size();
    }

    public int calcularAciertos(Respuesta respuestaJugador){
        int correctas = 0;

        for(Opcion opcionCorrecta: opciones){
            for(Opcion opcionJugador: respuestaJugador.getOpciones()){
                correctas += opcionCorrecta.esIgualA(opcionJugador);
            }
        }
        return correctas;
    }

    public ArrayList<Opcion> getOpciones(){
        return this.opciones;
    }


    public boolean tieneIgualOrdenA(Respuesta respuestaJugador) {

       return this.opciones.equals(respuestaJugador.getOpciones());
    }
}
