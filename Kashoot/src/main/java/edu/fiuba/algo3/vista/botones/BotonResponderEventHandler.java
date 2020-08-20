package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonResponderEventHandler implements EventHandler<ActionEvent>{

    private VistaKashoot vista;
    private Kashoot kashoot;
    private Scene escenaFinal;
    private Stage stage;


    public BotonResponderEventHandler(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage) {
        this.vista = unaVista;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.stage = stage;
        this.stage.setFullScreen(true);
        this.stage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.responder(vista.getPregunta(),vista.getRespuesta());

        this.kashoot.actualizar();
        this.vista.actualizar();
        if(vista.terminoJuego()){
            terminarJuego();
        }
    }

    private void terminarJuego() {
        this.vista.setDatosFinales();
        this.stage.setScene(this.escenaFinal);
        this.stage.setFullScreen(true);
        this.stage.show();
    }
}
