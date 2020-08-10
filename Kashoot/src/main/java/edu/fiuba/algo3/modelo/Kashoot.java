package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.vista.*;
import javafx.application.Application;

import javax.swing.*;

public class Kashoot  {

    private int tamanio = 20;
    ModeloObservable modelo;

    public void iniciar() {

        inicializarModelo();

        //completarModelo();

        crearVentana();
    }

    private void crearVentana() {

        JFrame ventana = new Ventana(tamanio, modelo);

        ventana.setSize(500, 400);
        ventana.setLocation(516, 0);
        ventana.setVisible(true);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void inicializarModelo() {

        modelo = new ModeloObservable();
    }
}
