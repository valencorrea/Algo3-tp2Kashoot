package edu.fiuba.algo3.modelo;

public class OpcionCorrecta extends TipoOpcion {

    @Override
    public int calcularPuntaje(TipoFormato formatoPregunta){
        return this.puntaje;
    }
}
