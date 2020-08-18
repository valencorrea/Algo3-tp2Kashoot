package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kashoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

        var labelPuntajes = new Label("Puntajes finales");
        labelPuntajes.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 70));
        labelPuntajes.setTextFill(Color.HOTPINK);

        int puntajeAcumuladoJugador1 = kashoot.obtenerJugadorActual().getPuntajeAcumulado();
        System.out.println(puntajeAcumuladoJugador1);

        int puntajeAcumuladoJugador2 = kashoot.obtenerJugadorActual().getPuntajeAcumulado();

        var labelNombreJugador1 = new Label(kashoot.obtenerJugadorActual().getNombre());
        labelNombreJugador1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 50));
        var labelPuntajeJugador1 = new Label(Integer.toString(puntajeAcumuladoJugador1));

        VBox datosJugador1 = new VBox(labelNombreJugador1, labelPuntajeJugador1);
        labelPuntajeJugador1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 50));
        labelPuntajeJugador1.setTextFill(Color.HOTPINK);

        var labelNombreJugador2 = new Label(kashoot.obtenerJugadorActual().getNombre());
        labelNombreJugador2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 50));
        var labelPuntajeJugador2 = new Label(Integer.toString(puntajeAcumuladoJugador2));

        VBox datosJugador2 = new VBox(labelNombreJugador2, labelPuntajeJugador2);
        labelPuntajeJugador2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 50));
        labelPuntajeJugador2.setTextFill(Color.HOTPINK);

        HBox contenedorPuntajesJugadores = new HBox(datosJugador1, datosJugador2);
        contenedorPuntajesJugadores.setSpacing(170);
        contenedorPuntajesJugadores.setAlignment(Pos.CENTER);

        Button botonFinDeJuego = new Button();
        botonFinDeJuego.setText("Salir");
        botonFinDeJuego.setAlignment(Pos.CENTER);
        botonFinDeJuego.setScaleX(1);
        botonFinDeJuego.setScaleY(1);
        botonFinDeJuego.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 36));

        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.getChildren().add(labelPuntajes);
        contenedorPrincipal.getChildren().add(contenedorPuntajesJugadores);
        contenedorPrincipal.getChildren().add(botonFinDeJuego);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(100);

        BotonFinDeJuegoEventHandler botonFinDeJuegoEventHandler = new BotonFinDeJuegoEventHandler(stage);
        botonFinDeJuego.setOnAction(botonFinDeJuegoEventHandler);

        this.getChildren().add(contenedorPrincipal);
    }

}
