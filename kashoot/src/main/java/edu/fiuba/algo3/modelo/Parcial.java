package edu.fiuba.algo3.modelo;

public class Parcial extends TipoFormato {
    @Override
    public int puntajeIncorrecto(){
        return -1;
    }
    @Override
    public int calcularPuntaje(int cantidadAciertos, int cantidadCorrectas){
        //FALTA HACER LA CUENTA Y VER QUE ONDA ESTA
        return ((cantidadCorrectas - cantidadAciertos) * (-10)) + (cantidadAciertos * 10);
    }
}

