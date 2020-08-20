package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMultiplicadorX3EventHandler implements EventHandler<ActionEvent> {

    private BotonResponderGeneral botonResponderGeneral;
    private Kashoot kashoot;
    private VistaKashoot vista;
    private Scene proximaEscena;
    private Stage stage;

    public BotonMultiplicadorX3EventHandler(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage){
        this.botonResponderGeneral = new BotonResponderGeneral();
        this.vista = unaVista;
        this.kashoot = kashoot;
        this.proximaEscena = escenaFinal;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Jugador jugadorActual = this.kashoot.obtenerJugadorActual();
        jugadorActual.multiplicarX3(this.vista.getRespuesta());
        jugadorActual.responder(this.vista.getPregunta(), this.vista.getRespuesta());

        botonResponderGeneral.actualizar(vista,proximaEscena,stage);
    }
}
