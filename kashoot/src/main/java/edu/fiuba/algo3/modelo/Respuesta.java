package edu.fiuba.algo3.modelo;

public class Respuesta {

    private TipoRespuesta tipo;
    private String contenido;

    public Respuesta(TipoRespuesta unTipo, String unContenido){
        this.tipo = unTipo;
        this.contenido = unContenido;
    }


    public boolean soyCorrecta() {

        return this.tipo.soyCorrecta();
    }

    public String getContenido(){
        return this.contenido;
    }

    public int getPuntos() {
        return this.tipo.getPuntos();
    }
}