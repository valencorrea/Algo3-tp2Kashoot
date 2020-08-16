package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderEventHandler implements EventHandler<ActionEvent>{


    private final VistaKashoot vista;
    private final Pregunta pregunta;
    private final Kashoot kashoot;
    private final Respuesta respuesta;

    public BotonResponderEventHandler(Kashoot kashoot, VistaKashoot unaVista, Pregunta unaPregunta, Respuesta unaRespuesta) {
        this.vista = unaVista;
        this.kashoot = kashoot;
        this.pregunta = unaPregunta;
        this.respuesta = unaRespuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        int resultado = jugadorActual.responder(pregunta, respuesta);
        jugadorActual.asignarPuntajeRonda(resultado);
        int puntajeAcumulado = jugadorActual.getPuntajeAcumulado();

        this.vista.actualizar(puntajeAcumulado);
    }
}
