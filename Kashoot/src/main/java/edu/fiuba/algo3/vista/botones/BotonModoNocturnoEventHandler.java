package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.vista.contenedores.ContenedorFinalDelJuego;
import edu.fiuba.algo3.vista.contenedores.ContenedorPreguntas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonModoNocturnoEventHandler implements EventHandler<ActionEvent> {

    private boolean modoDiurno;
    private ContenedorFinalDelJuego contenedorFinal;
    private ContenedorPreguntas contenedorPreguntas;

    public BotonModoNocturnoEventHandler(ContenedorPreguntas contenedorPreguntas, ContenedorFinalDelJuego contenedorFinal, boolean modoDiurno) {
        this.contenedorPreguntas = contenedorPreguntas;
        this.contenedorFinal = contenedorFinal;
        this.modoDiurno = modoDiurno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.modoDiurno) {
            modificarModo("modoNocturno.jpeg", false);
            return;
        }
        modificarModo("modoDiurno.jpg", true);
    }

    private void modificarModo(String imagenAUsar, boolean seteoModoDiurno) {
        Image imagen = new Image(imagenAUsar, 230, 350, false, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.contenedorPreguntas.setBackground(new Background(imagenDeFondo));
        this.contenedorFinal.setBackground(new Background(imagenDeFondo));
        this.modoDiurno = seteoModoDiurno;
    }

}
