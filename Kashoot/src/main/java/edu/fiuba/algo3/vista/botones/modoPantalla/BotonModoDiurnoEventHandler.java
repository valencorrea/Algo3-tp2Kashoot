package edu.fiuba.algo3.vista.botones.modoPantalla;

import edu.fiuba.algo3.vista.contenedores.ContenedorFinalDelJuego;
import edu.fiuba.algo3.vista.contenedores.ContenedorPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonModoDiurnoEventHandler implements EventHandler<ActionEvent> {

    private ContenedorFinalDelJuego contenedorFinal;
    private ContenedorPreguntas contenedorPreguntas;
    private Button botonModoNocturno;

    public BotonModoDiurnoEventHandler(ContenedorPreguntas contenedorPreguntas, ContenedorFinalDelJuego contenedorFinal, Button botonModoDiurno) {
        this.contenedorPreguntas = contenedorPreguntas;
        this.contenedorFinal = contenedorFinal;
        this.botonModoNocturno = botonModoDiurno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Image imagen = new Image("modoDiurno.jpg", 230, 350, false, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.contenedorPreguntas.setBackground(new Background(imagenDeFondo));
        this.contenedorFinal.setBackground(new Background(imagenDeFondo));
    }
}
