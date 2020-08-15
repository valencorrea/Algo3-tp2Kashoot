package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;

public class BotonMultiplicadorX2EventHandler {

    private Kashoot kashoot;
    public BotonMultiplicadorX2EventHandler(Kashoot kashoot, Pregunta unaPregunta, ){
        this.kashoot = kashoot;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.responder()

    }


}
