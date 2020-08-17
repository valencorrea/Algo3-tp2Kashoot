package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Kashoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorFinalDelJuego extends VBox {

    Stage stage;

    public ContenedorFinalDelJuego(Stage stage, Kashoot kashoot) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imagen = new Image("patronvivo.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        var labelPuntajes = new Label("Puntajes finales:");
        labelPuntajes.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 70));
        labelPuntajes.setTextFill(Color.HOTPINK);

        var labelPuntajeJugador1 = new Label("3");
        labelPuntajeJugador1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 70));
        labelPuntajeJugador1.setTextFill(Color.HOTPINK);

        var labelPuntajeJugador2 = new Label("4");
        labelPuntajeJugador2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 70));
        labelPuntajeJugador2.setTextFill(Color.HOTPINK);

        HBox contenedorPuntajesJugadores = new HBox(labelPuntajeJugador1, labelPuntajeJugador2);
        contenedorPuntajesJugadores.setSpacing(170);
        contenedorPuntajesJugadores.setAlignment(Pos.CENTER);

        //BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, proximaEscena, textoJugador1, textoJugador2, mensajeError);

        //botonJugar.setOnAction(botonJugarEventHandler);

        this.getChildren().add(contenedorPuntajesJugadores);

    }

}
