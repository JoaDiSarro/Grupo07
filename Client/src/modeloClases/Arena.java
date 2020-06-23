package modeloClases;

import modeloClases.state.EnfrentamientoState;
import modeloClases.state.State;

import java.util.Observable;

import modeloClases.state.PreliminarState;

public class Arena extends Observable {
    private String nombre;
    private boolean batallaEnCurso = false;
    private State estado;
    
    public Arena(String nombre) {
        this.nombre = nombre;
    }

    public synchronized Entrenador inicia(ModeloBatalla modelo){
        while(batallaEnCurso){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.batallaEnCurso = true;
        estado = new PreliminarState(this);
        estado.ejecutar(modelo);
        while (estado != null) {    // Espera hasta que el estado de la arena sea null (Batalla finalizada)
        }
        notifyAll();
        return modelo.getGanador();
    }
    
    
    public synchronized void termina(){
        //mientras que la arena no este ocupada, espero
        while(!batallaEnCurso){
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.batallaEnCurso = false;
        System.out.println("\nSaliendo A LA ARENA "+this.nombre);
        notifyAll();
    } 

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public void continua(ModeloBatalla modelo) {
        estado.ejecutar(modelo);
    }

    public String getNombre() {
        return nombre;
    }
    
    public void notificarEstado(String mensaje){
        setChanged();
        notifyObservers(mensaje);
    }
}
