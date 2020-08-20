package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.event.*;
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

        Jugador jugadorActual = this.kashoot.obtenerJugadorActual();
        jugadorActual.multiplicarX2(this.vista.getRespuesta());
        this.kashoot.jugarRondaSinExclusividad(jugadorActual, vista.getPregunta(),vista.getRespuesta());
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
