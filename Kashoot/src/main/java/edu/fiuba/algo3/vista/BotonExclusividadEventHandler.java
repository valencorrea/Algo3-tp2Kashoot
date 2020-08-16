package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Exclusividad;
import edu.fiuba.algo3.modelo.Kashoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonExclusividadEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Kashoot kashoot;

    public BotonExclusividadEventHandler(Stage stage, Kashoot kashoot) {
        this.stage = stage;
        this.kashoot = kashoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //kashoot.usarExclusividad()

        //contenedor.setDatos();
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
