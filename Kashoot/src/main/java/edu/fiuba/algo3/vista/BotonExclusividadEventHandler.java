package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Kashoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonExclusividadEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    ContenedorPreguntas contenedor;
    Kashoot kashoot;

    public BotonExclusividadEventHandler(Stage stage, Kashoot kashoot, ContenedorPreguntas contenedor) {
        this.stage = stage;
        this.contenedor = contenedor;
        this.kashoot = kashoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        contenedor.setDatos();
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
