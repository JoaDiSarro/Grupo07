package vista.interfacesVista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

/**
 * @author Frangolini, Luciano.<br>
 *         Clase que representa una interfaz utilizada por VistaAgregaPokemon.
 *         Posee los métodos necesarios para su mínimo funcionamiento.<br>
 */
public interface IVistaAgregaPokemon extends IVista {

	static final String AGREGAR_POKEMON = "Aceptar";
	static final String AGREGAR_OTRO = "Agregar Otro";
	static final String POKEMON_AGUA = "Agua";
	static final String POKEMON_TIERRA = "Tierra";
	static final String POKEMON_HIELO = "Hielo";
	static final String POKEMON_ELECTRICO = "Electrico";
	static final String POKEMON_HIELO_RECARGADO = "Hielo Recargado";
	static final String POKEMON_FUEGO = "Fuego";
	static final String POKEMON_COMUN = "Comun";
	static final String POKEMON_LEGENDARIO = "Legendario";

	/**
	 * Método que retorna el nombre del pokemon a instanciar.<br>
	 * 
	 * @return String que representa el nombre del pokemon.<br>
	 */
	String getNombrePokemon();

	/**
	 * Método que retorna el tipo del pokemon a instanciar.<br>
	 * 
	 * @return String que representa el tipo del pokemon.<br>
	 */
	String getTipoPokemon();

	/**
	 * Método que retorna el elemento del pokemon a instanciar.<br>
	 * 
	 * @return String que representa el elemento del pokemon.<br>
	 */
	String getElementoPokemon();

}
