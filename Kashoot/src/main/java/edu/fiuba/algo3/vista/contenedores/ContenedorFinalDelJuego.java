package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.vista.botones.BotonFinDeJuegoEventHandler;
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

    private Kashoot kashoot;
    private Stage stage;

    public ContenedorFinalDelJuego(Stage stage, Kashoot kashoot) {

        super();

        seteosVisuales(stage, kashoot);

        var labelPuntajes = new Label("Puntajes finales");
        labelPuntajes.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 70));
        labelPuntajes.setTextFill(Color.HOTPINK);

        VBox datosJugador1 = this.mostrarJugador1();
        VBox datosJugador2 = this.mostrarJugador2();

        HBox contenedorPuntajesJugadores = new HBox(datosJugador1, datosJugador2);
        contenedorPuntajesJugadores.setSpacing(170);
        contenedorPuntajesJugadores.setAlignment(Pos.CENTER);

        Button botonFinDeJuego = this.crearBotonSalir();

        VBox contenedorPrincipal = agregarContenedoresSecundarios(labelPuntajes, contenedorPuntajesJugadores, botonFinDeJuego);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(100);

        this.getChildren().add(contenedorPrincipal);
    }

    private void seteosVisuales(Stage stage, Kashoot kashoot) {

        this.agregarImagenFondo();

        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        this.kashoot = kashoot;
    }

    private VBox agregarContenedoresSecundarios(Label labelPuntajes, HBox contenedorPuntajesJugadores, Button botonFinDeJuego) {

        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.getChildren().add(labelPuntajes);
        contenedorPrincipal.getChildren().add(contenedorPuntajesJugadores);
        contenedorPrincipal.getChildren().add(botonFinDeJuego);

        return contenedorPrincipal;
    }

    private Button crearBotonSalir() {

        Button botonFinDeJuego = new Button();
        botonFinDeJuego.setText("Salir");
        botonFinDeJuego.setAlignment(Pos.CENTER);
        botonFinDeJuego.setScaleX(1);
        botonFinDeJuego.setScaleY(1);
        botonFinDeJuego.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 36));

        BotonFinDeJuegoEventHandler botonFinDeJuegoEventHandler = new BotonFinDeJuegoEventHandler(stage);
        botonFinDeJuego.setOnAction(botonFinDeJuegoEventHandler);

        return botonFinDeJuego;
    }

    private VBox mostrarJugador2() {

        int puntajeAcumuladoJugador2 = kashoot.obtenerJugadorActual().getPuntajeAcumulado();

        var labelNombreJugador2 = new Label(kashoot.obtenerJugadorActual().getNombre());
        labelNombreJugador2.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5.0), new Insets(-5.0))));

        labelNombreJugador2.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 50));
        var labelPuntajeJugador2 = new Label(Integer.toString(puntajeAcumuladoJugador2));

        VBox datosJugador2 = new VBox(labelNombreJugador2, labelPuntajeJugador2);
        labelPuntajeJugador2.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 50));
        labelPuntajeJugador2.setTextFill(Color.HOTPINK);
        datosJugador2.setSpacing(5);

        return datosJugador2;
    }

    private VBox mostrarJugador1() {

        int puntajeAcumuladoJugador1 = kashoot.obtenerJugadorActual().getPuntajeAcumulado();

        var labelNombreJugador1 = new Label(kashoot.obtenerJugadorActual().getNombre());
        labelNombreJugador1.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5.0), new Insets(-5.0))));
        kashoot.actualizarJugadorActual();

        labelNombreJugador1.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 50));
        var labelPuntajeJugador1 = new Label(Integer.toString(puntajeAcumuladoJugador1));

        VBox datosJugador1 = new VBox(labelNombreJugador1, labelPuntajeJugador1);
        labelPuntajeJugador1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 50));
        labelPuntajeJugador1.setTextFill(Color.HOTPINK);
        datosJugador1.setSpacing(5);

        return datosJugador1;
    }

    private void agregarImagenFondo() {
        Image imagen = new Image("modoDiurno.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    //REFACTORIZARRRRRRRRRRRRRRRRR
    public void setDatosFinales() {

        this.getChildren().clear();

        var labelPuntajes = new Label("Puntajes finales");
        labelPuntajes.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 70));
        labelPuntajes.setTextFill(Color.HOTPINK);

        VBox datosJugador1 = this.mostrarJugador1();
        VBox datosJugador2 = this.mostrarJugador2();

        HBox contenedorPuntajesJugadores = new HBox(datosJugador1, datosJugador2);
        contenedorPuntajesJugadores.setSpacing(170);
        contenedorPuntajesJugadores.setAlignment(Pos.CENTER);

        Button botonFinDeJuego = this.crearBotonSalir();

        VBox contenedorPrincipal = agregarContenedoresSecundarios(labelPuntajes, contenedorPuntajesJugadores, botonFinDeJuego);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setSpacing(100);

        this.getChildren().add(contenedorPrincipal);
    }
}
