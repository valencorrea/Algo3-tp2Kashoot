package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonResponderEventHandler implements EventHandler<ActionEvent>{

    private final VistaKashoot vista;
    private final Kashoot kashoot;


    public BotonResponderEventHandler(Kashoot kashoot, VistaKashoot unaVista) {
        this.vista = unaVista;
        this.kashoot = kashoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.responder(vista.getPregunta(),vista.getRespuesta());
        this.vista.actualizar();
    }
}
