package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMultiplicadorX3EventHandler implements EventHandler<ActionEvent> {

    private Kashoot kashoot;
    private VistaKashoot vista;

    public BotonMultiplicadorX3EventHandler(Kashoot kashoot, VistaKashoot unaVista){
        this.kashoot = kashoot;
        this.vista = unaVista;

    }

    @Override
    public void handle(ActionEvent actionEvent){

        Jugador jugadorActual = kashoot.obtenerJugadorActual();
        jugadorActual.multiplicarX2(this.vista.getRespuesta());
        int puntaje = jugadorActual.responder(this.vista.getPregunta(), this.vista.getRespuesta());
        jugadorActual.asignarPuntajeRonda(puntaje);
        /*if(vista.terminoElJuego()){
            stage.setScene()
        }*/
        this.vista.actualizar();


    }
}
