package edu.fiuba.algo3.modelo;

public abstract class Multiplicador {

    protected Estado estado = new NoUsado(); // esta bien esto?
    protected int valorAMultiplicar;

    public int multiplicar(int puntaje){

            if(this.estado.yaUsado()){
                return puntaje; // lanzar una excepcion al jugador(ya uso) ya que no corta el flujo del progama
            }
            this.usar();
            return puntaje*this.valorAMultiplicar;

    }

    public void usar(){
        this.estado = new Usado();
    }

}
