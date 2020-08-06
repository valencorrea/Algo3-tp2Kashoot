package edu.fiuba.algo3.modelo;

public class MultiplicadorX1 extends Multiplicador {

    public MultiplicadorX1(){
        this.valorAMultiplicar = 1;
    }
    public void usar(){
        this.estado = new NoUsado();

    }
}
