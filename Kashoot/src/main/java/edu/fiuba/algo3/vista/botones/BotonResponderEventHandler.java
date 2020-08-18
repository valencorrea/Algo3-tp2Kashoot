package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.vista.VistaKashoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonResponderEventHandler implements EventHandler<ActionEvent>{

    private VistaKashoot vista;
    private Kashoot kashoot;
    private Scene escenaFinal;
    private Stage stage;


    public BotonResponderEventHandler(Kashoot kashoot, VistaKashoot unaVista, Scene escenaFinal, Stage stage) {
        this.vista = unaVista;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.stage = stage;
        this.stage.setFullScreen(true);
        this.stage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.responder(vista.getPregunta(),vista.getRespuesta());
        //System.out.println(jugadorActual.getPuntajeRonda());

        this.vista.actualizar();
        System.out.println("jugador puntaje total:");
        System.out.println(jugadorActual.getPuntajeAcumulado());

        if(vista.terminoJuego()){
            this.vista.setDatosFinales();
            this.stage.setScene(this.escenaFinal);
            this.stage.setFullScreen(true);
            this.stage.show();
        }
    }
}
