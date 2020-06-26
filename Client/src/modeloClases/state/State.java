package modeloClases.state;

import modeloClases.ModeloBatalla;

/**
 * @author Di Sarro,Joaquina.<br>
 *         Interfaz que contiene los métodos necesarios para cambiar el estado
 *         de las arenas durante el torneo.<br>
 */
public interface State {
	public void ejecutar(ModeloBatalla modelo);
}
