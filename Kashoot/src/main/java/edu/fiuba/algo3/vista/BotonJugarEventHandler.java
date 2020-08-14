package edu.fiuba.algo3.vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    TextField unNombre;
    TextField otroNombre;
    Label mensajeError;

    public BotonJugarEventHandler(Stage stage, Scene proximaEscena, TextField unTexto, TextField otroTexto, Label mensajeDeError) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.unNombre = unTexto;
        this.otroNombre = otroTexto;
        this.mensajeError = mensajeDeError;
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
        }
        return estado;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(this.nombresSonValidos()) {
            stage.setScene(proximaEscena);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
        }
    }

}
