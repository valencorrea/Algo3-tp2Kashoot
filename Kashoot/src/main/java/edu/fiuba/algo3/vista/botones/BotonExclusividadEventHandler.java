package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonExclusividadEventHandler implements EventHandler<ActionEvent> {

    private Scene escenaFinal;
    private Stage stage;
    private VistaKashoot vista;
    private Kashoot kashoot;

    public BotonExclusividadEventHandler(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage) {
        this.vista = unaVista;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorActual = this.kashoot.obtenerJugadorActual();
        jugadorActual.responder(vista.getPregunta(),vista.getRespuesta());
        this.kashoot.jugarRondaConExclusividad();
        this.kashoot.obtenerJugadorActual().usarExclusividad();
        this.kashoot.actualizar();
        this.vista.actualizar();

        if(vista.terminoJuego()){
            terminarJuego();
        }
    }

    public void terminarJuego() {
        this.vista.setDatosFinales();
        this.stage.setScene(this.escenaFinal);
        this.stage.setFullScreen(true);
        this.stage.show();
    }
}
