package edu.fiuba.algo3.modelo;

public class RespuestaCorrecta extends TipoRespuesta {

    private int puntaje = 10;

    @Override
    public boolean soyCorrecta(){
        return true;
    }

    @Override
    public int getPuntos(){
        return this.puntaje;
    }

}
