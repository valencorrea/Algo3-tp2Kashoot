package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
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

    public class Juego extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        double volumen = 0.2;
        MediaPlayer musica = agregarMusica(volumen);

        stage.setTitle("Kashoot");

        Kashoot kashoot = crearModelo();

        ContenedorFinalDelJuego contenedorFinalDeJuego = new ContenedorFinalDelJuego(stage, kashoot);
        Scene escenaFinalDeJuego = new Scene(contenedorFinalDeJuego, 640, 480);

        ContenedorPreguntas contenedorPreguntas = new ContenedorPreguntas(musica, volumen, stage, kashoot, escenaFinalDeJuego,contenedorFinalDeJuego);
        Scene escenaJuego = new Scene(contenedorPreguntas, 640, 480);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego, kashoot, contenedorPreguntas);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);
        stage.show();
    }

    private MediaPlayer agregarMusica(double volumen){
        Media mp3MusicFile = new Media(new File("Kashoot/resources/mipan.mp3").toURI().toString());

        MediaPlayer musica = new MediaPlayer(mp3MusicFile);
        musica.setAutoPlay(true);
        musica.setOnEndOfMedia(() -> musica.seek(Duration.ZERO));
        musica.setVolume(volumen);
        musica.play();

        return musica;
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

        Opcion opcionCorrecta11 = new Opcion("Verdadero");
        Opcion opcionIncorrecta11 = new Opcion("Falso");

        ArrayList <Opcion> opciones1 = new ArrayList<Opcion>();
        opciones1.add(opcionCorrecta11);
        opciones1.add(opcionIncorrecta11);

        Respuesta respuestaCorrecta1 = new Respuesta();
        respuestaCorrecta1.agregarOpcion(opcionCorrecta11);
        Pregunta unaPregunta1 = new Pregunta(new ModalidadSinOrden(new Clasico()), "¿El cielo es celeste?\nFormato clasico", respuestaCorrecta1);

        Ronda ronda1 = new Ronda();
        ronda1.agregarPregunta(unaPregunta1);
        ronda1.agregarOpciones(opciones1);
        //-------------------------------------------//

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
        Pregunta unaPregunta2 = new Pregunta(new ModalidadSinOrden(new Penalidad()), "¿Qué números son pares?\nFormato penalidad", respuestaCorrecta2);

        Ronda ronda2 = new Ronda();
        ronda2.agregarPregunta(unaPregunta2);
        ronda2.agregarOpciones(opciones2);
        //-------------------------------------------//
        Opcion opcionIncorrecta31 = new Opcion("Verdadero");
        Opcion opcionCorrecta31 = new Opcion("Falso");

        ArrayList <Opcion> opciones3 = new ArrayList<Opcion>();
        opciones3.add(opcionCorrecta31);
        opciones3.add(opcionIncorrecta31);

        Respuesta respuestaCorrecta3 = new Respuesta();
        respuestaCorrecta3.agregarOpcion(opcionCorrecta31);

        Pregunta unaPregunta3 = new Pregunta(new ModalidadSinOrden(new Clasico()), "¿Existe el patrón Poxi?\nFormato clasico", respuestaCorrecta3);

        Ronda ronda3 = new Ronda();
        ronda3.agregarPregunta(unaPregunta3);
        ronda3.agregarOpciones(opciones3);

        //-------------------------------------------//
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

        Pregunta unaPregunta4 = new Pregunta(new ModalidadOrdenada(), "Seleccionar los números de forma acendente \nFormato ordered choice", respuestaCorrecta4);

        Ronda ronda4 = new Ronda();
        ronda4.agregarPregunta(unaPregunta4);
        ronda4.agregarOpciones(opciones4);

        //-------------------------------------------//

        Opcion opcionCorrecta51 = new Opcion("Fiuba");
        Opcion opcionIncorrecta51 = new Opcion("Fmed");
        Opcion opcionIncorrecta52 = new Opcion("Sociales");
        Opcion opcionCorrecta52 = new Opcion(" Fiuba en\notro boton");
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
        Pregunta unaPregunta5 = new Pregunta(new ModalidadSinOrden(new Parcial()), "¿Cuál es la mejor facultad?\nFormato parcial", respuestaCorrecta5);

        Ronda ronda5 = new Ronda();
        ronda5.agregarPregunta(unaPregunta5);
        ronda5.agregarOpciones(opciones5);

        //-------------------------------------------//

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

        Pregunta unaPregunta6 = new Pregunta(new ModalidadOrdenada(), "Seleccionar las letras alfabeticamente\nFormato ordered choice", respuestaCorrecta6);

        Ronda ronda6 = new Ronda();
        ronda6.agregarPregunta(unaPregunta6);
        ronda6.agregarOpciones(opciones6);

        //-------------------------------------------//

        Opcion opcionCorrecta71 = new Opcion("Verdadero");
        Opcion opcionIncorrecta71 = new Opcion("Falso");

        ArrayList <Opcion> opciones7 = new ArrayList<Opcion>();
        opciones7.add(opcionCorrecta71);
        opciones7.add(opcionIncorrecta71);

        Respuesta respuestaCorrecta7 = new Respuesta();
        respuestaCorrecta7.agregarOpcion(opcionCorrecta71);

        Pregunta unaPregunta7 = new Pregunta(new ModalidadSinOrden(new Penalidad()), "¿Vamos a aprobar?\nFormato penalidad", respuestaCorrecta7);

        Ronda ronda7 = new Ronda();
        ronda7.agregarPregunta(unaPregunta7);
        ronda7.agregarOpciones(opciones7);

        //-------------------------------------------//

        Opcion opcionIncorrecta81 = new Opcion("Verdadero");
        Opcion opcionCorrecta81 = new Opcion("Falso");

        ArrayList <Opcion> opciones8 = new ArrayList<Opcion>();
        opciones8.add(opcionCorrecta81);
        opciones8.add(opcionIncorrecta81);

        Respuesta respuestaCorrecta8 = new Respuesta();
        respuestaCorrecta8.agregarOpcion(opcionCorrecta81);

        Pregunta unaPregunta8 = new Pregunta(new ModalidadSinOrden(new Penalidad()), "¿Los michis son malos?\nFormato penalidad", respuestaCorrecta8);

        Ronda ronda8 = new Ronda();
        ronda8.agregarPregunta(unaPregunta8);
        ronda8.agregarOpciones(opciones8);

        //-------------------------------------------//

        Opcion opcionCorrectaG1_91 = new Opcion("Celeste");
        Opcion opcionCorrectaG2_92 = new Opcion("Azul");
        Opcion opcionCorrectaG1_93 = new Opcion("Amarillo");
        Opcion opcionCorrectaG2_94 = new Opcion("Violeta");
        Opcion opcionCorrectaG1_95 = new Opcion("Naranja");

        ArrayList <Opcion> opciones9 = new ArrayList<Opcion>();
        opciones9.add(opcionCorrectaG1_91);
        opciones9.add(opcionCorrectaG2_92);
        opciones9.add(opcionCorrectaG1_93);
        opciones9.add(opcionCorrectaG2_94);
        opciones9.add(opcionCorrectaG1_95);

        Respuesta respuestaCorrectaDeGrupo1 = new Respuesta();
        respuestaCorrectaDeGrupo1.agregarOpcion(opcionCorrectaG1_91);
        respuestaCorrectaDeGrupo1.agregarOpcion(opcionCorrectaG1_93);
        respuestaCorrectaDeGrupo1.agregarOpcion(opcionCorrectaG1_95);

        Pregunta unaPregunta9 = new Pregunta(new ModalidadSinOrden(new GroupChoice()), "Selecciones solo los colores calidos\n\tFormato group choice", respuestaCorrectaDeGrupo1);

        Ronda ronda9 = new Ronda();
        ronda9.agregarPregunta(unaPregunta9);
        ronda9.agregarOpciones(opciones9);

        //-------------------------------------------//
        Opcion opcionCorrecta101 = new Opcion("Actualizar\n  maven");
        Opcion opcionCorrecta102 = new Opcion("Verificar\nmodulo");
        Opcion opcionCorrecta103 = new Opcion("Built-rebuilt");
        Opcion opcionCorrecta104 = new Opcion("   Clonar el \nrepo devuelta");


        ArrayList <Opcion> opciones10 = new ArrayList<Opcion>();
        opciones10.add(opcionCorrecta101);
        opciones10.add(opcionCorrecta102);
        opciones10.add(opcionCorrecta103);
        opciones10.add(opcionCorrecta104);

        Respuesta respuestaCorrecta10 = new Respuesta();
        respuestaCorrecta10.agregarOpcion(opcionCorrecta101);
        respuestaCorrecta10.agregarOpcion(opcionCorrecta102);
        respuestaCorrecta10.agregarOpcion(opcionCorrecta103);
        respuestaCorrecta10.agregarOpcion(opcionCorrecta104);

        Pregunta unaPregunta10 = new Pregunta(new ModalidadSinOrden(new Parcial()), "¿Qué hacemos cuando falla intelliJ?\nFormato parcial", respuestaCorrecta10);

        Ronda ronda10 = new Ronda();
        ronda10.agregarPregunta(unaPregunta10);
        ronda10.agregarOpciones(opciones10);

        //-------------------------------------------//

        kashoot.agregarRonda(ronda1);
        kashoot.agregarRonda(ronda2);
        kashoot.agregarRonda(ronda3);
        kashoot.agregarRonda(ronda4);
        kashoot.agregarRonda(ronda5);
        kashoot.agregarRonda(ronda6);
        kashoot.agregarRonda(ronda7);
        kashoot.agregarRonda(ronda8);
        kashoot.agregarRonda(ronda9);
        kashoot.agregarRonda(ronda10);

    }

}



