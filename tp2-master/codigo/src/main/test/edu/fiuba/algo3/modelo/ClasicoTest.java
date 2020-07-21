package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClasicoTest {
    @Test
    public void calcularPuntosConRespuestaCorrectaDevuelveElPuntajeCorrecto(){
        Respuesta respuestaCorrecta = new Respuesta(new RespuestaCorrecta(), "soy correcta");
        Clasico clasico = new Clasico();
        int resultado = clasico.calcularPuntaje(respuestaCorrecta);

        assertEquals(resultado,10);
    }
    @Test
    public void calcularPuntosConRespuestIncorrectaDevuelveElPuntajeCorrecto(){
        Respuesta respuestaIncorrecta = new Respuesta(new RespuestaIncorrecta(), "soy incorrecta ");
        Clasico clasico = new Clasico();
        int resultado = clasico.calcularPuntaje(respuestaIncorrecta);

        assertEquals(resultado,0);
    }

}