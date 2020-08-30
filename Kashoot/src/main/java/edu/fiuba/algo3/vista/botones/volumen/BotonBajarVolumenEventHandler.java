package edu.fiuba.algo3.vista.botones.volumen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class BotonBajarVolumenEventHandler implements EventHandler<ActionEvent> {

    private double volumen;
    private MediaPlayer musica;

    public BotonBajarVolumenEventHandler(MediaPlayer musica, double volumen) {
        this.musica = musica;
        this.volumen = volumen;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.musica.setVolume((this.volumen = this.volumen - 0.05));
    }
}