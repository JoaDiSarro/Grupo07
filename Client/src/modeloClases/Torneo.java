package modeloClases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import interfaces.IAvisos;
import vista.interfacesVista.IVistaRegistroParticipantes;
import modeloClases.persistencia.PersistenciaModelo;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0 <br>
 *          Clase que representa un Torneo que tiene una unica instancia en toda
 *          la aplicacion, con sus respectivos atributos y metodos.<br>
 *          Solo pueden competir 16 entrenadores, con sus respectivos
 *          Pokemones.<br>
 */
public class Torneo extends Observable implements Observer {

	private ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
	private ArrayList<Entrenador> listaCompetidoresActual = new ArrayList<>();
	private ArrayList<Arena> listaArenas = new ArrayList<>();
	private ArrayList<Reporte> reporteResultados = new ArrayList<>();
	private static Torneo instance;
	private ArrayList<Observable> observables = new ArrayList<>();
	private String ganadorTorneo;
	private PersistenciaModelo<ArrayList<Entrenador>> persistidor = new PersistenciaModelo<>();

	/**
	 * Constructor sin parametros
	 */
	private Torneo() {
	}

	/**
	 * Metodo que devuelve la unica instancia existe del torneo en el sistema.<br>
	 * 
	 * @return : instancia unica del Torneo
	 */
	public static Torneo getInstance() {
		if (instance == null)
			instance = new Torneo();
		return instance;
	}

	public ArrayList<Entrenador> getListaEntrenadores() {
		return listaEntrenadores;
	}

	public ArrayList<Observable> getObservables() {
		return observables;
	}

	/**
	 * Metodo el cual se encarga de agregar entrenadores a la Lista de Entrenadores
	 * del Torneo.<br>
	 * <b>Pre:</b> El entrenador debe ser distinto de null.<br>
	 * <b>Post:</b> Se agrega un entrenador a la lista de Entrenadores.<br>
	 * 
	 * @param nombre     de tipo String: nombre del entrenador a crear<br>
	 * @param cantCartas de tipo Int: cantidad de cartas disponibles a usar por el
	 *                   entrenador<br>
	 */
	public void agregaEntrenador(String nombre, int cantCartas) {
		this.listaEntrenadores.add(new Entrenador(nombre, cantCartas));
		this.setChanged();
		this.notifyObservers(IVistaRegistroParticipantes.AGREGAR_ENTRENADOR);
	}

	/**
	 * M�todo encargado de agregar un entrenador a la lista de entrenadores.<br>
	 * 
	 * @param entrenador de tipo Entrenador: Representa el entrenador a agregar.<br>
	 */
	public void agregaEntrenador(Entrenador entrenador) {
		this.listaEntrenadores.add(entrenador);
		this.setChanged();
		this.notifyObservers(IVistaRegistroParticipantes.AGREGAR_ENTRENADOR);
	}

	/**
	 * M�todo encargado de agregar una arena al torneo.<br>
	 * 
	 * @param arena de tipo Arena: Representa la arena a agregar.<br>
	 */
	public void agregaArena(Arena arena) {
		this.listaArenas.add(arena);
		arena.addObserver(this);
		observables.add(arena);
	}

	/**
	 * Metodo el cual comienza una ronda dentro del Torneo.<br>
	 * Se inicia la ronda, pasando los datos de los entrenadores y obteniendo el
	 * reporte de los resultados.<br>
	 * <b>Pre:</b> La lista de entrenadores debe ser distinta de null.<br>
	 * <b>Post:</b> Se ejecuta la ronda y se obtienen los Entrenadores ganadores de
	 * la misma.<br>
	 * 
	 * @param entrenadores de tipo ArrayList Entrenador: tiene los datos de todos
	 *                     los entrenadores que participan en la Ronda.
	 */
	public void comienzaRonda(ArrayList<Entrenador> entrenadores) {
		Ronda ronda = new Ronda(persistidor);
		ronda.addObserver(this);
		this.observables.add(ronda);
		this.setChanged();
		this.notifyObservers(IAvisos.COMIENZA_RONDA);
		ronda.inicia(entrenadores, reporteResultados, listaArenas);
	}

