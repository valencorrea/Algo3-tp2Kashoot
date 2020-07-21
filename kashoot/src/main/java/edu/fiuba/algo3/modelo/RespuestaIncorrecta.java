package edu.fiuba.algo3.modelo;

public class RespuestaIncorrecta extends TipoRespuesta {


    @Override
    public boolean soyCorrecta() {
        return false;
    }

    @Override
    public int getPuntos(){
        return -10;
    }

}
