package edu.fiuba.algo3.modelo;

public class OpcionIncorrecta extends TipoOpcion {


    @Override
    public boolean soyCorrecta() {
        return false;
    }

    @Override
    public int getPuntos(){
        return -10;
    }

}
