package edu.fiuba.algo3.modelo;

public class Clasico extends TipoFormato{

    public int calcularPuntaje(Respuesta unaRespuesta){

        int puntos = unaRespuesta.getPuntos();
        if(puntos > 0){
            return puntos;
        }

        return 0;
    }
}
