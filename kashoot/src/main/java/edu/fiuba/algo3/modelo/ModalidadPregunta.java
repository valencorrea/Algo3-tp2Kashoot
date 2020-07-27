package edu.fiuba.algo3.modelo;

public class ModalidadPregunta {

    private TipoFormato formato;

    public ModalidadPregunta(TipoFormato unFormato){
        this.formato = unFormato;
    }

    public int calcularPuntaje(Respuesta unaRespuesta){
        return unaRespuesta.calcularPuntaje(this.formato);
      //  return 10;
    }
}
