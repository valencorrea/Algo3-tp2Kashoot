package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMultiplicadorX2EventHandler implements EventHandler<ActionEvent> {

    private Scene escenaFinal;
    private Stage stage;
    private Kashoot kashoot;
    private VistaKashoot vista;

    public BotonMultiplicadorX2EventHandler(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage){

        this.kashoot = kashoot;
        this.vista = unaVista;
        this.escenaFinal = escenaFinal;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.multiplicarX2(this.vista.getRespuesta());
        jugadorActual.responder(this.vista.getPregunta(), this.vista.getRespuesta());
        this.vista.actualizar();
        if(vista.terminoJuego()){
            this.stage.setScene(this.escenaFinal);
        }
    }


}
