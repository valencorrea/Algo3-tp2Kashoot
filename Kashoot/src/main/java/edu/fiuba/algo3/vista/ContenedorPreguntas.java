package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Opcion;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.Pregunta;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ContenedorPreguntas extends BorderPane {

    //BarraDeMenu menuBar;
    //VistaKashoot vistaKashoot;
    Canvas canvasCentral;
    VBox contenedorCentral;
    Label pregunta;

    public ContenedorPreguntas(Stage stage, Kashoot kashoot) {
        //this.setMenu(stage);
        //this.setCentro(kashoot);
        //this.setConsola();
        this.contenedorCentral = new VBox();

        this.setPregunta(kashoot);
        this.setBotoneraOpciones(kashoot);
        this.setBotoneraExtras(kashoot);


    }

    private void setBotoneraExtras(Kashoot kashoot){
        VBox botoneraExtras = new VBox(new Button("Usar Exclusividad"), new Button("Usar multiplicador x2"), new Button("Usar multiplicador x3"));

        contenedorCentral.getChildren().add(botoneraExtras);
    }

    private void setPregunta(Kashoot kashoot){
        Label textoPregunta = new Label();
        Pregunta pregunta = kashoot.getPregunta();
        String unContenido = pregunta.getContenido();
        textoPregunta.setText(unContenido);
        this.pregunta = textoPregunta;

        contenedorCentral.getChildren().add(textoPregunta);
    }
//FALTAN GUARDAR LOS SETTERS EN EL VERTICAL BOX
    private void setBotoneraOpciones(Kashoot kashoot) {

        HBox contenedorOpciones = new HBox();
        ArrayList<Opcion> opciones = kashoot.getOpciones();

        for(Opcion opcion: opciones){
            Button unBoton = new Button();
            unBoton.setText(opcion.getContenido());
            contenedorOpciones.getChildren().add(unBoton);
        }
        contenedorCentral.getChildren().add(contenedorOpciones);
/*
        Button botonMover = new Button();
        botonMover.setText("Mover");
        BotonMoverHandler moveButtonHandler = new BotonMoverHandler(vistaRobot, robot);
        botonMover.setOnAction(moveButtonHandler);

        Button botonDireccion = new Button();
        botonDireccion.setText("Cambiar direccion");
        BotonDireccionHandler directionButtonHandler = new BotonDireccionHandler(robot);
        botonDireccion.setOnAction(directionButtonHandler);

        VBox contenedorVertical = new VBox(botonMover, botonDireccion);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
*/
    }
/*
    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setCentro(Robot robot) {

        canvasCentral = new Canvas(460, 220);
        vistaRobot = new VistaRobot(robot, canvasCentral);
        vistaRobot.dibujar();

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

    private void setConsola() {

        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
*/
}
