package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonExclusividadEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    public BotonExclusividadEventHandler(Stage stage,Kashoot kashoot,Contenedor contenedor) {
        this.stage = stage;
        //this.proximaEscena = proximaEscena;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        contenedor.setDatos();
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
