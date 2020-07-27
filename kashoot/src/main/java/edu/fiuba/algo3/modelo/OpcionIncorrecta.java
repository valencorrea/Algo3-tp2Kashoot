package edu.fiuba.algo3.modelo;

public class OpcionIncorrecta extends TipoOpcion {

    @Override
    public int calcularPuntaje(TipoFormato formatoPregunta){
        return puntaje * formatoPregunta.puntajeIncorrecto();
    }

}
