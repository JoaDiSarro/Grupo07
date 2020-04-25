package modeloClases;

import java.util.ArrayList;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 */
public class Ronda {
    
    private Batalla batalla;
    
    public Ronda() {
        super();
    }
    
    
  //Se le agrega el parametro listaReportes y se lo pasa en enfrentamiento
    public ArrayList<Entrenador> inicia(ArrayList<Entrenador> listaEntrenadores){ 
        ArrayList<Entrenador> ganadores = new ArrayList<>();
        for(int i=0 ; i < listaEntrenadores.size() ; i+=2){
            ganadores.add(batalla.enfrentamiento(listaEntrenadores.get(i),listaEntrenadores.get(i+1)));
            
        }
        return ganadores;
    }
}
