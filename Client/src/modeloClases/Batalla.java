package modeloClases;

import exceptions.SinCartasDisponiblesException;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0 <br>
 *          Clase que representa una batalla en un torneo pokemon.<br>
 *          Se encarga de hacer batallar objetos de tipo Entrenador.
 */
public class Batalla extends Observable implements Runnable {

	private final int maxAtaques = 3;
	private Entrenador entrenadorA;
	private Entrenador entrenadorB;
	private Arena arena;

	/**
	 * Constructor de la clase Batalla<br>
	 * 
	 * @param entrenadorA de tipo Entrenador: Representa uno de los entrenadores que
	 *                    participa de la batalla.<br>
	 * @param entrenadorB de tipo Entrenador: Representa uno de los entrenadores que
	 *                    participa de la batalla.<br>
	 * @param arena       de tipo Arena: Representa la arena donde se llevará a cabo
	 *                    la batalla.<br>
	 */
	public Batalla(Entrenador entrenadorA, Entrenador entrenadorB, Arena arena) {
		this.entrenadorA = entrenadorA;
		this.entrenadorB = entrenadorB;
		this.arena = arena;
	}

	/**
	 * Método encargado de comenzar y terminar una batalla.<br>
	 * Sobreescribe el método run.<br>
	 */
	@Override
	public void run() {
		Entrenador ganador = arena.inicia(generaModeloBatalla());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		arena.termina();
		setChanged();
		notifyObservers(ganador);
	}

	/**
	 * Método encargado de generar un modelo de batalla utilizado por la arena para
	 * conocer a sus participantes.<br>
	 * 
	 * @return modelo de tipo ModeloBatalla: Representa el modelo que utilizará la
	 *         arena.<br>
	 */
	private ModeloBatalla generaModeloBatalla() {
		ModeloBatalla modelo = new ModeloBatalla(entrenadorA, entrenadorA.eligePokemon(),
				entrenadorA.decideUtilizarCarta(), entrenadorB, entrenadorB.eligePokemon(),
				entrenadorB.decideUtilizarCarta(), maxAtaques);
		setChanged();
		notifyObservers(modelo);
		return modelo;
	}
}
