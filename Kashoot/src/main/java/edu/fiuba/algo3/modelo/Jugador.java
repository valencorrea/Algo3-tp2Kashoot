package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicadores.MultiplicadorX1;
import edu.fiuba.algo3.modelo.multiplicadores.MultiplicadorX2;
import edu.fiuba.algo3.modelo.multiplicadores.MultiplicadorX3;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntajeAcumulado = 0;
    private Multiplicador multiplicadorX2;
    private Multiplicador multiplicadorX3;

    private ArrayList<Exclusividad> exclusividades = new ArrayList<Exclusividad>();
    private int puntajeObtenidoEnRonda = 0;

    public Jugador(){

        this.inicializarMultiplicadores();
        inicializarExclusividades();
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
        if (unaPregunta.puedeMultiplicar()) {
            puntaje = unaRespuesta.multiplicar(puntaje);
        }
        this.puntajeObtenidoEnRonda = puntaje;
    }

    public int getPuntajeAcumulado(){
        return this.puntajeAcumulado;
    }

    public void multiplicarX2(Respuesta unaRespuesta) {
        unaRespuesta.modificarMultiplicador(this.multiplicadorX2);
        this.multiplicadorX2 = desabilitarMultiplicador();
    }

    public void multiplicarX3(Respuesta unaRespuesta) {

        unaRespuesta.modificarMultiplicador(this.multiplicadorX3);
        this.multiplicadorX3 = desabilitarMultiplicador();
    }

    public int usarExclusividad() {
        this.exclusividades.remove(exclusividades.size()-1);
        return 1;
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

    private Multiplicador desabilitarMultiplicador(){
        return (new MultiplicadorX1());
    }

}
