package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonExclusividadEventHandler implements EventHandler<ActionEvent> {

    Kashoot kashoot;
    VistaKashoot vista;
    Pregunta pregunta;
    Respuesta respuesta;

    public BotonExclusividadEventHandler(Kashoot kashoot, VistaKashoot unaVista, Pregunta unaPregunta, Respuesta unaRespuesta) {
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
        this.kashoot.jugarRondaConExclusividad();
        int puntajeAcumulado = jugadorActual.getPuntajeAcumulado();
        this.vista.actualizar(puntajeAcumulado);

    }
}
