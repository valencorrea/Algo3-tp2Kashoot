package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.Pregunta;

import java.util.ArrayList;

public class ContenedorPreguntas extends VBox {

    private Scene escenaFinal;
    private VistaKashoot vistaKashoot;
    private VBox botonesExtra;
    private VBox preguntaYOpciones = new VBox();
    private Stage stage;
    private Kashoot kashoot;


    public ContenedorPreguntas(Stage stage, Kashoot kashoot, Scene escenaFinal) {
        Image imagen = new Image("patronpreguntas.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        this.stage = stage;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.setHeight(500);
        this.setAlignment(Pos.CENTER);

        this.vistaKashoot = new VistaKashoot(kashoot,this);
        this.actualizar();
    }

    public void actualizar() {
        this.getChildren().clear();
        preguntaYOpciones = new VBox();
        this.setDatos(kashoot);
        this.preguntaYOpciones.setAlignment(Pos.CENTER);
        this.botonesExtra.setAlignment(Pos.TOP_RIGHT);
        this.preguntaYOpciones.setSpacing(100);
        this.getChildren().addAll(botonesExtra, preguntaYOpciones);
    }

    private void setDatos(Kashoot kashoot) {

        this.setcentro();
        this.setBotoneraExtras(kashoot);

    }

    private void setcentro(){

        this.setPregunta();
        this.setBotoneraOpciones();

    }

    public void setBotoneraExtras(Kashoot kashoot){

        VBox botoneraExtras = new VBox();
        Button botonExclusividad = new Button();
        botonExclusividad.setText("Responder con exclusividad");
        BotonExclusividadEventHandler botonExclusividadEventHandler = new BotonExclusividadEventHandler(kashoot,vistaKashoot,escenaFinal,stage);
        botonExclusividad.setOnAction(botonExclusividadEventHandler);
        if(this.vistaKashoot.getPregunta().puedeMultiplicar()){
            botonExclusividad.setDisable(true);
        }

        Button multiplicadorX2 =new Button();
        multiplicadorX2.setText("Responder con multiplicador x2");

        BotonMultiplicadorX2EventHandler botonMultiplicarX2EventHandler = new BotonMultiplicadorX2EventHandler(kashoot, this.vistaKashoot, this.escenaFinal, this.stage);
        multiplicadorX2.setOnAction(botonMultiplicarX2EventHandler);

        Button multiplicadorX3 =new Button();
        multiplicadorX3.setText("Responder con multiplicador x3");

        BotonMultiplicadorX3EventHandler botonMultiplicarX3EventHandler = new BotonMultiplicadorX3EventHandler(kashoot,this.vistaKashoot, this.escenaFinal, this.stage);
        multiplicadorX3.setOnAction(botonMultiplicarX3EventHandler);

        Button responderNormal =new Button();
        responderNormal.setText("Responder");

        BotonResponderEventHandler botonResponderNormalEventHandler = new BotonResponderEventHandler(kashoot, vistaKashoot, this.escenaFinal, this.stage);
        responderNormal.setOnAction(botonResponderNormalEventHandler);

        botoneraExtras.getChildren().addAll(botonExclusividad,multiplicadorX2,multiplicadorX3,responderNormal);
        if(!this.vistaKashoot.getPregunta().puedeMultiplicar()){
            multiplicadorX2.setDisable(true);
            multiplicadorX3.setDisable(true);
        }
        this.botonesExtra = botoneraExtras;

    }

    public void setPregunta(){
        var textoPregunta = new Label();

        Pregunta pregunta = this.vistaKashoot.getPregunta();
        String unContenido = pregunta.getContenido();

        textoPregunta.setText(unContenido);
        textoPregunta.setFont(Font.font("Tahoma",FontWeight.BOLD, 40));
        textoPregunta.setTextFill(Color.CORNFLOWERBLUE);

        this.preguntaYOpciones.getChildren().add(textoPregunta);
    }

    public void setBotoneraOpciones() {

        HBox contenedorOpciones = new HBox();
        ArrayList<Opcion> opciones = this.vistaKashoot.getOpciones();


        for (Opcion opcion : opciones) {
            ToggleButton unBoton = new ToggleButton();
            unBoton.setText(opcion.getContenido());
            contenedorOpciones.getChildren().add(unBoton);

            BotonOpcionEventHandler botonOpcionEventHandler = new BotonOpcionEventHandler(this.vistaKashoot.getRespuesta(), opcion);
            unBoton.setOnAction(botonOpcionEventHandler);
        }

        contenedorOpciones.setSpacing(200);
        contenedorOpciones.setAlignment(Pos.CENTER);
        this.preguntaYOpciones.getChildren().add(contenedorOpciones);

    }

}
