package modeloClases;

import java.util.ArrayList;

public class Torneo {
    
    private String nombre;
    private ArrayList<Entrenador> listaEntrenadores;
    private Ronda ronda;
    
    public Torneo(String nombre) {
        this.nombre = nombre;
        listaEntrenadores = new ArrayList<>();
    }
    
    public void agregaEntrenador(Entrenador entrenador){
        this.listaEntrenadores.add(entrenador);
    }
    
    public ArrayList<Entrenador> comienzaRonda(ArrayList<Entrenador> entrenadores){
        return ronda.inicia(entrenadores);
    }
    
    public Entrenador comienzaTorneo() {
        ArrayList<Entrenador> aux = listaEntrenadores;
        while (aux.size() != 1) {
            aux = comienzaRonda(aux);
        }
        return aux.get(0);
    }
}
