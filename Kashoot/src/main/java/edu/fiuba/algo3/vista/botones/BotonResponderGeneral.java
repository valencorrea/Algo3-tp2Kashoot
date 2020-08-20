package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonResponderGeneral {

    private Scene escenaFinal;
    private Stage stage;
    private Kashoot kashoot;
    private VistaKashoot vista;

    public BotonResponderGeneral(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage) {
        this.vista = unaVista;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.stage = stage;
        this.stage.setFullScreen(true);
        this.stage.show();
    }

    public void actualizar(){
        this.vista.actualizar();

        if(vista.terminoJuego()){
            terminarJuego();
        }
    }

    public void terminarJuego(){
        this.vista.setDatosFinales();
        this.stage.setScene(this.escenaFinal);
        this.stage.setFullScreen(true);
        this.stage.show();
    }
}
