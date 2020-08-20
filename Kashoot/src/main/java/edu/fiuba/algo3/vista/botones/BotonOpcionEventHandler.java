package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.modelo.EntidadesPrincipales.Opcion;
import edu.fiuba.algo3.modelo.EntidadesPrincipales.Respuesta;
import javafx.event.*;

public class BotonOpcionEventHandler implements EventHandler<ActionEvent> {
    private Respuesta respuesta;
    private Opcion opcion;

    public BotonOpcionEventHandler(Respuesta unaRespuesta, Opcion unaOpcion){
        this.respuesta = unaRespuesta;
        this.opcion = unaOpcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.respuesta.agregarOpcion(this.opcion);
    }
}
