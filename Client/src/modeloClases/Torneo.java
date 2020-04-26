package modeloClases;

import java.util.ArrayList;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase que representa un Torneo que tiene una unica instancia en toda la aplicacion, con sus respectivos atributos y metodos.<br>
 * Solo pueden competir 16 entrenadores, con sus respectivos Pokemones.<br>
 */
public class Torneo {
    
    private ArrayList<Entrenador> listaEntrenadores;
    private Ronda ronda;
    private ArrayList<Reporte> reporteResultados;
    private static Torneo instance;

    /**
     * Constructor sin parametros
     */
    private Torneo() {
        listaEntrenadores = new ArrayList<>();
        reporteResultados = new ArrayList<>();
    }

    /**
     * Metodo que devuelve la unica instancia existe del torneo en el sistema.
     * <b>Post:</b> Retorna la instancia del torneo.
     * @return : instancia unica del Torneo
     */
    public Torneo getInstance(){
        if(instance == null)
            instance = new Torneo();
        return instance;
    }

    /**
     * Metodo el cual se encarga de agregar entrenadores a la Lista de Entrenadores del Torneo
     * <b>Pre:</b> El entrenador debe ser distinto de null.
     * <b>Post:</b> Se agrega un entrenador a la lista de Entrenadores.
     * @param entrenador de tipo Entrenador: sera el nuevo entrenador que participara en el Torneo.
     */
    public void agregaEntrenador(Entrenador entrenador){
        this.listaEntrenadores.add(entrenador);
    }

    /**
     * Metodo el cual comienza una ronda dentro del Torneo.<br>
     * Se inicia la ronda, pasando los datos de los entrenadores y obteniendo el reporte de los resultados.
     * <b>Pre:</b> La lista de entrenadores debe ser distinta de null.
     * <b>Post:</b> Se ejecuta la ronda y se obtienen los Entrenadores ganadores de la misma.
     * @param entrenadores de tipo ArrayList Entrenador: tiene los datos de todos los entrenadores que participan en la Ronda. 
     * @return : devuelve un ArrayList de Entrenadores con los ganadores de esa Ronda.
     */
    public ArrayList<Entrenador> comienzaRonda(ArrayList<Entrenador> entrenadores){
        return ronda.inicia(entrenadores,reporteResultados);
    }

    /**
     * Metodo el cual muestra todos los entrenadores que participaron en el Torneo
     * <b>Post:</b> Se listan los entrenadores por consola.
     */
    public void muestraEntrenadores(){
        System.out.println("\nEntrenadores a Competir:\n");
        for(Entrenador element : listaEntrenadores){
            System.out.println(element);
        }
    }

    /**
     * Metodo el cual muestra todos los datos de cada Reporte perteneciente a cada Batalla del Torneo.
     * <b>Post:</b> Se listan los reportes de cada batalla por consola.
     */
    public void muestraReporte(){
        System.out.println("\nEnfrentamientos:\n");
        for(Reporte element : reporteResultados){
            System.out.println(element);
        }
    }

    /**
     * Metodo que se encarga de ejecutar el Torneo de Principo a Fin.<br>
     * Comienza el torneo, se ejecutan todas las rondas con sus respectivas batallas, se define un ganador del Torneo.<br>
     * Se muestra el detalle de cada batalla, y luego al ganador Final.<br>
     * Luego el torneo finaliza.<br>
     * <b>Pre:</b> La listaEntrenadores distinta de null. 
     * <b>Post:</b> El Torneo se ejecuta de principio a fin.
     */
    public void ejecutaTorneo() {
        Entrenador ganador;
        System.out.println("\n------COMIENZA EL TORNEO------\n");
        ArrayList<Entrenador> listaCompetidoresActual = listaEntrenadores;
        while (listaCompetidoresActual.size() != 1) {
            listaCompetidoresActual = comienzaRonda(listaCompetidoresActual);
        }
        ganador = listaCompetidoresActual.get(0);
        muestraReporte();
        System.out.println("\nEl Ganador del torneo es: "+ganador);     
        System.out.println("\n------FINALIZA EL TORNEO------\n");
    }
}
