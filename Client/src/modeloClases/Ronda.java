package modeloClases;

import java.util.ArrayList;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase que referencia a una Ronda donde se enfrenataran entrenadores. Posee sus respectivos atributos y metodos.
 */
public class Ronda {
    
    private Batalla batalla = new Batalla();

    /**
     * Constructor por defecto.
     */
    public Ronda() {
        super();
    }

    /**
     * Metodo que inicia una Ronda donde enfrenta a todos los entrenadores, de a pares, obteniendo como resultado al ganador y un reporte del enfrentamiento.<br>
     * <b>Pre:</b> La listaEntrenadores y listaResultados debe ser distinta de null.<br>
     * <b>Post:</b> Se enfrentan todos los entrenadores en grupos pares. Se obtiene el ganador.<br>
     * @param listaEntrenadores  de tipo ArrayList de Entrenador, cuenta con todos los entrenadores listos a ser enfrentados.
     * @param listaResultados  de tipo ArrayList de Reporte, cuenta con la informacion del enfrentamiento.
     * @return ganador devuelve un ArrayList de Entrenador con los ganadores de la respectiva Ronda.
     */
    public ArrayList<Entrenador> inicia(ArrayList<Entrenador> listaEntrenadores, ArrayList<Reporte> listaResultados){ 
        ArrayList<Entrenador> ganadores = new ArrayList<>();
        for(int i=0 ; i < listaEntrenadores.size() ; i+=2){
            ganadores.add(batalla.enfrentamiento(listaEntrenadores.get(i),listaEntrenadores.get(i+1),listaResultados));
            
        }
        return ganadores;
    }
}
