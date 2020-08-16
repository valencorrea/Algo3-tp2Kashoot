package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMultiplicadorX2EventHandler implements EventHandler<ActionEvent> {

    private Kashoot kashoot;
    private Pregunta pregunta;
    private Respuesta respuesta;
    private VistaKashoot vista;
    public BotonMultiplicadorX2EventHandler(Kashoot kashoot, Pregunta unaPregunta, Respuesta unaRespuesta, VistaKashhot unaVista){
        this.kashoot = kashoot;
        this.pregunta = unaPregunta;
        this.respuesta = unaRespuesta;
        this.vista = unaVista;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.multiplicarX2(this.respuesta);
        jugadorActual.responder(this.pregunta, this.respuesta);
        int puntajeAcumulado = jugadorActual.getPuntajeAcumulado();

        this.vista.actualizar(puntajeAcumulado);

    }


}
