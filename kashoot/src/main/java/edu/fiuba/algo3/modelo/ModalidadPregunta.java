package edu.fiuba.algo3.modelo;

/*
chequear a futuro porque capaz esta de mas esta clase
 (el formato se podria dejar en la pregunta y que no tenga modalidad)
*/
public class ModalidadPregunta {

    private TipoFormato formato;

    public ModalidadPregunta(TipoFormato unFormato){
        this.formato = unFormato;
    }

    public int calcularPuntaje(int cantidadOpcionesJugador,int cantidadAciertos, int cantidadCorrectas){
        return this.formato.calcularPuntaje(cantidadOpcionesJugador,cantidadAciertos, cantidadCorrectas);
    }
}
