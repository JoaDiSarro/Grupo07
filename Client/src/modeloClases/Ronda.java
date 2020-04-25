package modeloClases;

import java.util.ArrayList;

public class Ronda {
    
    private Batalla batalla;
    
    public Ronda() {
        super();
    }
    
    
    public ArrayList<Entrenador> inicia(ArrayList<Entrenador> listaEntrenadores){
        ArrayList<Entrenador> ganadores = new ArrayList<>();
        for(int i=0 ; i < listaEntrenadores.size() ; i+=2){
            ganadores.add(batalla.enfrentamiento(listaEntrenadores.get(i),listaEntrenadores.get(i+1)));
        }
        return ganadores;
    }
}
