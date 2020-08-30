package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.vista.*;
import edu.fiuba.algo3.vista.botones.*;
import edu.fiuba.algo3.vista.botones.responder.BotonExclusividadEventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonMultiplicadorX2EventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonMultiplicadorX3EventHandler;
import edu.fiuba.algo3.vista.botones.responder.BotonResponderEventHandler;
import edu.fiuba.algo3.vista.botones.volumen.BotonBajarVolumenEventHandler;
import edu.fiuba.algo3.vista.botones.volumen.BotonSubirVolumenEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;

import java.util.ArrayList;

public class ContenedorPreguntas extends VBox {

    private ContenedorFinalDelJuego contenedorFinal;
    private double volumen;
    private MediaPlayer musica;
    private Scene escenaFinal;
    private VistaKashoot vistaKashoot;
    private HBox botonesExtra;
    private VBox preguntaYOpciones = new VBox();
    private HBox labelSuperior = new HBox();
    private boolean modoDiurno = true;

    private Stage stage;
    private Kashoot kashoot;
    private HBox labelJugadorActual;

    public ContenedorPreguntas(MediaPlayer musica, double volumen, Stage stage, Kashoot kashoot, Scene escenaFinal, ContenedorFinalDelJuego contenedorFinalDeJuego) {

        this.stage = stage;
        this.kashoot = kashoot;
        this.escenaFinal = escenaFinal;
        this.musica = musica;
        this.volumen = volumen;
        this.contenedorFinal = contenedorFinalDeJuego;

        setearImagenDeFondo();
        this.setHeight(500);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);

