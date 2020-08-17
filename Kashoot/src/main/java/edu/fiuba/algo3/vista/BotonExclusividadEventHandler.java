package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kashoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonExclusividadEventHandler implements EventHandler<ActionEvent> {

    private Scene escenaFinal;
    private Stage stage;
    private VistaKashoot vista;
    Kashoot kashoot;

    public BotonExclusividadEventHandler(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage) {
        this.vista = unaVista;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.responder(vista.getPregunta(),vista.getRespuesta());
        kashoot.jugarRondaConExclusividad();
        System.out.println(jugadorActual.getPuntajeRonda());

        this.vista.actualizar();
        System.out.println(jugadorActual.getPuntajeAcumulado());

        if(vista.terminoJuego()){
            this.stage.setScene(this.escenaFinal);
            this.stage.setFullScreen(true);
            this.stage.show();
        }
    }
}
