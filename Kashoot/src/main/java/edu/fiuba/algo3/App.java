package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        var label = new Label("Bienvenido a KASHOOT");

        Opcion opcionCorrectaUno = new Opcion("uno");
        Opcion opcionCorrectaDos = new Opcion("dos");
        Opcion opcionIncorrectaTres = new Opcion("tres");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrectaUno);
        respuestaCorrecta.agregarOpcion(opcionCorrectaDos);


        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()),"hola soy una pregunta??",respuestaCorrecta);

        var label1 = new Label(unaPregunta.getContenido());

        VBox contenedor = new VBox(label,label1);


        var scene = new Scene(contenedor, 640, 480);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}