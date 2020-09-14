package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.vista.VistaKashoot;
import edu.fiuba.algo3.vista.botones.modoPantalla.BotonModoDiurnoEventHandler;
import edu.fiuba.algo3.vista.botones.modoPantalla.BotonModoNocturnoEventHandler;
import edu.fiuba.algo3.vista.botones.BotonOpcionEventHandler;
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

import java.util.ArrayList;

public class ContenedorPreguntas extends VBox {

    private ContenedorFinalDelJuego contenedorFinal;
    private double volumen;
    private MediaPlayer musica;
    private Scene escenaFinal;
    private VistaKashoot vistaKashoot;
    private VBox botonesExtra;
    private VBox preguntaYOpciones = new VBox();
    private HBox labelSuperior = new HBox();
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
        this.setSpacing(30);

        this.vistaKashoot = new VistaKashoot(kashoot,this,contenedorFinalDeJuego);
        this.actualizar();
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

        this.labelSuperior.setAlignment(Pos.CENTER);
        this.labelSuperior.setSpacing(350);

        VBox reglasJuego = mostrarReglasDeJuego();

        this.getChildren().addAll(labelSuperior, labelJugadorActual, preguntaYOpciones, botonesExtra, reglasJuego);
    }


    /* setters */

    private void setDatos() {
        this.setcentro();
        this.setBotoneraRespuestas();
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
        jugadorActual.setFont(Font.font("Gill Sans",FontWeight.MEDIUM, 30));

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
        Label labelConNombreJugador1 = new Label();
        Jugador jugador1 = kashoot.obtenerJugadorActual();

        mostrarPuntajeParcialDelJugador(puntajeJugador1, jugador1);
        mostrarNombreDelJugador(jugador1, labelConNombreJugador1);

        kashoot.actualizarJugadorActual();

        Label puntajeJugador2 =new Label();
        Label labelConNombreJugador2 = new Label();
        Jugador jugador2 = kashoot.obtenerJugadorActual();

        mostrarPuntajeParcialDelJugador(puntajeJugador2, jugador2);
        mostrarNombreDelJugador(jugador2, labelConNombreJugador2);

        kashoot.actualizarJugadorActual();

        HBox boxJugador1 = crearBoxSuperiorDelJugador(labelConNombreJugador1, puntajeJugador1);
        HBox boxJugador2 = crearBoxSuperiorDelJugador(labelConNombreJugador2, puntajeJugador2);

        VBox boxDeAmbosJugadores = new VBox();
        boxDeAmbosJugadores.getChildren().addAll(boxJugador1, boxJugador2);
        boxDeAmbosJugadores.setSpacing(5);

        VBox botonesVolumen = botoneraOpcionesCalidadJuego();

        HBox labelSuperior = new HBox();
        labelSuperior.getChildren().addAll(boxDeAmbosJugadores);
        labelSuperior.setSpacing(90);

        this.labelSuperior.getChildren().add(labelSuperior);
        this.labelSuperior.getChildren().add(botonesVolumen);

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

        contenedorOpciones.setSpacing(100);
        contenedorOpciones.setAlignment(Pos.CENTER);

        this.preguntaYOpciones.getChildren().addAll(contenedorOpciones);

    }

    private void setearImagenDeFondo() {
        Image imagen = new Image("modoDiurno.jpg", 230, 350, false, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }


    /* verificaciones */

    private void verificacionExclusividad(ToggleButton botonExclusividad) {

        if(this.vistaKashoot.getPregunta().puedeMultiplicar() || !kashoot.obtenerJugadorActual().tieneExclusividad()){
            botonExclusividad.setDisable(true);
        }
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


    /* botones */

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
        Button botonModoNocturno = new Button("Modo\nnoche");
        BotonModoNocturnoEventHandler botonModoNocturnoEventHandler = new BotonModoNocturnoEventHandler(this, this.contenedorFinal, botonModoNocturno);
        botonModoNocturno.setOnAction(botonModoNocturnoEventHandler);
        botonModoNocturno.setPrefSize(50, 40);

        return botonModoNocturno;
    }

    private Button crearBotonModoDiurno() {
        Button botonModoDiurno = new Button("Modo\n  dia");
        BotonModoDiurnoEventHandler botonModoDiurnoEventHandler = new BotonModoDiurnoEventHandler(this, this.contenedorFinal, botonModoDiurno);
        botonModoDiurno.setOnAction(botonModoDiurnoEventHandler);
        botonModoDiurno.setPrefSize(50, 40);

        return botonModoDiurno;
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

    private ToggleButton crearBotonExclusividad() {

        ToggleButton botonExclusividad = new ToggleButton();
        botonExclusividad.setText("Responder con exclusividad");
        botonExclusividad.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 15));
        BotonExclusividadEventHandler botonExclusividadEventHandler = new BotonExclusividadEventHandler(kashoot,vistaKashoot,escenaFinal,stage);
        botonExclusividad.setOnAction(botonExclusividadEventHandler);

        return botonExclusividad;
    }


    /* botoneras */

    public void setBotoneraRespuestas(){

        VBox botoneraGeneral = new VBox();
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
        botoneraExtras.setSpacing(10);
        botoneraExtras.setAlignment(Pos.CENTER);

        botoneraGeneral.setSpacing(10);
        botoneraGeneral.getChildren().addAll(crearLabelRecordatorioDeOrdenSeleccion(), botoneraExtras);
        botoneraGeneral.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5.0), new Insets(-5.0))));

        this.botonesExtra = botoneraGeneral;

    }

    private VBox botoneraOpcionesCalidadJuego() {
        VBox botonera = new VBox();

        HBox botonesModoPantalla = crearBotoneraModoPantalla();
        HBox botonesVolumen = crearBotoneraVolumen();

        botonera.getChildren().addAll(botonesModoPantalla, botonesVolumen);
        botonera.setSpacing(18);
        botonera.setAlignment(Pos.CENTER);

        return botonera;
    }

    private HBox crearBotoneraModoPantalla() {
        HBox botonesModo = new HBox();

        Button botonModoNocturno = crearBotonModoNocturno();
        Button botonModoDiurno = crearBotonModoDiurno();

        botonesModo.getChildren().addAll(botonModoNocturno, botonModoDiurno);
        botonesModo.setSpacing(5);
        botonesModo.setAlignment(Pos.CENTER);

        return botonesModo;
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


    /* visual */

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
        labelNombre.setTextFill(Color.ROSYBROWN);
        labelNombre.setFont(Font.font("Tahoma", FontWeight.BLACK, 13));

        Label labelDescripcion = new Label(descripcion);
        labelDescripcion.setTextFill(Color.ROSYBROWN);
        labelDescripcion.setFont(Font.font("Tahoma", FontWeight.THIN, 13));

        multiplicadores.getChildren().addAll(labelNombre, labelDescripcion);
        return multiplicadores;
    }

    private void mostrarNombreDelJugador(Jugador jugador, Label labelConNombreJugador) {
        labelConNombreJugador.setText(" Puntaje parcial de " + jugador.getNombre());
        labelConNombreJugador.setFont(Font.font("Gill Sans",FontWeight.THIN, 17));
        labelConNombreJugador.setTextFill(Color.MEDIUMVIOLETRED);
    }

    private void mostrarPuntajeParcialDelJugador(Label puntajeJugador, Jugador unJugador) {
        puntajeJugador.setText(": ".concat(Integer.toString(unJugador.getPuntajeAcumulado())));
        puntajeJugador.setFont(Font.font("Gill Sans",FontWeight.BOLD, 17));
        puntajeJugador.setTextFill(Color.MEDIUMVIOLETRED);
    }

    private Label crearLabelRecordatorioDeOrdenSeleccion() {
        Label recordatorio = new Label("¡Acordate de seleccionar todas tus opciones antes de cualquier boton de responder!");
        recordatorio.setFont(Font.font("Gill Sans",FontWeight.THIN, 16));
        recordatorio.setAlignment(Pos.BOTTOM_CENTER);

        return recordatorio;
    }

    private HBox crearBoxSuperiorDelJugador(Label labelConNombreJugador, Label puntajeJugador) {
        HBox boxJugador = new HBox();
        boxJugador.getChildren().addAll(labelConNombreJugador ,puntajeJugador);
        boxJugador.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(5.0), new Insets(-5.0))));

        return boxJugador;
    }

}
