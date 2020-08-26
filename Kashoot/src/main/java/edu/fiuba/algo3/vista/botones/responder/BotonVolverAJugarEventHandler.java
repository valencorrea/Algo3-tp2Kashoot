package edu.fiuba.algo3.vista.botones.responder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonVolverAJugarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    public BotonVolverAJugarEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
