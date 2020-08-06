package edu.fiuba.algo3.modelo;

public class Opcion {

    private String contenido;

    public Opcion(String contenido){
        this.contenido = contenido;
    }

    public int esIgualA(edu.fiuba.algo3.modelo.Opcion opcionJugador) {
        boolean esIgual = false;

        esIgual = this.contenido.equals(opcionJugador.getContenido());
        if(esIgual){
            return 1;
        }
        return  0;
    }

    public String getContenido(){
        return this.contenido;
    }
}
