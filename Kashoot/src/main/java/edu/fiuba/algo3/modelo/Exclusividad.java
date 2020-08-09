package edu.fiuba.algo3.modelo;

public class Exclusividad {

    public void determinarPuntaje(Jugador unJugador, Jugador otroJugador, int unResultado, int otroResultado, int cantExclusividades) {
        if(unResultado == otroResultado){
            unJugador.asignarPuntajeRonda(0);
            otroJugador.asignarPuntajeRonda(0);
            return;
        }

        if(unResultado > otroResultado){
            unJugador.asignarPuntajeRonda(2 * cantExclusividades * unResultado);
            otroJugador.asignarPuntajeRonda(0);
            return;
        }
        unJugador.asignarPuntajeRonda(0);
        otroJugador.asignarPuntajeRonda(2 * cantExclusividades * otroResultado);
    }
}
