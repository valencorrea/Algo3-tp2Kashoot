package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import edu.fiuba.algo3.vista.botones.BotonJugarEventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

        Stage stage;
        ContenedorPreguntas contenedorPreguntas;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena, Kashoot kashoot, ContenedorPreguntas contenedorPreguntas) {

            super();
            seteosIniciales(stage, contenedorPreguntas);
            VBox saludoInicial = saludar();

            TextField nombreUnJugador = new TextField();
            TextField nombreOtroJugador = new TextField();

            CheckBox unaCheckbox = new CheckBox("He leido y acepto los terminos y condiciones.");
            CheckBox otraCheckbox = new CheckBox("He leido y acepto los terminos y condiciones.");

            VBox datosJugador1 = ubicarDatosJugador(nombreUnJugador, 1, unaCheckbox);
            VBox datosJugador2 = ubicarDatosJugador(nombreOtroJugador, 2, otraCheckbox);

            HBox contenedorDeNombres = new HBox(datosJugador1, datosJugador2);
            contenedorDeNombres.setSpacing(200);
            contenedorDeNombres.setAlignment(Pos.CENTER);

            Label mensajeErrorCheckbox = crearMensajeErrorCheckbox(contenedorDeNombres);
            Label mensajeNombreVacio = crearMensajeNombreVacio(contenedorDeNombres);
            Label terminosYCondiciones = mostrarTerminosYCondiciones();

            Button botonJugar = crearBotonJugar();
            BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, proximaEscena, contenedorPreguntas, nombreUnJugador, nombreOtroJugador, mensajeNombreVacio, unaCheckbox, otraCheckbox, mensajeErrorCheckbox, kashoot);
            botonJugar.setOnAction(botonJugarEventHandler);

            this.getChildren().addAll(saludoInicial, contenedorDeNombres, mensajeNombreVacio, mensajeErrorCheckbox, botonJugar, terminosYCondiciones);

        }

    private VBox ubicarDatosJugador(TextField nombreUnJugador, int numeroJugador, CheckBox terminos) {
        VBox datosJugador = new VBox();

        nombreUnJugador.setAlignment(Pos.CENTER);
        nombreUnJugador.setScaleX(1.5);
        nombreUnJugador.setScaleY(1.5);
        nombreUnJugador.setPromptText("Nombre del jugador " + numeroJugador);

        terminos.setSelected(false);

        datosJugador.getChildren().add(nombreUnJugador);
        datosJugador.getChildren().add(terminos);
        datosJugador.setSpacing(20);

        return datosJugador;
    }

    private VBox saludar() {
        VBox saludo = new VBox();
        Label labelBienvenida = mostrarLabelInicial();
        Label labelIngresarNombre = crearLabelPedidoNombres();

        saludo.setAlignment(Pos.CENTER);
        saludo.setSpacing(50);

        saludo.getChildren().addAll(labelBienvenida, labelIngresarNombre/*, terminosYCondiciones*/);
        return saludo;
    }

    private Label mostrarTerminosYCondiciones() {
        Label terminos = new Label("\n\n\n\nTerminos y condiciones: \nAnte el turno en el cual debe jugar su oponente, promete no mirar la pantalla, en funcion de evitar que estas respuestas\ntengan influencia en las propias.");
        terminos.setFont(Font.font("Tahoma", FontWeight.THIN, 15));
        terminos.setTextFill(Color.GRAY);
        terminos.setAlignment(Pos.CENTER);
        return terminos;

    }

    private Label crearMensajeNombreVacio(HBox contenedorDeNombres) {
        Label mensajeError = new Label();
        mensajeError.setAlignment(Pos.CENTER);
        mensajeError.setFont(Font.font("Tahoma", FontWeight.BLACK, 15));
        contenedorDeNombres.getChildren().add(mensajeError);

        return mensajeError;
    }

    private Label crearMensajeErrorCheckbox(HBox contenedorDeNombres) {
        Label mensajeError = new Label();
        mensajeError.setAlignment(Pos.CENTER);
        mensajeError.setFont(Font.font("Tahoma", FontWeight.BLACK, 15));
        contenedorDeNombres.getChildren().add(mensajeError);

        return mensajeError;
    }

    private Button crearBotonJugar() {
        Button botonJugar = new Button();
        botonJugar.setText("JUGAR");
        botonJugar.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 36));
        botonJugar.setPrefSize(200, 80);

        return botonJugar;
    }

    private Label crearLabelPedidoNombres() {
        Label labelIngresarNombre = new Label("Ingresen sus nombres para comenzar");
        labelIngresarNombre.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 40));
        labelIngresarNombre.setTextFill(Color.web("#66A7C5"));
        return labelIngresarNombre;
    }

    private Label mostrarLabelInicial() {
        Label labelBienvenida = new Label("¡Bienvenidos al Kashoot!");
        labelBienvenida.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(5.0), new Insets(-5.0))));

        labelBienvenida.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 70));
        labelBienvenida.setTextFill(Color.HOTPINK);
        return labelBienvenida;
    }

    private void seteosIniciales(Stage stage, ContenedorPreguntas contenedorPreguntas) {
        this.stage = stage;
        this.contenedorPreguntas = contenedorPreguntas;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        agregarImagen();
    }

    private void agregarImagen() {
        Image imagen = new Image("modoDiurno.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

}
