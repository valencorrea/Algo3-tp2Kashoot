package edu.fiuba.algo3.modelo;

/**
     * JavaFX App
     *
     */

    public class Juego {

        public static void main(String args[]) {

            Kashoot kashoot = new Kashoot();
            kashoot.iniciar();
        }
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


