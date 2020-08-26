package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.Kashoot;
import edu.fiuba.algo3.vista.contenedores.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    private CheckBox unaCheckbox;
    private CheckBox otraCheckbox;
    private Label errorNombreVacio;
    private Label errorCheckbox;
    private Kashoot kashoot;
    private Stage stage;
    private Scene proximaEscena;
    private TextField unNombre;
    private TextField otroNombre;
    private ContenedorPreguntas contenedorPreguntas;


    public BotonJugarEventHandler(Stage stage, Scene proximaEscena, ContenedorPreguntas contenedorPreguntas, TextField unTexto, TextField otroTexto, Label errorNombreVacio, CheckBox unaCheckbox, CheckBox otraCheckbox, Label errorCheckbox, Kashoot kashoot) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.contenedorPreguntas = contenedorPreguntas;
        this.unNombre = unTexto;
        this.otroNombre = otroTexto;
        this.errorNombreVacio = errorNombreVacio;
        this.errorCheckbox = errorCheckbox;
        this.unaCheckbox = unaCheckbox;
        this.otraCheckbox = otraCheckbox;
        this.kashoot = kashoot;
    }

    public boolean nombresSonValidos(){
        boolean estado = true;
        if(unNombre.getText().trim().equals("")){
            imprimirError(errorNombreVacio, "No se pueden tener nombres vacios, por favor vuelva a intentar");
            estado = false;
        }
        else if(otroNombre.getText().trim().equals("")){
            imprimirError(errorNombreVacio, "No se pueden tener nombres vacios, por favor vuelva a intentar");
            estado = false;
        }else{
            kashoot.setNombreJugadores(unNombre.getText(),otroNombre.getText());

        }
        return estado;
    }

    private boolean checkboxValidas() {
        if(!unaCheckbox.isSelected() || !otraCheckbox.isSelected()){
            imprimirError(errorCheckbox, "Para poder jugar debe aceptar los terminos y condiciones.");
            return false;
        }
        return true;
    }

    private void imprimirError(Label unLabel, String unMensajeDeError) {
        unLabel.setText(unMensajeDeError);
        unLabel.setAlignment(Pos.CENTER_LEFT);
        unLabel.setTextFill(Color.DARKRED);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(!this.nombresSonValidos()){
            errorCheckbox.setText(" ");
        }
        if(!this.checkboxValidas()){
            errorNombreVacio.setText(" ");
        }
        if(this.nombresSonValidos() && this.checkboxValidas()){
            this.contenedorPreguntas.actualizar();
            stage.setScene(proximaEscena);
            stage.setFullScreenExitHint("");
            stage.setFullScreen(true);
        }
    }

}
