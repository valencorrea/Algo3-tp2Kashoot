package edu.fiuba.algo3.modelo;

public class Opcion {

    private String contenido;

    public Opcion(String contenido){
        this.contenido = contenido;
    }/*
    public int calcularPuntaje(TipoFormato formatoPregunta){
        return tipo.calcularPuntaje(formatoPregunta);
    }
*/
    public int esIgualA(Opcion opcionJugador) {
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
