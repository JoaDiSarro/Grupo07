package modeloClases;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import modeloClases.persistencia.PersistenciaModelo;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0 <br>
 *          Clase que referencia a una Ronda donde se enfrenataran entrenadores.
 *          Posee sus respectivos atributos y metodos.
 */
public class Ronda extends Observable implements Observer {

	private ArrayList<Observable> observables = new ArrayList<>();
	private ArrayList<Entrenador> ganadoresRonda = new ArrayList<>();
	private int cantBatallasPendientes = 0;
	private PersistenciaModelo<ArrayList<Entrenador>> persistidor;

	/**
	 * Constructor por defecto.
	 */
	public Ronda(PersistenciaModelo<ArrayList<Entrenador>> persistidor) {
		this.persistidor = persistidor;
	}

	/**
	 * Metodo que inicia una Ronda donde enfrenta a todos los entrenadores, de a
	 * pares, obteniendo como resultado al ganador y un reporte del
	 * enfrentamiento.<br>
	 * <b>Pre:</b> La listaEntrenadores y listaResultados debe ser distinta de
	 * null.<br>
	 * <b>Post:</b> Se enfrentan todos los entrenadores en grupos pares. Se obtiene
	 * el ganador.<br>
	 * 
	 * @param listaEntrenadores de tipo ArrayList de Entrenador, cuenta con todos
	 *                          los entrenadores listos a ser enfrentados.
	 * @param listaResultados   de tipo ArrayList de Reporte, cuenta con la
	 *                          informacion del enfrentamiento.
	 */
	public void inicia(ArrayList<Entrenador> listaEntrenadores, ArrayList<Reporte> listaResultados,
			ArrayList<Arena> arenas) {
		this.cantBatallasPendientes = listaEntrenadores.size() / 2;
		for (int i = 0; i < listaEntrenadores.size(); i += 2) {
			Random random = new Random();
			Batalla batalla = new Batalla(listaEntrenadores.get(i), listaEntrenadores.get(i + 1),
					arenas.get(random.nextInt(arenas.size())));
			batalla.addObserver(this);
			observables.add(batalla);
			Thread thread = new Thread(batalla);
			thread.start();
		}
	}

	@Override
	public synchronized void update(Observable observable, Object object) {
		if (!observables.contains(observable))
			throw new IllegalArgumentException();

		if (object.getClass().getName().equalsIgnoreCase(ModeloBatalla.class.getName())) {
			setChanged();
			notifyObservers(object);
		} else {
			Entrenador ganadorBatalla = (Entrenador) object;
			String stringGanador = "\nPasa a la siguiente ronda: " + ganadorBatalla;
			setChanged();
			notifyObservers(stringGanador);
			// System.out.println("\nGANADOR DE LA BATALLA: " + ganadorBatalla);
			ganadoresRonda.add(ganadorBatalla);
			this.cantBatallasPendientes--;
			if (this.cantBatallasPendientes == 0) {
				persistidor.guardar(ganadoresRonda);
				String stringGanadores = "\nGANADORES DE LA RONDA:\n\n" + ganadoresRonda;
				setChanged();
				notifyObservers(stringGanadores);
				// System.out.println("\nGANADORES DE LA RONDA:\n" + ganadoresRonda);
				setChanged();
				notifyObservers(); // Notifica fin de ronda
			}
		}
		notifyAll();
	}
}
