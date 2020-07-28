package edu.fiuba.algo3.modelo;

public class Clasico extends TipoFormato{

    @Override
    public int puntajeIncorrecto(){
        return 0;
    }

    @Override
    public int calcularPuntaje(int cantidadAciertos, int cantidadCorrectas){
        if (cantidadCorrectas == cantidadAciertos){
            return (cantidadCorrectas * 10);
        }
        return 0;
    }
}
