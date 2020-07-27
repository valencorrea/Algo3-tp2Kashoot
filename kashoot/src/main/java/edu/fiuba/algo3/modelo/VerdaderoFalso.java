package edu.fiuba.algo3.modelo;
//fijarse a futuro que choice hace lo mismo que verdadero o falso
// la clase no hace nada de relacionado con verdadero o falso
public class VerdaderoFalso implements TipoPregunta {

    private TipoFormato formato;

    public VerdaderoFalso(TipoFormato unFormato){
        this.formato = unFormato;
    }

    public int calcularPuntaje(Respuesta unaRespuesta){
        return unaRespuesta.calcularPuntaje(formato);
       // return this.formato.calcularPuntaje(unaRespuesta);
    }
}
