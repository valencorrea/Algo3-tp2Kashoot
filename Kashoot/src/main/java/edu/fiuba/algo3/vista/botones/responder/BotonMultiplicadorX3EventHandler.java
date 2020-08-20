package edu.fiuba.algo3.vista.botones.responder;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonMultiplicadorX3EventHandler implements EventHandler<ActionEvent> {

    private Actualizador actualizador;
    private Kashoot kashoot;
    private VistaKashoot vista;
    private Scene proximaEscena;
    private Stage stage;

    public BotonMultiplicadorX3EventHandler(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage){

        this.actualizador = new Actualizador();

        this.vista = unaVista;
        this.kashoot = kashoot;

        this.proximaEscena = escenaFinal;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Jugador jugadorActual = this.kashoot.obtenerJugadorActual();
        jugadorActual.multiplicarX3(this.vista.getRespuesta());
        this.kashoot.jugarRondaSinExclusividad(jugadorActual, vista.getPregunta(),vista.getRespuesta());

        actualizador.actualizar(vista,proximaEscena,stage);
    }
}
