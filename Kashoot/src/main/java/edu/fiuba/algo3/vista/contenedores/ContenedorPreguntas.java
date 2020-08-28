package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.*;
import edu.fiuba.algo3.vista.botones.responder.BotonExclusividadEventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonMultiplicadorX2EventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonMultiplicadorX3EventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonResponderEventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;

import java.util.ArrayList;

public class ContenedorPreguntas extends VBox {

    private Scene escenaFinal;
    private VistaKashoot vistaKashoot;
    private VBox botonesExtra;
    private VBox preguntaYOpciones = new VBox();
    private HBox informacionJugadores = new HBox();

    private Stage stage;
    private Kashoot kashoot;


    public ContenedorPreguntas(Stage stage, Kashoot kashoot, Scene escenaFinal,ContenedorFinalDelJuego contenedorFinalDeJuego) {

        Image imagen = new Image("pregunta.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        this.stage = stage;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.setHeight(500);
        this.setAlignment(Pos.CENTER);

        this.vistaKashoot = new VistaKashoot(kashoot,this,contenedorFinalDeJuego);
        this.actualizar();
    }

    public void actualizar() {
        this.getChildren().clear();

        preguntaYOpciones = new VBox();
        informacionJugadores = new HBox();

        this.setDatos();

        this.preguntaYOpciones.setAlignment(Pos.CENTER);
        this.botonesExtra.setAlignment(Pos.TOP_RIGHT);
        this.preguntaYOpciones.setSpacing(100);

        this.informacionJugadores.setAlignment(Pos.TOP_LEFT);
        this.informacionJugadores.setSpacing(500);

        this.getChildren().addAll(informacionJugadores, botonesExtra, preguntaYOpciones);
    }

    private void setDatos() {
        this.setcentro();
        this.setBotoneraExtras();
    }

    private void setcentro(){
        this.setPregunta();
        this.setBotoneraOpciones();
        this.setInfo();
    }

    public void setInfo(){
        this.setPuntajesJugadores(this.kashoot);
        this.setJugadorActual();
    }

    public void setJugadorActual(){
        HBox contenedor_de_nombre = new HBox();
        var nombreJugador = new Label();

        var texto = new Label("Jugador actual: ");
        texto.setFont(Font.font("Gill Sans",FontWeight.BOLD, 20));
        texto.setTextFill(Color.ROYALBLUE);

        nombreJugador.setText(this.kashoot.obtenerJugadorActual().getNombre());
        nombreJugador.setFont(Font.font("Gill Sans",FontWeight.BOLD, 20));
        nombreJugador.setTextFill(Color.ROYALBLUE);

        contenedor_de_nombre.getChildren().addAll(texto,nombreJugador);
        contenedor_de_nombre.setAlignment(Pos.TOP_CENTER);

        this.informacionJugadores.getChildren().add(contenedor_de_nombre);
    }

    public void setPuntajesJugadores(Kashoot kashoot){


        var puntajeJugador1 = new Label();

        Jugador jugador1 = kashoot.obtenerJugadorActual();

        puntajeJugador1.setText(": ".concat(Integer.toString(jugador1.getPuntajeAcumulado())));
        puntajeJugador1.setFont(Font.font("Gill Sans",FontWeight.BOLD, 20));
        puntajeJugador1.setTextFill(Color.MEDIUMVIOLETRED);

        var labelConNombreJugador1 = new Label();
        labelConNombreJugador1.setText(jugador1.getNombre());
        labelConNombreJugador1.setFont(Font.font("Gill Sans",FontWeight.BOLD, 20));
        labelConNombreJugador1.setTextFill(Color.MEDIUMVIOLETRED);

        kashoot.actualizarJugadorActual();

        var puntajeJugador2 =new Label();

        Jugador jugador2 = kashoot.obtenerJugadorActual();

        puntajeJugador2.setText(": ".concat(Integer.toString(jugador2.getPuntajeAcumulado())));
        puntajeJugador2.setFont(Font.font("Gill Sans",FontWeight.BOLD, 20));
        puntajeJugador2.setTextFill(Color.MEDIUMVIOLETRED);

        var labelConNombreJugador2 = new Label();
        labelConNombreJugador2.setText(jugador2.getNombre());
        labelConNombreJugador2.setFont(Font.font("Gill Sans",FontWeight.BOLD, 20));
        labelConNombreJugador2.setTextFill(Color.MEDIUMVIOLETRED);

        kashoot.actualizarJugadorActual();

        HBox boxJugador1 = new HBox();
        boxJugador1.getChildren().addAll(labelConNombreJugador1,puntajeJugador1);


        HBox boxJugador2 = new HBox();
        boxJugador2.getChildren().addAll(labelConNombreJugador2,puntajeJugador2);

        VBox boxDeAmbosJugadores = new VBox();
        boxDeAmbosJugadores.getChildren().addAll(boxJugador1,boxJugador2);
        this.informacionJugadores.getChildren().add(boxDeAmbosJugadores);
    }

    public void setBotoneraExtras(){

        VBox botoneraExtras = new VBox();

        ToggleButton botonExclusividad = crearBotonExclusividad();
        verificacionExclusividad(botonExclusividad);

        ToggleButton responderNormal = crearBotonRespuestaNormal();

        ToggleButton multiplicadorX2 = crearBotonMultiplicadorx2();
        ToggleButton multiplicadorX3 = crearBotonMultiplicadorx3();
        verificacionMultiplicadores(multiplicadorX2, multiplicadorX3);

        botoneraExtras.getChildren().addAll(botonExclusividad,multiplicadorX2,multiplicadorX3,responderNormal);
        this.botonesExtra = botoneraExtras;


    }

    private void verificacionExclusividad(ToggleButton botonExclusividad) {

        if(this.vistaKashoot.getPregunta().puedeMultiplicar() || !kashoot.obtenerJugadorActual().tieneExclusividad()){
            botonExclusividad.setDisable(true);
        }
    }

    private ToggleButton crearBotonExclusividad() {

        ToggleButton botonExclusividad = new ToggleButton();
        botonExclusividad.setText("Responder con exclusividad");
        BotonExclusividadEventHandler botonExclusividadEventHandler = new BotonExclusividadEventHandler(kashoot,vistaKashoot,escenaFinal,stage);
        botonExclusividad.setOnAction(botonExclusividadEventHandler);

        return botonExclusividad;
    }

    private void verificacionMultiplicadores(ToggleButton multiplicadorX2, ToggleButton multiplicadorX3) {

        if(!this.vistaKashoot.getPregunta().puedeMultiplicar()){
            multiplicadorX2.setDisable(true);
            multiplicadorX3.setDisable(true);
        }
        if(!kashoot.obtenerJugadorActual().tieneMultiplicadorX2()){
            multiplicadorX2.setDisable(true);
        }
        if(!kashoot.obtenerJugadorActual().tieneMultiplicadorX3()){
            multiplicadorX3.setDisable(true);
        }
    }

    private ToggleButton crearBotonRespuestaNormal() {

        ToggleButton responderNormal = new ToggleButton();
        responderNormal.setText("Responder");

        BotonResponderEventHandler botonResponderNormalEventHandler = new BotonResponderEventHandler(kashoot, vistaKashoot, this.escenaFinal, this.stage);
        responderNormal.setOnAction(botonResponderNormalEventHandler);

        return responderNormal;
    }

    private ToggleButton crearBotonMultiplicadorx3() {

        ToggleButton multiplicadorX3 =new ToggleButton();
        multiplicadorX3.setText("Responder con multiplicador x3");

        BotonMultiplicadorX3EventHandler botonMultiplicarX3EventHandler = new BotonMultiplicadorX3EventHandler(kashoot,this.vistaKashoot, this.escenaFinal, this.stage);
        multiplicadorX3.setOnAction(botonMultiplicarX3EventHandler);

        return multiplicadorX3;
    }

    private ToggleButton crearBotonMultiplicadorx2() {

        ToggleButton multiplicadorX2 = new ToggleButton();
        multiplicadorX2.setText("Responder con multiplicador x2");

        BotonMultiplicadorX2EventHandler botonMultiplicarX2EventHandler = new BotonMultiplicadorX2EventHandler(kashoot, this.vistaKashoot, this.escenaFinal, this.stage);
        multiplicadorX2.setOnAction(botonMultiplicarX2EventHandler);

        return multiplicadorX2;
    }

    public void setPregunta(){

        var textoPregunta = new Label();

        Pregunta pregunta = this.vistaKashoot.getPregunta();
        String unContenido = pregunta.getContenido();

        textoPregunta.setText(unContenido);
        textoPregunta.setFont(Font.font("Gill Sans",FontWeight.BOLD, 40));
        textoPregunta.setTextAlignment(TextAlignment.CENTER);
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

        var labelRecordatorio =recordatorio();

        this.preguntaYOpciones.getChildren().addAll(contenedorOpciones, labelRecordatorio);

    }

    public Label recordatorio(){

        var labelRecordatorio = new Label();
        labelRecordatorio.setText("Recordá seleccionar TODAS tus opciones antes de seleccionar cualquier boton de responder :)\nExclusividad: Duplica o cuadriplica el puntaje dependiendo de cuantos jugadores la seleccionaron y sus puntajes obtenidos");
        labelRecordatorio.setTextAlignment(TextAlignment.CENTER);
        labelRecordatorio.setFont(Font.font("Kalam",FontWeight.BOLD, 14));
        labelRecordatorio.setTextFill(Color.BLUEVIOLET);

        return labelRecordatorio;
    }

}
