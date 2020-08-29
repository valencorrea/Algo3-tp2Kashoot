package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.*;
import edu.fiuba.algo3.vista.botones.responder.BotonExclusividadEventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonMultiplicadorX2EventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonMultiplicadorX3EventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonResponderEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private HBox botonesExtra;
    private VBox preguntaYOpciones = new VBox();
    private HBox informacionJugadores = new HBox();

    private Stage stage;
    private Kashoot kashoot;

    public ContenedorPreguntas(Stage stage, Kashoot kashoot, Scene escenaFinal,ContenedorFinalDelJuego contenedorFinalDeJuego) {

        Image imagen = new Image("preguDia.jpeg", 230, 350, false, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        this.stage = stage;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.setHeight(500);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(80);

        this.vistaKashoot = new VistaKashoot(kashoot,this,contenedorFinalDeJuego);
        this.actualizar();
    }

    public void actualizar() {
        this.getChildren().clear();

        preguntaYOpciones = new VBox();
        informacionJugadores = new HBox();

        this.setDatos();

        this.preguntaYOpciones.setAlignment(Pos.CENTER);
        this.preguntaYOpciones.setSpacing(60);

        this.botonesExtra.setAlignment(Pos.BASELINE_CENTER);

        this.informacionJugadores.setAlignment(Pos.TOP_LEFT);
        this.informacionJugadores.setSpacing(500);

        VBox reglasJuego = mostrarReglasDeJuego();

        this.getChildren().addAll(informacionJugadores, preguntaYOpciones, botonesExtra, reglasJuego);
    }

    private VBox mostrarReglasDeJuego() {
        VBox reglas = new VBox();

        HBox reglaMultiplicadores = mostrarUnaRegla("Multiplicadores: ", "Hacen tal cosa");
        HBox reglaExclusividad = mostrarUnaRegla("Exclusividad: ", "Hace tal otra cosa");

        reglas.getChildren().add(reglaMultiplicadores);
        reglas.getChildren().add(reglaExclusividad);
        reglas.setAlignment(Pos.BASELINE_CENTER);
        reglas.setSpacing(5);

        return reglas;
    }

    private HBox mostrarUnaRegla(String nombre, String descripcion) {
        HBox multiplicadores = new HBox();

        Label labelNombre = new Label("   " + nombre);
        labelNombre.setTextFill(Color.GRAY);
        labelNombre.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));

        Label labelDescripcion = new Label(descripcion);
        labelDescripcion.setTextFill(Color.GRAY);
        labelDescripcion.setFont(Font.font("Tahoma", FontWeight.THIN, 20));

        multiplicadores.getChildren().addAll(labelNombre, labelDescripcion);

        return multiplicadores;
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
        Label jugadorActual = new Label("Jugador actual: ");
        jugadorActual.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), new Insets(-5.0))));
        jugadorActual.setFont(Font.font("Arial",FontWeight.MEDIUM, 30));

        Label nombre = new Label(this.kashoot.obtenerJugadorActual().getNombre());
        nombre.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), new Insets(-5.0))));
        nombre.setFont(Font.font("Gill Sans",FontWeight.BLACK, 30));

        HBox infoJugadorActual = new HBox();
        infoJugadorActual.getChildren().addAll(jugadorActual, nombre);

        infoJugadorActual.setAlignment(Pos.CENTER);
        this.informacionJugadores.getChildren().add(infoJugadorActual);
    }

    public void setPuntajesJugadores(Kashoot kashoot){
        Label puntajeJugador1 = new Label();

        Jugador jugador1 = kashoot.obtenerJugadorActual();

        puntajeJugador1.setText(": ".concat(Integer.toString(jugador1.getPuntajeAcumulado())));
        puntajeJugador1.setFont(Font.font("Gill Sans",FontWeight.BOLD, 20));
        puntajeJugador1.setTextFill(Color.MEDIUMVIOLETRED);

        Label labelConNombreJugador1 = new Label();
        labelConNombreJugador1.setText("Puntaje parcial de " + jugador1.getNombre());
        labelConNombreJugador1.setFont(Font.font("Gill Sans",FontWeight.THIN, 20));
        labelConNombreJugador1.setTextFill(Color.MEDIUMVIOLETRED);

        kashoot.actualizarJugadorActual();

        Label puntajeJugador2 =new Label();

        Jugador jugador2 = kashoot.obtenerJugadorActual();

        puntajeJugador2.setText(": ".concat(Integer.toString(jugador2.getPuntajeAcumulado())));
        puntajeJugador2.setFont(Font.font("Gill Sans",FontWeight.BOLD, 20));
        puntajeJugador2.setTextFill(Color.MEDIUMVIOLETRED);

        Label labelConNombreJugador2 = new Label();
        labelConNombreJugador2.setText("Puntaje parcial de " + jugador2.getNombre());
        labelConNombreJugador2.setFont(Font.font("Gill Sans",FontWeight.THIN, 20));
        labelConNombreJugador2.setTextFill(Color.MEDIUMVIOLETRED);

        kashoot.actualizarJugadorActual();

        HBox boxJugador1 = new HBox();
        boxJugador1.getChildren().addAll(labelConNombreJugador1,puntajeJugador1);


        HBox boxJugador2 = new HBox();
        boxJugador2.getChildren().addAll(labelConNombreJugador2,puntajeJugador2);

        VBox boxDeAmbosJugadores = new VBox();
        boxDeAmbosJugadores.getChildren().addAll(boxJugador1, boxJugador2);
        boxDeAmbosJugadores.setBackground(new Background(new BackgroundFill(Color.LIGHTSALMON, new CornerRadii(5.0), new Insets(-5.0))));

        this.informacionJugadores.getChildren().add(boxDeAmbosJugadores);
    }

    public void setBotoneraExtras(){

        HBox botoneraExtras = new HBox();

        ToggleButton botonExclusividad = crearBotonExclusividad();
        botonExclusividad.setPrefSize(250, 50);
        verificacionExclusividad(botonExclusividad);

        ToggleButton responderNormal = crearBotonRespuestaNormal();
        responderNormal.setPrefSize(120, 50);

        ToggleButton multiplicadorX2 = crearBotonMultiplicadorx2();
        multiplicadorX2.setPrefSize(280, 50);
        ToggleButton multiplicadorX3 = crearBotonMultiplicadorx3();
        multiplicadorX3.setPrefSize(280, 50);
        verificacionMultiplicadores(multiplicadorX2, multiplicadorX3);

        botoneraExtras.getChildren().addAll(responderNormal, botonExclusividad,multiplicadorX2,multiplicadorX3);
        botoneraExtras.setSpacing(50);
        botoneraExtras.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5.0), new Insets(-5.0))));

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
        botonExclusividad.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15));
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
        responderNormal.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15));

        BotonResponderEventHandler botonResponderNormalEventHandler = new BotonResponderEventHandler(kashoot, vistaKashoot, this.escenaFinal, this.stage);
        responderNormal.setOnAction(botonResponderNormalEventHandler);

        return responderNormal;
    }

    private ToggleButton crearBotonMultiplicadorx3() {

        ToggleButton multiplicadorX3 =new ToggleButton();
        multiplicadorX3.setText("Responder con multiplicador x3");
        multiplicadorX3.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15));

        BotonMultiplicadorX3EventHandler botonMultiplicarX3EventHandler = new BotonMultiplicadorX3EventHandler(kashoot,this.vistaKashoot, this.escenaFinal, this.stage);
        multiplicadorX3.setOnAction(botonMultiplicarX3EventHandler);

        return multiplicadorX3;
    }

    private ToggleButton crearBotonMultiplicadorx2() {

        ToggleButton multiplicadorX2 = new ToggleButton();
        multiplicadorX2.setText("Responder con multiplicador x2");
        multiplicadorX2.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15));
        BotonMultiplicadorX2EventHandler botonMultiplicarX2EventHandler = new BotonMultiplicadorX2EventHandler(kashoot, this.vistaKashoot, this.escenaFinal, this.stage);
        multiplicadorX2.setOnAction(botonMultiplicarX2EventHandler);

        return multiplicadorX2;
    }

    public void setPregunta(){

        Label textoPregunta = new Label();

        Pregunta pregunta = this.vistaKashoot.getPregunta();
        String unContenido = pregunta.getContenido();

        textoPregunta.setText(unContenido);
        textoPregunta.setFont(Font.font("Gill Sans",FontWeight.BOLD, 40));
        textoPregunta.setTextAlignment(TextAlignment.CENTER);
        textoPregunta.setTextFill(Color.ROSYBROWN);
        textoPregunta.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5.0), new Insets(-5.0))));

        this.preguntaYOpciones.getChildren().add(textoPregunta);
    }

    public void setBotoneraOpciones() {

        HBox contenedorOpciones = new HBox();
        ArrayList<Opcion> opciones = this.vistaKashoot.getOpciones();


        for (Opcion opcion : opciones) {
            ToggleButton unBoton = new ToggleButton();
            unBoton.setText(opcion.getContenido());
            unBoton.setPrefSize(150, 90);
            unBoton.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 20));
            unBoton.setEffect(new DropShadow(2.0, Color.BLACK));
            contenedorOpciones.getChildren().add(unBoton);

            BotonOpcionEventHandler botonOpcionEventHandler = new BotonOpcionEventHandler(this.vistaKashoot.getRespuesta(), opcion);
            unBoton.setOnAction(botonOpcionEventHandler);
        }

        contenedorOpciones.setSpacing(200);
        contenedorOpciones.setAlignment(Pos.CENTER);

        this.preguntaYOpciones.getChildren().addAll(contenedorOpciones);

    }

}
