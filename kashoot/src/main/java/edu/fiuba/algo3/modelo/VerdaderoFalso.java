package edu.fiuba.algo3.modelo;

public class VerdaderoFalso implements TipoPregunta {

    private TipoFormato formato;

    public VerdaderoFalso(TipoFormato unFormato){
        this.formato = unFormato;
    }

    public int calcularPuntaje(Respuesta unaRespuesta){
        return this.formato.calcularPuntaje(unaRespuesta);
    }
}
