package edu.fiuba.algo3.vista;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

        Stage stage;

        public ContenedorBienvenidos(Stage stage/*, Scene proximaEscena*/) {

            super();

            this.stage = stage;

            this.setAlignment(Pos.CENTER);
            this.setSpacing(20);
            this.setPadding(new Insets(25));
            //Image imagen = new Image("file:src/vista/imagenes/textura.png");
            //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            //this.setBackground(new Background(imagenDeFondo));

            var labelBienvenida = new Label("Bienvenidos al kashoot!");
            labelBienvenida.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
            labelBienvenida.setTextFill(Color.RED);

            var labelIngresarNombre = new Label("ingresen sus nombres para comenzar");
            labelIngresarNombre.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
            labelIngresarNombre.setTextFill(Color.web("#66A7C5"));

            TextField textoJugador1 = new TextField();
            textoJugador1.setPromptText("Nobre del jugador 1:");
            textoJugador1.setAlignment(Pos.CENTER);
            TextField textoJugador2 = new TextField();
            textoJugador2.setPromptText("Nobre del jugador 2:");
            textoJugador2.setAlignment(Pos.CENTER);

            HBox contenedorDeNombres = new HBox(textoJugador1, textoJugador2);
            contenedorDeNombres.setSpacing(100);
            contenedorDeNombres.setAlignment(Pos.CENTER);

            Button botonJugar = new Button();
            botonJugar.setText("Jugar");

            //botonJugar botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
            //botonJugar.setOnAction(botonEntrarHandler);

            this.getChildren().addAll(labelBienvenida, labelIngresarNombre, contenedorDeNombres, botonJugar);

/*
            Button botonEntrar = new Button();
            botonEntrar.setText("Entrar");

            Label etiqueta = new Label();
            etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

            etiqueta.setText("Bienvenidos a la aplicación MVC con JAVA FX de algoritmos y programación III. Haga click en entrar");
            etiqueta.setTextFill(Color.web("#66A7C5"));

            BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
            botonEntrar.setOnAction(botonEntrarHandler);

            this.getChildren().addAll(etiqueta, botonEntrar);
        */}

}
