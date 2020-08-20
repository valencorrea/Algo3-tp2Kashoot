package edu.fiuba.algo3.modelo.modalidades;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;

public class ModalidadOrdenada implements Modalidad {
    @Override
    public int calcularPuntaje(Respuesta respuestaJugador, Respuesta respuestaCorrecta){

       if(respuestaCorrecta.tieneIgualOrdenA(respuestaJugador)){
           return 10;
       }
       return 0;

    }

    @Override
    public boolean puedeMultiplicar(){
        return false;
    }
}
