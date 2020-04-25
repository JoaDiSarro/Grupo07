package modeloClases;

import java.util.ArrayList;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 */
public class Torneo {
    
    private String nombre;
    private ArrayList<Entrenador> listaEntrenadores;
    private Ronda ronda;
    private ArrayList<Reporte> reporteResultados;
    
    public Torneo(String nombre) {
        this.nombre = nombre;
        listaEntrenadores = new ArrayList<>();
        reporteResultados = new ArrayList<>();
    }
    
    public void agregaEntrenador(Entrenador entrenador){
        this.listaEntrenadores.add(entrenador);
    }
    
    public ArrayList<Entrenador> comienzaRonda(ArrayList<Entrenador> entrenadores){ //Entra con el parametro reporteResultados y lo pasa a inicia
        return ronda.inicia(entrenadores);
    }
    
    public Entrenador comienzaTorneo() {
        ArrayList<Entrenador> listaCompetidoresActual = listaEntrenadores;
        while (listaCompetidoresActual.size() != 1) {
            listaCompetidoresActual = comienzaRonda(listaCompetidoresActual); //ComienzaRonda deberia llevar el parametro reporteResultados
        }
        return listaCompetidoresActual.get(0);
    }
}
