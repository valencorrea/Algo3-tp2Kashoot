package edu.fiuba.algo3.modelo;

public class Exclusividad {

    public void determinarPuntaje(Jugador unJugador, Jugador otroJugador, int cantExclusividades) {
        int unResultado = unJugador.getPuntajeRonda();
        int otroResultado = otroJugador.getPuntajeRonda();

        if(unResultado == otroResultado){
            unJugador.actualizarPuntajeObtenido(0);
            otroJugador.actualizarPuntajeObtenido(0);
        }else if(unResultado > otroResultado){
            unJugador.actualizarPuntajeObtenido(2 * cantExclusividades * unResultado);
            otroJugador.actualizarPuntajeObtenido(0);
        }else{
            unJugador.actualizarPuntajeObtenido(0);
            otroJugador.actualizarPuntajeObtenido(2 * cantExclusividades * otroResultado);
        }
    }
}
