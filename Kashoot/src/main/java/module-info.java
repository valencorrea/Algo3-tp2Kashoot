module edu.fiuba.algo3.modelo {
    requires javafx.controls;
    requires javafx.media;
    requires java.desktop;
    exports edu.fiuba.algo3.vista;
    exports edu.fiuba.algo3.modelo  to javafx.graphics;
}