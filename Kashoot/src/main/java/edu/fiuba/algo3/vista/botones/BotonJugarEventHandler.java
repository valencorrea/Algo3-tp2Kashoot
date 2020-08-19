package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.vista.contenedores.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private Kashoot kashoot;
    private Stage stage;
    private Scene proximaEscena;
    private TextField unNombre;
    private TextField otroNombre;
    private Label mensajeError;
    private ContenedorPreguntas contenedorPreguntas;


    public BotonJugarEventHandler(Stage stage, Scene proximaEscena, ContenedorPreguntas contenedorPreguntas, TextField unTexto, TextField otroTexto, Label mensajeDeError,Kashoot kashoot) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.contenedorPreguntas = contenedorPreguntas;
        this.unNombre = unTexto;
        this.otroNombre = otroTexto;
        this.mensajeError = mensajeDeError;
        this.kashoot = kashoot;
    }

    public boolean nombresSonValidos(){
        boolean estado = true;
        if(unNombre.getText().trim().equals("")){
            mensajeError.setText("No se puede tener un nombre vacio, por favor vuelva a intentar");
            mensajeError.setAlignment(Pos.CENTER_LEFT);
            mensajeError.setTextFill(Color.DARKRED);
            estado = false;
        }
        else if(otroNombre.getText().trim().equals("")){
            mensajeError.setText("No se puede tener un nombre vacio, por favor vuelva a intentar");
            mensajeError.setAlignment(Pos.CENTER_RIGHT);
            mensajeError.setTextFill(Color.DARKRED);
            estado = false;
        }else{
            kashoot.setNombreJugadores(unNombre.getText(),otroNombre.getText());

        }
        return estado;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.nombresSonValidos()) {
            this.contenedorPreguntas.actualizar();
            stage.setScene(proximaEscena);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
        }
    }

}
