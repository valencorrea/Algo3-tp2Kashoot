package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.formatos.Clasico;
import edu.fiuba.algo3.modelo.formatos.Parcial;
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
        musica.setVolume(0.1);
        musica.play();
        /**/

        stage.setTitle("Kashoot");

        Kashoot kashoot = crearModelo();

        ContenedorFinalDelJuego contenedorFinalDeJuego = new ContenedorFinalDelJuego(stage, kashoot);
        Scene escenaFinalDeJuego = new Scene(contenedorFinalDeJuego, 640, 480);

        ContenedorPreguntas contenedorPreguntas = new ContenedorPreguntas(stage, kashoot, escenaFinalDeJuego);
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
        Pregunta unaPregunta = new Pregunta(new ModalidadSinOrden(new Clasico()), "Soy una pregunta?", respuestaCorrecta);

        Ronda ronda1 = new Ronda();
        ronda1.agregarPregunta(unaPregunta);
        ronda1.agregarOpciones(opciones);
    //-------------------------------------------//
        Opcion opcionCorrecta1 = new Opcion("opcion1");
        Opcion opcionIncorrecta2 = new Opcion("opcion2");
        Opcion opcionIncorrecta3 = new Opcion("opcion3");

        ArrayList <Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcionCorrecta1);
        opciones2.add(opcionIncorrecta2);
        opciones2.add(opcionIncorrecta3);

        Respuesta respuestaCorrecta2 = new Respuesta();
        respuestaCorrecta2.agregarOpcion(opcionCorrecta1);
        Pregunta unaPregunta2 = new Pregunta(new ModalidadSinOrden(new Clasico()), "de que color es el cielo?", respuestaCorrecta2);

        Ronda ronda2 = new Ronda();
        ronda2.agregarPregunta(unaPregunta2);
        ronda2.agregarOpciones(opciones2);
        //---------------------------------//
        Opcion opcionCorrecta31 = new Opcion("opcion1");
        Opcion opcionIncorrecta32 = new Opcion("opcion2");
        Opcion opcionIncorrecta33 = new Opcion("opcion3");
        Opcion opcionCorrecta34 = new Opcion("opcion4");

        ArrayList <Opcion> opciones3 = new ArrayList<Opcion>();
        opciones3.add(opcionCorrecta31);
        opciones3.add(opcionIncorrecta32);
        opciones3.add(opcionIncorrecta33);
        opciones3.add(opcionCorrecta34);

        Respuesta respuestaCorrecta3 = new Respuesta();
        respuestaCorrecta3.agregarOpcion(opcionCorrecta31);
        respuestaCorrecta3.agregarOpcion(opcionCorrecta34);
        Pregunta unaPregunta3 = new Pregunta(new ModalidadSinOrden(new Parcial()), "Esta es otra pregunta?", respuestaCorrecta3);

        Ronda ronda3 = new Ronda();
        ronda3.agregarPregunta(unaPregunta3);
        ronda3.agregarOpciones(opciones3);

        //---------------------------------//

        Kashoot kashoot = new Kashoot();
        kashoot.agregarRonda(ronda1);
        kashoot.agregarRonda(ronda2);
        kashoot.agregarRonda(ronda3);
        return kashoot;
    }

}



