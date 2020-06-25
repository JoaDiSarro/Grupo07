package vista.interfacesVista;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import modeloClases.Entrenador;
import modeloClases.Pokemon;

/**
 * @author Frangolini, Luciano.<br>
 *         Clase que representa una interfaz utilizada por
 *         VistaRegistroParticipantes. Posee los métodos necesarios para su
 *         mínimo funcionamiento.<br>
 */

public interface IVistaRegistroParticipantes extends IVista {

	static final String AGREGAR_ENTRENADOR = "AgregarEntrenador";
	static final String CLONA_ENTRENADOR = "ClonaEntrenador";
	static final String AGREGAR_POKEMON = "AgregarPokemon";
	static final String CLONA_POKEMON = "ClonaPokemon";
	static final String INICIAR_TORNEO = "IniciarTorneo";
	static final String SELECCIONA_ENTRENADOR = "SeleccionaEntrenador";
	static final String FIN_TORNEO = "Fin";
	static final String FIN_RONDA = "Fin Ronda";

	/**
	 * Método encargado de devolver la cantidad de participantes de un torneo.<br>
	 * 
	 * @return int que representa la cantidad de participantes.<br>
	 */

	public int getCantidadParticipantes();

	/**
	 * Método encargado de actualizar una lista de entrenadores.<br>
	 * 
	 * @param it de tipo Iterator<Entrenador>: Representa un iterador de la lista de
	 *           entrenadores a actualizar.<br>
	 */

	public void actualizarListaEntrenadores(Iterator<Entrenador> it);

	/**
	 * Método encargado de actualizar una lista de pokemones.<br>
	 * 
	 * @param it de tipo Iterator<Pokemon>: Representa un iterador de la lista de
	 *           pokemones a actualizar.<br>
	 */

	public void actualizarListaPokemones(Iterator<Pokemon> it);

	/**
	 * Método encargado de devolver el entrenador seleccionado de una lista.<br>
	 * 
	 * @return Entrenador que representa el entrenador seleccionado.<br>
	 */
	public Entrenador getEntrenadorActual();

	/**
	 * Método encargado de devolver el pokemon seleccionado de una lista<br>
	 * 
	 * @return Pokemon que representa el pokemon seleccionado<br>
	 */

	public Pokemon getPokemonActual();

	/**
	 * Método encargado de cambiar el contenido que muestra un label.<br>
	 * 
	 * @param ganador de tipo String: Representa el contenido que se mostrará en el
	 *                label.<br>
	 */

	public void setResultado(String ganador);

	/**
	 * Método encargado de deshabilitar un botón para iniciar un torneo.<br>
	 */

	public void deshabilitaBotonTorneo();

	/**
	 * Método encargado de mostrar una ventana con un mensaje de error.<br>
	 * 
	 * @param mensaje de tipo String: Representa el mensaje que será mostrado en una
	 *                nueva ventana.<br>
	 */

	public static void muestraMensajeAlerta(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
