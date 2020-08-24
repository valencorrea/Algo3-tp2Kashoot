package edu.fiuba.algo3.vista.contenedores;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Button;
import edu.fiuba.algo3.vista.botones.BotonJugarEventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
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

            VBox datosJugador1 = ubicarDatosJugador(nombreUnJugador, 1);
            VBox datosJugador2 = ubicarDatosJugador(nombreOtroJugador, 2);

            HBox contenedorDeNombres = new HBox(datosJugador1, datosJugador2);
            contenedorDeNombres.setSpacing(200);
            contenedorDeNombres.setAlignment(Pos.CENTER);

            Label mensajeNombreVacio = crearMensajeNombreVacio(contenedorDeNombres);

            Button botonJugar = crearBotonJugar();
            BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, proximaEscena, contenedorPreguntas, nombreUnJugador, nombreOtroJugador, mensajeNombreVacio, kashoot);
            botonJugar.setOnAction(botonJugarEventHandler);

            Label terminosYCondiciones = mostrarTerminosYCondiciones();

            this.getChildren().addAll(saludoInicial, contenedorDeNombres, mensajeNombreVacio, botonJugar, terminosYCondiciones);

        }

    private VBox ubicarDatosJugador(TextField nombreUnJugador, int numeroJugador) {
        VBox datosJugador2 = new VBox();

        nombreUnJugador.setAlignment(Pos.CENTER);
        nombreUnJugador.setScaleX(1.5);
        nombreUnJugador.setScaleY(1.5);
        nombreUnJugador.setPromptText("Nombre del jugador " + numeroJugador);

        CheckBox terminos = new CheckBox("He leido y acepto los terminos y condiciones.");
        terminos.setSelected(false);

        datosJugador2.getChildren().add(nombreUnJugador);
        datosJugador2.getChildren().add(terminos);
        datosJugador2.setSpacing(20);

        return datosJugador2;
    }


    private VBox saludar() {
        VBox saludo = new VBox();
        Label labelBienvenida = mostrarLabelInicial();
        //Label terminosYCondiciones = mostrarTerminosYCondiciones();
        Label labelIngresarNombre = crearLabelPedidoNombres();

        saludo.setAlignment(Pos.CENTER);
        saludo.setSpacing(50);

        saludo.getChildren().addAll(labelBienvenida, labelIngresarNombre/*, terminosYCondiciones*/);
        return saludo;
    }

    private Label mostrarTerminosYCondiciones() {
        Label terminos = new Label("\n\n\n\nTerminos y condiciones: \nAnte el turno en el cual debe jugar su oponente, promete no mirar la pantalla, en funcion de evitar que estas respuestas tengan influencia en las propias.");
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
        Label labelBienvenida = new Label("¡Bienvenidos al kashoot!");
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
        Image imagen = new Image("patronvivo.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

}
