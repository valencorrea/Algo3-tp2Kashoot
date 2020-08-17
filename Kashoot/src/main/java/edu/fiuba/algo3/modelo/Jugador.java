package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicadores.MultiplicadorX2;
import edu.fiuba.algo3.modelo.multiplicadores.MultiplicadorX3;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private int puntajeAcumulado = 0;
    private ArrayList<Multiplicador> multiplicadores= new ArrayList<Multiplicador>();
    private ArrayList<Exclusividad> exclusividades = new ArrayList<Exclusividad>();
    private int puntajeObtenidoEnRonda = 0;

    public Jugador(String unNombre){

        this.nombre = unNombre;
        this.inicializarMultiplicadores();
        inicializarExclusividades();
    }

    private void inicializarExclusividades() {
        this.exclusividades.add(new Exclusividad());
        this.exclusividades.add(new Exclusividad());
    }

    private void inicializarMultiplicadores() {

        this.multiplicadores.add(new MultiplicadorX2());
        this.multiplicadores.add(new MultiplicadorX3());

    }
//ver como quedaria mandar el la respuesta su multiplicador.
    // no tener una referencia al multiplicador actual sino ver tener la el vector solo
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

    //NUNCA SE DA EL CASO DE QUE EL JUGADOR ELIJA MULTIPLICAR CUANDO NO ESTE YA QUE NO VA A ESTAR EN LA VISTA.
    //UNA VEZ QUE LO USA DESAPARECE DEL JUEGO
    public void multiplicarX2(Respuesta unaRespuesta) {

        MultiplicadorX2 multiplicador = new MultiplicadorX2();
        this.modificarMultiplicador(unaRespuesta, multiplicador);
        return;

    }

    public void multiplicarX3(Respuesta unaRespuesta) {

        MultiplicadorX3 multiplicador = new MultiplicadorX3();
        this.modificarMultiplicador(unaRespuesta, multiplicador);
        return;
    }

    public void modificarMultiplicador(Respuesta unaRespuesta, Multiplicador unMultiplicador){

        multiplicadores.remove(unMultiplicador);
        unaRespuesta.modificarMultiplicador(unMultiplicador);
        return;
    }

    public int usarExclusividad() {
        this.exclusividades.remove(exclusividades.size()-1);
        return 1;
    }

    public int getPuntajeRonda() {
        return this.puntajeObtenidoEnRonda;
    }

    public void asignarPuntajeRonda(int puntajeAcumulado) {
        this.puntajeAcumulado += this.puntajeObtenidoEnRonda;
    }
}
