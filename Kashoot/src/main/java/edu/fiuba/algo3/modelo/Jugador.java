package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Pregunta;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import edu.fiuba.algo3.modelo.multiplicadores.MultiplicadorX2;
import edu.fiuba.algo3.modelo.multiplicadores.MultiplicadorX3;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntajeAcumulado = 0;
    private MultiplicadorX2 multiplicadorX2;
    private MultiplicadorX3 multiplicadorX3;

    private ArrayList<Exclusividad> exclusividades = new ArrayList<Exclusividad>();
    private int puntajeObtenidoEnRonda = 0;

    public Jugador(){

        this.inicializarMultiplicadores();
        this.inicializarExclusividades();
    }

    private void inicializarExclusividades() {
        this.exclusividades.add(new Exclusividad());
        this.exclusividades.add(new Exclusividad());
    }

    private void inicializarMultiplicadores() {

        this.multiplicadorX2 = new MultiplicadorX2();
        this.multiplicadorX3 = new MultiplicadorX3();

    }

    public void responder(Pregunta unaPregunta, Respuesta unaRespuesta) {
        int puntaje = unaPregunta.calcularPuntaje(unaRespuesta);
        this.puntajeObtenidoEnRonda = unaRespuesta.multiplicar(puntaje);
    }

    public int getPuntajeAcumulado(){
        return this.puntajeAcumulado;
    }

    public void multiplicarX2(Respuesta unaRespuesta) {

        unaRespuesta.modificarMultiplicador(new MultiplicadorX2());
        this.multiplicadorX2 = null;
    }

    public void multiplicarX3(Respuesta unaRespuesta) {

        unaRespuesta.modificarMultiplicador(new MultiplicadorX3());
        this.multiplicadorX3 = null;
    }

    public void usarExclusividad() {
        this.exclusividades.remove(exclusividades.size()-1);
    }

    public int getPuntajeRonda() {
        return this.puntajeObtenidoEnRonda;
    }

    public void asignarPuntajeRonda() {
        this.puntajeAcumulado = this.puntajeAcumulado + puntajeObtenidoEnRonda;
    }

    public void actualizarPuntajeObtenido(int puntajeActualizado) {
        this.puntajeObtenidoEnRonda = puntajeActualizado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean tieneExclusividad() {
        return (!exclusividades.isEmpty());
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean tieneMultiplicadorX3(){
        return (this.multiplicadorX3 != null);
    }

    public boolean tieneMultiplicadorX2(){
        return (this.multiplicadorX2 != null);
    }
}
