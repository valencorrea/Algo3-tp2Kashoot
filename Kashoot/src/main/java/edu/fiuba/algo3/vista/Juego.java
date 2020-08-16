package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.formatos.Clasico;
import edu.fiuba.algo3.modelo.formatos.Penalidad;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import edu.fiuba.algo3.vista.ContenedorBienvenidos;
import edu.fiuba.algo3.vista.ContenedorPreguntas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
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

        /* música */

        Media mp3MusicFile = new Media(new File("Kashoot/resources/mipan.mp3").toURI().toString());

        MediaPlayer musica = new MediaPlayer(mp3MusicFile);
        musica.setAutoPlay(true);
        musica.setOnEndOfMedia(() -> musica.seek(Duration.ZERO));

        musica.play();
        /**/

        stage.setTitle("Kashoot");

        Kashoot kashoot = crearModelo();

        ContenedorPreguntas contenedorPreguntas = new ContenedorPreguntas(stage, kashoot);
        Scene escenaJuego = new Scene(contenedorPreguntas, 640, 480);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego, kashoot);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);


        stage.show();
    }

    private Kashoot crearModelo() {

        //ArrayList <PreguntasYOpciones> preguntasYOpciones = leerArchivo("resources/archivo.txt");

        Opcion opcionCorrecta = new Opcion("Verdadero");
        Opcion opcionIncorrecta = new Opcion("Falsa");

        ArrayList <Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);

        Respuesta respuestaCorrecta = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta);
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Penalidad()), "Soy una pregunta?", respuestaCorrecta);

        Ronda ronda = new Ronda();
        ronda.agregarPregunta(unaPregunta);
        ronda.agregarOpciones(opciones);

       /* Opcion opcionCorrecta1 = new Opcion("opcion1");
        Opcion opcionIncorrecta2 = new Opcion("opcion2");
        Opcion opcionIncorrecta3 = new Opcion("opcion3");

        ArrayList <Opcion> opciones1 = new ArrayList<Opcion>();
        opciones.add(opcionCorrecta1);
        opciones.add(opcionIncorrecta2);
        //opciones.add(opcionIncorrecta3);

        Respuesta respuestaCorrecta2 = new Respuesta();
        respuestaCorrecta.agregarOpcion(opcionCorrecta1);
        Pregunta unaPregunta2 = new Pregunta(new ModalidadSinOrden(new Penalidad()), "Soy otra pregunta?", respuestaCorrecta2);

        Ronda ronda1 = new Ronda();
        ronda.agregarPregunta(unaPregunta2);
        ronda.agregarOpciones(opciones1);
*/
        Kashoot kashoot = new Kashoot();
        kashoot.agregarRonda(ronda);
        //kashoot.agregarRonda(ronda1);
        return kashoot;
    }

}



