package modeloClases.state;

import modeloClases.Arena;
import modeloClases.ModeloBatalla;

/**
 * @author Di Sarro,Joaquina.<br>
 *         Clase que representa el estado de definici�n de una arena en la cual
 *         se llevan a cabo combates pok�mon .<br>
 */
public class DefinicionState implements State {
	private Arena arena;

	/**
	 * Constructor de la clase DefinicionState.<br>
	 * 
	 * @param arena de tipo Arena: Representa la arena que cambiar� de estado.<br>
	 */
	public DefinicionState(Arena arena) {
		this.arena = arena;
	}

	/**
	 * M�todo encargado de cambiar el estado de la arena.<br>
	 * 
	 * @param modelo de tipo ModeloBatalla: Representa el estado de los
	 *               participantes en la arena.<br>
	 */
	@Override
	public void ejecutar(ModeloBatalla modelo) {
		arena.notificarEstado("\n La arena " + arena.getNombre() + " se encuentra ahora en estado de definici�n.");
		arena.setEstado(new LimpiezaState(arena));
		arena.continua(modelo);
	}

	@Override
	public String toString() {
		return " de definici�n.";
	}

}
