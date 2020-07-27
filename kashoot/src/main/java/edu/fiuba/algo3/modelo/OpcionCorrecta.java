package edu.fiuba.algo3.modelo;

public class OpcionCorrecta extends TipoOpcion {

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
