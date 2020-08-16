package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
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

public class ContenedorPreguntas extends VBox {

    //BarraDeMenu menuBar;
    VistaKashoot vistaKashoot;
    VBox botonesExtra;
    VBox preguntaYOpciones = new VBox();
    VBox contenedorCentral;
    Stage stage;


    public ContenedorPreguntas(Stage stage, Kashoot kashoot) {
        //this.setMenu(stage);
        //this.setCentro(kashoot);
        //this.setConsola();
        //this.contenedorCentral = new VBox();

        Image imagen = new Image("patronpreguntas.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        this.stage = stage;
        this.vistaKashoot = new VistaKashoot(kashoot);
        this.setDatos(kashoot);
        this.setHeight(500);
        this.setAlignment(Pos.CENTER);
        this.preguntaYOpciones.setAlignment(Pos.CENTER);
        this.botonesExtra.setAlignment(Pos.TOP_RIGHT);
        this.preguntaYOpciones.setSpacing(100);
        this.getChildren().addAll(botonesExtra, preguntaYOpciones);
    }

    private void setDatos(Kashoot kashoot) {

        this.setcentro(kashoot);
        this.setBotoneraExtras(kashoot);

    }
    private void setcentro(Kashoot kashoot){

        this.vistaKashoot = new VistaKashoot(kashoot);
        this.setPregunta();
        this.setBotoneraOpciones();

    }

    private void setBotoneraExtras(Kashoot kashoot){

        VBox botoneraExtras = new VBox();
        Button botonExclusividad = new Button();
        botonExclusividad.setText("Responder con exclusividad");
        //BotonExclusividadEventHandler botonExclusividadEventHandler = new BotonExclusividadEventHandler(stage,kashoot,this);
        //botonExclusividad.setOnAction(botonExclusividadEventHandler);

        Button multiplicadorX2 =new Button();
        multiplicadorX2.setText("Responder con multiplicador x2");

        BotonMultiplicadorX2EventHandler botonMultiplicarX2EventHandler = new BotonMultiplicadorX2EventHandler(kashoot, this.vistaKashoot);
        multiplicadorX2.setOnAction(botonMultiplicarX2EventHandler);

        Button multiplicadorX3 =new Button();
        multiplicadorX3.setText("Responder con multiplicador x3");

        BotonMultiplicadorX3EventHandler botonMultiplicarX3EventHandler = new BotonMultiplicadorX3EventHandler(kashoot,this.vistaKashoot);
        multiplicadorX3.setOnAction(botonMultiplicarX3EventHandler);

        botoneraExtras.getChildren().addAll(botonExclusividad,multiplicadorX2,multiplicadorX3);
        if(!this.vistaKashoot.getPregunta().puedeMultiplicar()){
            multiplicadorX2.setDisable(true);
            multiplicadorX3.setDisable(true);
        }
        this.botonesExtra = botoneraExtras;

    }

    private void setPregunta(){
        var textoPregunta = new Label();

        Pregunta pregunta = this.vistaKashoot.getPregunta();
        String unContenido = pregunta.getContenido();

        textoPregunta.setText(unContenido);
        textoPregunta.setFont(Font.font("Tahoma",FontWeight.BOLD, 40));
        textoPregunta.setTextFill(Color.CORNFLOWERBLUE);

        this.preguntaYOpciones.getChildren().add(textoPregunta);
    }
//FALTAN GUARDAR LOS SETTERS EN EL VERTICAL BOX

    private void setBotoneraOpciones() {

        HBox contenedorOpciones = new HBox();
        ArrayList<Opcion> opciones = this.vistaKashoot.getOpciones();
        Respuesta unaRespuesta = new Respuesta();

        for (Opcion opcion : opciones) {
            Button unBoton = new Button();
            unBoton.setText(opcion.getContenido());
            contenedorOpciones.getChildren().add(unBoton);

            BotonOpcionEventHandler botonOpcionEventHandler = new BotonOpcionEventHandler(unaRespuesta, opcion);
            unBoton.setOnAction(botonOpcionEventHandler);
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
