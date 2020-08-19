package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.formatos.*;
import edu.fiuba.algo3.modelo.modalidades.ModalidadOrdenada;
import edu.fiuba.algo3.modelo.modalidades.ModalidadSinOrden;
import edu.fiuba.algo3.vista.contenedores.ContenedorBienvenidos;
import edu.fiuba.algo3.vista.contenedores.ContenedorFinalDelJuego;
import edu.fiuba.algo3.vista.contenedores.ContenedorPreguntas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
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

        //agregarMusica();

        stage.setTitle("Kashoot");

        Kashoot kashoot = crearModelo();

        ContenedorFinalDelJuego contenedorFinalDeJuego = new ContenedorFinalDelJuego(stage, kashoot);
        Scene escenaFinalDeJuego = new Scene(contenedorFinalDeJuego, 640, 480);

        ContenedorPreguntas contenedorPreguntas = new ContenedorPreguntas(stage, kashoot, escenaFinalDeJuego,contenedorFinalDeJuego);
        Scene escenaJuego = new Scene(contenedorPreguntas, 640, 480);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego, kashoot);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);
        stage.show();
    }

    private void agregarMusica(){
        Media mp3MusicFile = new Media(new File("Kashoot/resources/mipan.mp3").toURI().toString());

        MediaPlayer musica = new MediaPlayer(mp3MusicFile);
        musica.setAutoPlay(true);
        musica.setOnEndOfMedia(() -> musica.seek(Duration.ZERO));
        musica.setVolume(0.1);
        musica.play();
    }

    private Kashoot crearModelo() {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Kashoot kashoot = new Kashoot();
        agregarRondas(kashoot);

        kashoot.agregarJugadores(jugador1, jugador2);

        return kashoot;
    }

    public void agregarRondas(Kashoot kashoot){
        //ArrayList <PreguntasYOpciones> preguntasYOpciones = leerArchivo("resources/archivo.txt");
        //multipleChoice; Clasico; de que color es el cielo?;rojo;mostaza;rosita;/celeste

        Opcion opcionCorrecta11 = new Opcion("Celeste");
        Opcion opcionIncorrecta11 = new Opcion("rojo");
        Opcion opcionIncorrecta12 = new Opcion("Rosita");
        Opcion opcionIncorrecta13 = new Opcion("Mostaza");


        ArrayList <Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcionCorrecta11);
        opciones1.add(opcionIncorrecta11);
        opciones1.add(opcionIncorrecta12);
        opciones1.add(opcionIncorrecta13);

        Respuesta respuestaCorrecta1 = new Respuesta();
        respuestaCorrecta1.agregarOpcion(opcionCorrecta11);
        Pregunta unaPregunta1 = new Pregunta(new ModalidadSinOrden(new Clasico()), "de que color es el cielo", respuestaCorrecta1);

        Ronda ronda1 = new Ronda();
        ronda1.agregarPregunta(unaPregunta1);
        ronda1.agregarOpciones(opciones1);
        //-------------------------------------------//
        //multipleChoice; Penalidad; que numeros son pares?;7;pi;e;/2

        Opcion opcionCorrecta21 = new Opcion("2");
        Opcion opcionIncorrecta21 = new Opcion("7");
        Opcion opcionIncorrecta22 = new Opcion("Pi");
        Opcion opcionCorrecta22 = new Opcion("4");
        Opcion opcionIncorrecta23 = new Opcion("e");


        ArrayList <Opcion> opciones2 = new ArrayList<Opcion>();
        opciones2.add(opcionCorrecta21);
        opciones2.add(opcionIncorrecta21);
        opciones2.add(opcionIncorrecta22);
        opciones2.add(opcionIncorrecta23);
        opciones2.add(opcionCorrecta22);


        Respuesta respuestaCorrecta2 = new Respuesta();
        respuestaCorrecta2.agregarOpcion(opcionCorrecta21);
        respuestaCorrecta2.agregarOpcion(opcionCorrecta22);
        Pregunta unaPregunta2 = new Pregunta(new ModalidadSinOrden(new Penalidad()), "¿Que numeros son pares? \n\t MultipleChoice", respuestaCorrecta2);

        Ronda ronda2 = new Ronda();
        ronda2.agregarPregunta(unaPregunta2);
        ronda2.agregarOpciones(opciones2);
        //-------------------------------------------//
        //verdaderoFalso; Clasico; c es terrible lenguaje?;/verdadero;falso

        Opcion opcionCorrecta31 = new Opcion("Verdadero");
        Opcion opcionIncorrecta31 = new Opcion("Falso");

        ArrayList <Opcion> opciones3 = new ArrayList<Opcion>();
        opciones3.add(opcionCorrecta31);
        opciones3.add(opcionIncorrecta31);

        Respuesta respuestaCorrecta3 = new Respuesta();
        respuestaCorrecta3.agregarOpcion(opcionCorrecta31);

        Pregunta unaPregunta3 = new Pregunta(new ModalidadSinOrden(new Clasico()), "C es un lenguaje terrible?\n\t Verdadero o falso", respuestaCorrecta3);

        Ronda ronda3 = new Ronda();
        ronda3.agregarPregunta(unaPregunta3);
        ronda3.agregarOpciones(opciones3);

        //-------------------------------------------//
        //orderedChoice; Ordenar los sig numeros;3;6;7;9
        Opcion opcionCorrecta41 = new Opcion("3");
        Opcion opcionCorrecta42 = new Opcion("6");
        Opcion opcionCorrecta43 = new Opcion("7");
        Opcion opcionCorrecta44 = new Opcion("9");


        ArrayList <Opcion> opciones4 = new ArrayList<Opcion>();

        opciones4.add(opcionCorrecta43);
        opciones4.add(opcionCorrecta41);
        opciones4.add(opcionCorrecta44);
        opciones4.add(opcionCorrecta42);

        Respuesta respuestaCorrecta4 = new Respuesta();
        respuestaCorrecta4.agregarOpcion(opcionCorrecta41);
        respuestaCorrecta4.agregarOpcion(opcionCorrecta42);
        respuestaCorrecta4.agregarOpcion(opcionCorrecta43);
        respuestaCorrecta4.agregarOpcion(opcionCorrecta44);

        Pregunta unaPregunta4 = new Pregunta(new ModalidadOrdenada(), "Seleccionar los numeros de forma acendente? \n\t OrderedChoice ", respuestaCorrecta4);

        Ronda ronda4 = new Ronda();
        ronda4.agregarPregunta(unaPregunta4);
        ronda4.agregarOpciones(opciones4);

        //-------------------------------------------//
        //multipleChoice; Parcial; cual es la mejor faq?;fmed;/fiuba;/fiuba en otro boton;sociales

        Opcion opcionCorrecta51 = new Opcion("Fiuba");
        Opcion opcionIncorrecta51 = new Opcion("Fmediciona");
        Opcion opcionIncorrecta52 = new Opcion("Sociales");
        Opcion opcionCorrecta52 = new Opcion("Fiuba en otro boton");
        Opcion opcionIncorrecta53 = new Opcion("Derecho");


        ArrayList <Opcion> opciones5 = new ArrayList<Opcion>();
        opciones5.add(opcionCorrecta51);
        opciones5.add(opcionIncorrecta51);
        opciones5.add(opcionIncorrecta52);
        opciones5.add(opcionCorrecta52);
        opciones5.add(opcionIncorrecta53);

        Respuesta respuestaCorrecta5 = new Respuesta();
        respuestaCorrecta5.agregarOpcion(opcionCorrecta51);
        respuestaCorrecta5.agregarOpcion(opcionCorrecta52);
        Pregunta unaPregunta5 = new Pregunta(new ModalidadSinOrden(new Parcial()), "Cual es la mejor facultad?", respuestaCorrecta5);

        Ronda ronda5 = new Ronda();
        ronda5.agregarPregunta(unaPregunta5);
        ronda5.agregarOpciones(opciones5);

        //-------------------------------------------//
        // orderedChoice; Ordenar las sigueintes letras alfabeticamente;M;S;V;A;R

        Opcion opcionCorrecta61 = new Opcion("A");
        Opcion opcionCorrecta62 = new Opcion("M");
        Opcion opcionCorrecta63 = new Opcion("R");
        Opcion opcionCorrecta64 = new Opcion("S");
        Opcion opcionCorrecta65 = new Opcion("V");

        ArrayList <Opcion> opciones6 = new ArrayList<Opcion>();

        opciones6.add(opcionCorrecta63);
        opciones6.add(opcionCorrecta65);
        opciones6.add(opcionCorrecta61);
        opciones6.add(opcionCorrecta64);
        opciones6.add(opcionCorrecta62);

        Respuesta respuestaCorrecta6 = new Respuesta();
        respuestaCorrecta6.agregarOpcion(opcionCorrecta61);
        respuestaCorrecta6.agregarOpcion(opcionCorrecta62);
        respuestaCorrecta6.agregarOpcion(opcionCorrecta63);
        respuestaCorrecta6.agregarOpcion(opcionCorrecta64);
        respuestaCorrecta6.agregarOpcion(opcionCorrecta65);

        Pregunta unaPregunta6 = new Pregunta(new ModalidadOrdenada(), "Seleccionar las letras alfabeticamente?", respuestaCorrecta6);

        Ronda ronda6 = new Ronda();
        ronda6.agregarPregunta(unaPregunta6);
        ronda6.agregarOpciones(opciones6);

        //-------------------------------------------//
        // verdaderoFalso; Penalidad; kashoot was sent to nil?;/verdadero;falso

        Opcion opcionCorrecta71 = new Opcion("Verdadero");
        Opcion opcionIncorrecta71 = new Opcion("Falso");

        ArrayList <Opcion> opciones7 = new ArrayList<Opcion>();
        opciones7.add(opcionCorrecta71);
        opciones7.add(opcionIncorrecta71);

        Respuesta respuestaCorrecta7 = new Respuesta();
        respuestaCorrecta7.agregarOpcion(opcionCorrecta31);

        Pregunta unaPregunta7 = new Pregunta(new ModalidadSinOrden(new Penalidad()), "Kashoot was sent to nil?", respuestaCorrecta7);

        Ronda ronda7 = new Ronda();
        ronda7.agregarPregunta(unaPregunta7);
        ronda7.agregarOpciones(opciones7);

        //-------------------------------------------//
        // verdaderoFalso; Penalidad; los michis son malos?; verdadero;/falso

        Opcion opcionCorrecta81 = new Opcion("Verdadero");
        Opcion opcionIncorrecta81 = new Opcion("Falso");

        ArrayList <Opcion> opciones8 = new ArrayList<Opcion>();
        opciones8.add(opcionCorrecta81);
        opciones8.add(opcionIncorrecta81);

        Respuesta respuestaCorrecta8 = new Respuesta();
        respuestaCorrecta8.agregarOpcion(opcionCorrecta81);

        Pregunta unaPregunta8 = new Pregunta(new ModalidadSinOrden(new Penalidad()), "Los michis son malos?", respuestaCorrecta8);

        Ronda ronda8 = new Ronda();
        ronda8.agregarPregunta(unaPregunta8);
        ronda8.agregarOpciones(opciones8);

        //-------------------------------------------//
      /*  kashoot.agregarRonda(ronda1);*/
        kashoot.agregarRonda(ronda2);
        /*kashoot.agregarRonda(ronda3);
        kashoot.agregarRonda(ronda4);
        kashoot.agregarRonda(ronda5);*/
        kashoot.agregarRonda(ronda6);
        kashoot.agregarRonda(ronda7);
        kashoot.agregarRonda(ronda8);
    }

}



