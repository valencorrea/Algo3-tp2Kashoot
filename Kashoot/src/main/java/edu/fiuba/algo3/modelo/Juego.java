package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.formatos.Clasico;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import edu.fiuba.algo3.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.vista.ContenedorPreguntas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
     * JavaFX App
     *
     */

    public class Juego extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kashoot");

        Kashoot kashoot = crearModelo();

        ContenedorPreguntas contenedorPreguntas = new ContenedorPreguntas(stage, kashoot);
        Scene escenaJuego = new Scene(contenedorPreguntas, 640, 480);

        //AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        //escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();
    }

    private Kashoot crearModelo() {
        //ArrayList <PreguntasYOpciones> preguntasYOpciones = leerArchivo("file:src/main/java/edu.fiuba.algo3/resources/archivo.txt");

        Opcion opcionCorrecta = new Opcion("Verdadero");
        Opcion opcionIncorrecta = new Opcion("Falsa");

        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Respuesta respuestaIncorrecta = new Respuesta();
        respuestaIncorrecta.agregarOpcion(opcionIncorrecta);
        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "Soy pregunta?", respuestaCorrecta);


        PreguntasYOpciones prgyOpc1= new PreguntasYOpciones(unaPregunta,opciones);

        ArrayList <PreguntasYOpciones> preguntasYOpciones= new ArrayList<PreguntasYOpciones>();
        preguntasYOpciones.add(prgyOpc1);

        Kashoot kashoot = new Kashoot(preguntasYOpciones);
        return kashoot;
    }

    /*
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Kashoot");
        Kashoot kashoot = new Kashoot();
        VBox vbox = kashoot.mostrarPregunta();
       // vbox.getChildren().add(new TextField());
       // vbox.getChildren().add(new TextField());
        //vbox.setOnKeyPressed(new MainKeyboardController(playerModel,  map));
        Scene theScene = new Scene(vbox);
        stage.setScene(theScene);
        stage.show();
        stage.setFullScreen(true);
    }*/
}

/*
public class App extends Application {

    @Override
    public void start(Stage stage){

        stage.setTitle("Bienvenidos a kashoot");

        Opcion opcionCorrecta = new Opcion("holis soy correcta");
        Opcion opcionIncorrecta = new Opcion("yo soy incorrecta :c");

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);

        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()),"una pregunta????????",respuestaCorrecta);

        var label = new Label(unaPregunta.getContenido());

        Button button = new Button();
        button.setText(opcionCorrecta.getContenido());
        button.setPrefSize(300, 100);

        Button button2 = new Button();
        button2.setText(opcionIncorrecta.getContenido());
        button2.setPrefSize(300, 100);

        StackPane layout = new StackPane();

        layout.getChildren().add(button);
        layout.getChildren().add(button2);

        HBox hbox = new HBox(button, button2);
        hbox.setSpacing(200);
        hbox.setAlignment(Pos.CENTER);

        VBox contenedorPrincipal = new VBox(label, hbox, new Label());
        contenedorPrincipal.setSpacing(100);
        contenedorPrincipal.setPadding(new Insets(20));

        Scene escena= new Scene(contenedorPrincipal, 900, 600);
        stage.setScene(escena);
        stage.show();
        stage.setFullScreen(true);
    }

    public static void main(String[] args) {
        Kashoot kashoot = new Kashoot();
        kashoot.iniciar();
        //launch();
    }
*/


