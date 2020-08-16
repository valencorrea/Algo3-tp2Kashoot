package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMultiplicadorX3EventHandler implements EventHandler<ActionEvent> {

    private Kashoot kashoot;
    private Pregunta pregunta;
    private Respuesta respuesta;
    private VistaKashoot unaVista;

    public BotonMultiplicadorX3EventHandler(Kashoot kashoot, Pregunta unaPregunta, Respuesta unaRespuesta, VistaKashoot unaVista){
        this.kashoot = kashoot;
        this.pregunta = unaPregunta;
        this.respuesta = unaRespuesta;
        this.vista = unaVista;

    }

    @Override
    public void handle(ActionEvent actionEvent){

        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.multiplicarX3(this.respuesta);
        jugadorActual.responder(this.pregunta, this.respuesta);
        int puntajeAcumulado = jugadorActual.getPuntajeAcumulado();

        this.vista.actualizar(puntajeAcumulado);

    }
}
