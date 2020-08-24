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

            Label labelBienvenida = crearLabelInicial();
            Label labelIngresarNombre = crearLabelPedidoNombres();

            VBox contenedorEtiquetas = new VBox(labelBienvenida, labelIngresarNombre);
            contenedorEtiquetas.setSpacing(170);
            contenedorEtiquetas.setAlignment(Pos.CENTER);

            TextField textoJugador1 = recibirNombreJugador1();
            TextField textoJugador2 = recibirNombreJugador2();

            HBox contenedorDeNombres = new HBox(textoJugador1, textoJugador2);
            contenedorDeNombres.setSpacing(200);
            contenedorDeNombres.setAlignment(Pos.CENTER);

            Label mensajeNombreVacio = crearMensajeNombreVacio(contenedorDeNombres);

            Button botonJugar = crearBotonJugar();
            BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, proximaEscena, contenedorPreguntas, textoJugador1, textoJugador2, mensajeNombreVacio, kashoot);
            botonJugar.setOnAction(botonJugarEventHandler);

            this.getChildren().addAll(contenedorEtiquetas, contenedorDeNombres, mensajeNombreVacio, botonJugar);

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

    private TextField recibirNombreJugador2() {
        TextField textoJugador2 = new TextField();
        textoJugador2.setPromptText("Nombre del jugador 2");
        String nombreJugador2 = textoJugador2.getText();
        textoJugador2.setAlignment(Pos.CENTER);
        textoJugador2.setScaleX(1.5);
        textoJugador2.setScaleY(1.5);
        return textoJugador2;
    }

    private TextField recibirNombreJugador1() {
        TextField textoJugador1 = new TextField();
        textoJugador1.setPromptText("Nombre del jugador 1");
        textoJugador1.setAlignment(Pos.CENTER);
        textoJugador1.setScaleX(1.5);
        textoJugador1.setScaleY(1.5);

        return textoJugador1;
    }

    private Label crearLabelPedidoNombres() {
        Label labelIngresarNombre = new Label("Ingresen sus nombres para comenzar");
        labelIngresarNombre.setFont(Font.font("Tahoma", FontWeight.EXTRA_LIGHT, 40));
        labelIngresarNombre.setTextFill(Color.web("#66A7C5"));
        return labelIngresarNombre;
    }

    private Label crearLabelInicial() {
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
