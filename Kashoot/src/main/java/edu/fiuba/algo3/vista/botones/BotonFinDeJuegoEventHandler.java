package edu.fiuba.algo3.vista.botones;

import javafx.event.*;
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
