package vista.interfacesVista;

import java.util.Iterator;

import javax.swing.JButton;

import modeloClases.Pokemon;

/**
 * @author Frangolini, Luciano.<br>
 *         Clase que representa una interfaz utilizada por
 *         VistaAgregaEntrenador. Posee los métodos necesarios para su mínimo
 *         funcionamiento.<br>
 */

public interface IVistaAgregaEntrenador extends IVista {

	static final String AGREGAR_OTRO_POKEMON = "AgregarPokemon";
	static final String ACEPTAR = "Aceptar";

	/**
	 * Método que retorna el nombre del entrenador a instanciar.<br>
	 * 
	 * @return String que representa el nombre del entrenador.<br>
	 */

	public String getNombreEntrenador();

	/**
	 * Método que retorna la cantidad de cartas que poseerá el entrenador a
	 * instanciar.<br>
	 * 
	 * @return int que representa la cantidad de cartas del entrenador.
	 */

	public int getCantidadDeCartas();

	/**
	 * Método encargado de actualizar una lista de pokemones en una vista.<br>
	 * <b> Pre: </b> El parámetro debe ser distinto de null.<br>
	 * 
	 * @param it de tipo Iterator<Pokemon>: Representa un iterador de la lista de
	 *           pokemones.<br>
	 */

	public void actualizarListaPokemones(Iterator<Pokemon> it);
}
