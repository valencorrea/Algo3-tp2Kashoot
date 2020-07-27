package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {

    private ArrayList<Opcion> opciones = new ArrayList<Opcion>();

    public void agregarOpcion(Opcion opcion){
        opciones.add(opcion);
    }

    public int calcularPuntaje (TipoFormato formatoPregunta){
        int puntos = 0;
        for(Opcion opcion: opciones){
            puntos += opcion.calcularPuntaje(formatoPregunta);
        }
        return puntos;
    }
  /*  public boolean soyCorrecta() {

        return this.tipo.soyCorrecta();
    }
*/
/*
    public int getPuntos() {
        return this.tipo.getPuntos();
    }
    */

}