	/**
	 * Metodo el cual muestra todos los entrenadores que participaron en el
	 * Torneo.<br>
	 * <b>Post:</b> Se listan los entrenadores por consola.
	 */
	public void muestraEntrenadores() {
		System.out.println("\nEntrenadores a Competir:\n");
		for (Entrenador element : listaEntrenadores) {
			System.out.println(element);
		}
	}

	/**
	 * Metodo el cual muestra todos los datos de cada Reporte perteneciente a cada
	 * Batalla del Torneo.<br>
	 * <b>Post:</b> Se listan los reportes de cada batalla por consola.<br>
	 */
	public void muestraReporte() {
		System.out.println("\nEnfrentamientos:\n");
		for (Reporte element : reporteResultados) {
			System.out.println(element);
		}
	}

	/**
	 * Metodo que se encarga de ejecutar el Torneo de Principo a Fin.<br>
	 * Comienza el torneo, se ejecutan todas las rondas con sus respectivas
	 * batallas, se define un ganador del Torneo.<br>
	 * Se muestra el detalle de cada batalla, y luego al ganador Final.<br>
	 * Luego el torneo finaliza.<br>
	 * <b>Pre:</b> La listaEntrenadores distinta de null. <b>Post:</b> El Torneo se
	 * ejecuta de principio a fin.
	 */
	public void ejecutaTorneo() {
		persistidor.guardar(listaEntrenadores);
		Entrenador ganador;
		this.setChanged();
		this.notifyObservers(IAvisos.COMIENZA_TORNEO);
		// System.out.println("\n------COMIENZA EL TORNEO------\n");
		listaCompetidoresActual = listaEntrenadores;
		comienzaRonda(listaCompetidoresActual);
	}

	@Override
	public synchronized void update(Observable observable, Object object) {
		if (!this.observables.contains(observable))
			throw new IllegalArgumentException();

		if (observable.getClass().getName().equalsIgnoreCase(Arena.class.getName())) {
			setChanged();
			notifyObservers(object);
		} else if (object != null && object.getClass().getName().equalsIgnoreCase(ModeloBatalla.class.getName())) {
			ModeloBatalla modelo = (ModeloBatalla) object;
			this.setChanged();
			this.notifyObservers(modelo.toString());
		} else if (object != null && object.getClass().getName().equalsIgnoreCase(String.class.getName())) {
			String resultado = (String) object;
			this.setChanged();
			this.notifyObservers(resultado.toString());
		} else {
			manejaComportamientoTorneo(observable);
		}
		notifyAll();
	}

	/**
	 * M�todo encargado de comenzar cada ronda del torneo e ir registrando su
	 * desarrollo.<br>
	 * 
	 * @param observable de tipo Observable: Representa la ronda que debe ser
	 *                   descartada del torneo, ya que sus datos quedaron
	 *                   registrados y no tiene m�s uso.<br>
	 */
	private void manejaComportamientoTorneo(Observable observable) {
		listaCompetidoresActual = persistidor.leerDatos();
		if (listaCompetidoresActual.size() != 1) {
			this.setChanged();
			this.notifyObservers(IVistaRegistroParticipantes.FIN_RONDA);
			comienzaRonda(listaCompetidoresActual);
		} else {
			this.ganadorTorneo = listaCompetidoresActual.get(0).toString();
			this.setChanged();
			this.notifyObservers(IVistaRegistroParticipantes.FIN_TORNEO);
			this.setChanged();
			this.notifyObservers(
					"\n\n-GANADOR DEL TORNEO:  " + listaCompetidoresActual.get(0) + "\n-FELICITACIONES!\n");
			this.setChanged();
			this.notifyObservers("\n\t\t------FINALIZA EL TORNEO------\n");
			// this.muestraReporte();
			// System.out.println("GANADOR FINAL: " + listaCompetidoresActual.get(0) );
			// System.out.println("\n------FINALIZA EL TORNEO------\n");
		}
		this.observables.remove(observable);
	}

	public String getGanadorTorneo() {
		return ganadorTorneo;
	}

}
