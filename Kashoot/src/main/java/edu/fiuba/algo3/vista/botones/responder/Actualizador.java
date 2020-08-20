package edu.fiuba.algo3.vista.botones.responder;

import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Actualizador {

    public void actualizar(VistaKashoot unaVista, Scene escenaFinal, Stage stage){
        unaVista.actualizar();

        if(unaVista.terminoJuego()){
            terminarJuego(unaVista, escenaFinal, stage);
        }
    }

    public void terminarJuego(VistaKashoot unaVista, Scene escenaFinal, Stage stage){
        unaVista.setDatosFinales();
        stage.setScene(escenaFinal);
        stage.setFullScreen(true);
        stage.show();
    }
}
