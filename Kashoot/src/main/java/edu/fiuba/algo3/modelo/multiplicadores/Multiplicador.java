package edu.fiuba.algo3.modelo.multiplicadores;

public abstract class Multiplicador {

    protected int valorAMultiplicar;

    public int multiplicar(int puntaje){

            return puntaje*this.valorAMultiplicar;
    }

}
