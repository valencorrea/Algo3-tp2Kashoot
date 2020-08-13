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

public class ContenedorPreguntas extends StackPane {

    //BarraDeMenu menuBar;
    //VistaKashoot vistaKashoot;
    VBox botonesExtra;
    VBox preguntaYOpciones = new VBox();

    Canvas canvasCentral;
    VBox contenedorCentral;


    public ContenedorPreguntas(Stage stage, Kashoot kashoot) {
        //this.setMenu(stage);
        //this.setCentro(kashoot);
        //this.setConsola();
        //this.contenedorCentral = new VBox();
        this.setPregunta(kashoot);
        this.setBotoneraOpciones(kashoot);
        this.setBotoneraExtras(kashoot);
        this.preguntaYOpciones.setAlignment(Pos.TOP_CENTER);
        this.botonesExtra.setAlignment(Pos.BOTTOM_LEFT);
        this.preguntaYOpciones.setSpacing(100);
        this.getChildren().addAll(preguntaYOpciones, botonesExtra);
        this.setHeight(500);
        this.setAlignment(Pos.CENTER);

    }

    private void setBotoneraExtras(Kashoot kashoot){
        VBox botoneraExtras = new VBox();
        Button boton1 = new Button();
        boton1.setText("Usar Exclusividad");

        Button boton2 =new Button();
        boton2.setText("Usar multiplicador x2");

        Button boton3 =new Button();
        boton3.setText("Usar multiplicador x3");

        botoneraExtras.getChildren().addAll(boton1,boton2,boton3);
        this.botonesExtra = botoneraExtras;

    }

    private void setPregunta(Kashoot kashoot){
        var textoPregunta = new Label();

        Pregunta pregunta = kashoot.getPregunta();
        String unContenido = pregunta.getContenido();

        textoPregunta.setText(unContenido);
        textoPregunta.setFont(Font.font("Tahoma",FontWeight.BOLD, 40));
        this.preguntaYOpciones.getChildren().add(textoPregunta);
    }
//FALTAN GUARDAR LOS SETTERS EN EL VERTICAL BOX

    private void setBotoneraOpciones(Kashoot kashoot) {

        HBox contenedorOpciones = new HBox();
        ArrayList<Opcion> opciones = kashoot.getOpciones();

        for (Opcion opcion : opciones) {
            Button unBoton = new Button();
            unBoton.setText(opcion.getContenido());
            contenedorOpciones.getChildren().add(unBoton);
        }
        contenedorOpciones.setSpacing(200);
        contenedorOpciones.setAlignment(Pos.CENTER);
        this.preguntaYOpciones.getChildren().add(contenedorOpciones);

    }
        //this.botonesOpciones = contenedorOpciones;
        //this.botonesOpciones.setSpacing(300);
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
