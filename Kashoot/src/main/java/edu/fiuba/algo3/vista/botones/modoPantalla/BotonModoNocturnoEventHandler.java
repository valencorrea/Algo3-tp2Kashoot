package edu.fiuba.algo3.vista.botones.modoPantalla;

import edu.fiuba.algo3.vista.contenedores.ContenedorFinalDelJuego;
import edu.fiuba.algo3.vista.contenedores.ContenedorPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonModoNocturnoEventHandler implements EventHandler<ActionEvent> {

    private Button botonModoNocturno;
    private ContenedorFinalDelJuego contenedorFinal;
    private ContenedorPreguntas contenedorPreguntas;

    public BotonModoNocturnoEventHandler(ContenedorPreguntas contenedorPreguntas, ContenedorFinalDelJuego contenedorFinal, Button botonModoNocturno) {
        this.contenedorPreguntas = contenedorPreguntas;
        this.contenedorFinal = contenedorFinal;
        this.botonModoNocturno = botonModoNocturno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Image imagen = new Image("modoNocturno.jpeg", 230, 350, false, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.contenedorPreguntas.setBackground(new Background(imagenDeFondo));
        this.contenedorFinal.setBackground(new Background(imagenDeFondo));
    }
}
