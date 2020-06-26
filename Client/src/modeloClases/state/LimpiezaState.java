package modeloClases.state;

import modeloClases.Arena;
import modeloClases.ModeloBatalla;

/**
 * @author Di Sarro,Joaquina.<br>
 *         Clase que representa el estado de limpieza de una arena en la cual se
 *         llevan a cabo combates pokémon .<br>
 */
public class LimpiezaState implements State {
	private Arena arena;

	/**
	 * Constructor de la clase LimpiezaState.<br>
	 * 
	 * @param arena de tipo Arena: Representa la arena que cambiará de estado.<br>
	 */
	public LimpiezaState(Arena arena) {
		this.arena = arena;
	}

	/**
	 * Método encargado de cambiar el estado de la arena.<br>
	 * 
	 * @param modelo de tipo ModeloBatalla: Representa el estado de los
	 *               participantes en la arena.<br>
	 */
	@Override
	public void ejecutar(ModeloBatalla modelo) {
		arena.notificarEstado("\n La arena " + arena.getNombre() + " se encuentra en estado de limpieza.");
		arena.setEstado(null);
	}

	@Override
	public String toString() {
		return " de limpieza.";
	}
}
