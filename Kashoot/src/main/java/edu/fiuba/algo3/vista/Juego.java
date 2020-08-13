package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
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

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego, kashoot);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        /*musica:
         *
         *  String musicFile = "";
         *  Media sound = new Media(new File(musicFile).toURI().toString());
         *  MediaPlayer mediaPlayer = new MediaPlayer(sound);
         *  mediaPlayer.play();
         *
         */
        stage.show();
    }

    private Kashoot crearModelo() {

        //ArrayList <PreguntasYOpciones> preguntasYOpciones = leerArchivo("file:src/main/java/edu.fiuba.algo3/resources/archivo.txt");

        Opcion opcionCorrecta = new Opcion("Verdadero");
        Opcion opcionIncorrecta = new Opcion("Falsa");

        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "Soy pregunta?", respuestaCorrecta);


        PreguntasYOpciones prgyOpc1= new PreguntasYOpciones(unaPregunta,opciones);
        ArrayList <PreguntasYOpciones> preguntasYOpciones= new ArrayList<PreguntasYOpciones>();
        preguntasYOpciones.add(prgyOpc1);

        Kashoot kashoot = new Kashoot(preguntasYOpciones);
        return kashoot;
    }

}



