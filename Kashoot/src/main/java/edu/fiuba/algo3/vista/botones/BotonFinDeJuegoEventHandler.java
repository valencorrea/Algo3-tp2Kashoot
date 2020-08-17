package edu.fiuba.algo3.vista.botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonFinDeJuegoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    public BotonFinDeJuegoEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        System.exit(0);
    }
}
