package edu.fiuba.algo3.modelo;

public class Penalidad extends TipoFormato {
    @Override
    public int puntajeIncorrecto(){
        return -1;
    }

    @Override
    public int calcularPuntaje(int cantidadAciertos, int cantidadCorrectas){
        return ((cantidadCorrectas - cantidadAciertos) * (-10)) + (cantidadAciertos * 10);
    }
}