        this.vistaKashoot = new VistaKashoot(kashoot,this,contenedorFinalDeJuego);
        this.actualizar();
    }

    private void setearImagenDeFondo() {
        Image imagen = new Image("modoDiurno.jpg", 230, 350, false, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    public void actualizar() {
        this.getChildren().clear();

        preguntaYOpciones = new VBox();
        labelSuperior = new HBox();
        labelJugadorActual = new HBox();

        this.setDatos();

        this.preguntaYOpciones.setAlignment(Pos.CENTER);
        this.preguntaYOpciones.setSpacing(60);

        this.labelJugadorActual.setAlignment(Pos.CENTER);

        this.botonesExtra.setAlignment(Pos.BASELINE_CENTER);

        this.labelSuperior.setAlignment(Pos.TOP_LEFT);
        this.labelSuperior.setSpacing(180);

        VBox reglasJuego = mostrarReglasDeJuego();

        this.getChildren().addAll(labelSuperior, labelJugadorActual, preguntaYOpciones, botonesExtra, reglasJuego);
    }

    private VBox mostrarReglasDeJuego() {
        VBox reglas = new VBox();

        HBox reglaMultiplicadores = mostrarUnaRegla("Multiplicadores: ", "Solo para preguntas con formato penalidad!! Aplica unicamente a quien la seleccionó, multiplicando el puntaje obtenido por el valor seleccionado.");
        HBox reglaExclusividad = mostrarUnaRegla("Exclusividad: ", "Para cualquier formato a excepcion de penalidad. Duplica o cuadriplica el puntaje de quien gane esa ronda, dependiendo de cuantos jugadores la seleccionen.\nSi ambos responden bien, no se le asignará a ninguno.");
        HBox nota = mostrarUnaRegla("NOTA: ", "Cada jugador posee dos exclusividades, un multiplicador x2 y uno x3.");

        reglas.getChildren().add(reglaMultiplicadores);
        reglas.getChildren().add(reglaExclusividad);
        reglas.getChildren().add(nota);
        reglas.setAlignment(Pos.BASELINE_CENTER);
        reglas.setSpacing(5);

        return reglas;
    }

    private HBox mostrarUnaRegla(String nombre, String descripcion) {
        HBox multiplicadores = new HBox();

        Label labelNombre = new Label("   " + nombre);
        labelNombre.setTextFill(Color.GRAY);
        labelNombre.setFont(Font.font("Tahoma", FontWeight.BLACK, 13));

        Label labelDescripcion = new Label(descripcion);
        labelDescripcion.setTextFill(Color.GRAY);
        labelDescripcion.setFont(Font.font("Tahoma", FontWeight.THIN, 13));

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
        this.setLabelSuperior(this.kashoot);
        this.setJugadorActual();
    }

    public void setJugadorActual(){
        Label jugadorActual = new Label("Jugador actual: ");
        jugadorActual.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(5.0), new Insets(-5.0))));
        jugadorActual.setFont(Font.font("Arial",FontWeight.MEDIUM, 30));

        Label nombre = new Label(this.kashoot.obtenerJugadorActual().getNombre());
        nombre.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(5.0), new Insets(-5.0))));
        nombre.setFont(Font.font("Gill Sans",FontWeight.BLACK, 30));

        HBox infoJugadorActual = new HBox();
        infoJugadorActual.getChildren().addAll(jugadorActual, nombre);

        infoJugadorActual.setAlignment(Pos.CENTER);
        this.labelJugadorActual.getChildren().add(infoJugadorActual);
    }

    public void setLabelSuperior(Kashoot kashoot){
        Label puntajeJugador1 = new Label();

        Jugador jugador1 = kashoot.obtenerJugadorActual();

        puntajeJugador1.setText(": ".concat(Integer.toString(jugador1.getPuntajeAcumulado())));
        puntajeJugador1.setFont(Font.font("Gill Sans",FontWeight.BOLD, 17));
        puntajeJugador1.setTextFill(Color.MEDIUMVIOLETRED);

        Label labelConNombreJugador1 = new Label();
        labelConNombreJugador1.setText(" Puntaje parcial de " + jugador1.getNombre());
        labelConNombreJugador1.setFont(Font.font("Gill Sans",FontWeight.THIN, 17));
        labelConNombreJugador1.setTextFill(Color.MEDIUMVIOLETRED);

        kashoot.actualizarJugadorActual();

        Label puntajeJugador2 =new Label();

        Jugador jugador2 = kashoot.obtenerJugadorActual();

        puntajeJugador2.setText(": ".concat(Integer.toString(jugador2.getPuntajeAcumulado())));
        puntajeJugador2.setFont(Font.font("Gill Sans",FontWeight.BOLD, 17));
        puntajeJugador2.setTextFill(Color.MEDIUMVIOLETRED);

        Label labelConNombreJugador2 = new Label();
        labelConNombreJugador2.setText(" Puntaje parcial de " + jugador2.getNombre());
        labelConNombreJugador2.setFont(Font.font("Gill Sans",FontWeight.THIN, 17));
        labelConNombreJugador2.setTextFill(Color.MEDIUMVIOLETRED);

        kashoot.actualizarJugadorActual();

        HBox boxJugador1 = new HBox();
        boxJugador1.getChildren().addAll(labelConNombreJugador1,puntajeJugador1);
        boxJugador1.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(5.0), new Insets(-5.0))));

        HBox boxJugador2 = new HBox();
        boxJugador2.getChildren().addAll(labelConNombreJugador2,puntajeJugador2);
        boxJugador2.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(5.0), new Insets(-5.0))));

        VBox boxDeAmbosJugadores = new VBox();
        boxDeAmbosJugadores.getChildren().addAll(boxJugador1, boxJugador2);
        boxDeAmbosJugadores.setSpacing(5);

        Label recordatorio = new Label("¡Acordate de seleccionar todas tus opciones antes de cualquier boton de responder!");
        recordatorio.setFont(Font.font("Gill Sans",FontWeight.THIN, 16));
        recordatorio.setAlignment(Pos.BOTTOM_CENTER);

        VBox botonesVolumen = botoneraOpcionesCalidadJuego();

        HBox labelSuperior = new HBox();
        labelSuperior.getChildren().addAll(boxDeAmbosJugadores, recordatorio);
        labelSuperior.setSpacing(90);

        this.labelSuperior.getChildren().add(labelSuperior);
        this.labelSuperior.getChildren().add(botonesVolumen);

    }

    private VBox botoneraOpcionesCalidadJuego() {
        VBox botonera = new VBox();

        Button botonModoNocturno = crearBotonModoNocturno();
        HBox botonesVolumen = crearBotoneraVolumen();

        botonera.getChildren().addAll(botonModoNocturno, botonesVolumen);
        botonera.setSpacing(5);
        botonera.setAlignment(Pos.CENTER);

        return botonera;
    }

    private HBox crearBotoneraVolumen() {
        HBox botonesVolumen = new HBox();

        Button botonSubirVolumen = crearBotonSubirVolumen();
        Button botonBajarVolumen = crearBotonBajarVolumen();

        botonesVolumen.getChildren().addAll(botonSubirVolumen, botonBajarVolumen);
        botonesVolumen.setSpacing(5);
        botonesVolumen.setAlignment(Pos.CENTER);

        return botonesVolumen;
    }

    private Button crearBotonBajarVolumen() {
        Button botonBajarVolumen = new Button("Vol --");
        BotonBajarVolumenEventHandler botonBajarVolumenEventHandler = new BotonBajarVolumenEventHandler(musica, volumen);
        botonBajarVolumen.setOnAction(botonBajarVolumenEventHandler);

        return botonBajarVolumen;
    }

    private Button crearBotonSubirVolumen() {
        Button botonSubirVolumen = new Button("Vol ++");
        BotonSubirVolumenEventHandler botonSubirVolumenEventHandler = new BotonSubirVolumenEventHandler(musica, volumen);
        botonSubirVolumen.setOnAction(botonSubirVolumenEventHandler);

        return botonSubirVolumen;
    }

    private Button crearBotonModoNocturno() {
        Button botonModoNocturno = new Button("      Activar\nmodo nocturno");
        BotonModoNocturnoEventHandler botonModoNocturnoEventHandler = new BotonModoNocturnoEventHandler(this, this.contenedorFinal, this.modoDiurno, botonModoNocturno);
        botonModoNocturno.setOnAction(botonModoNocturnoEventHandler);
        botonModoNocturno.setPrefSize(130, 40);

        return botonModoNocturno;
    }

    public void setBotoneraExtras(){

        HBox botoneraExtras = new HBox();

        ToggleButton botonExclusividad = crearBotonExclusividad();
        botonExclusividad.setPrefSize(250, 40);
        verificacionExclusividad(botonExclusividad);

        ToggleButton responderNormal = crearBotonRespuestaNormal();
        responderNormal.setPrefSize(120, 40);

        ToggleButton multiplicadorX2 = crearBotonMultiplicadorx2();
        multiplicadorX2.setPrefSize(280, 40);
        ToggleButton multiplicadorX3 = crearBotonMultiplicadorx3();
        multiplicadorX3.setPrefSize(280, 40);
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
