package edu.fiuba.algo3.modelo;

public class Opcion {

    private TipoOpcion tipo;
    private String contenido;

    public Opcion(TipoOpcion tipo,String contenido){
        this.tipo = tipo;
        this.contenido = contenido;
    }
    public int calcularPuntaje(TipoFormato formatoPregunta){
        return tipo.calcularPuntaje(formatoPregunta);
    }
}
