package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JRadioButton;

import modeloClases.Entrenador;
import modeloClases.Pokemon;
import modeloClases.PokemonFactory;
import modeloClases.Torneo;
import vista.interfacesVista.IVistaAgregaEntrenador;
import vista.interfacesVista.IVistaAgregaPokemon;
import vista.interfacesVista.IVistaRegistroParticipantes;

/**
 * @author Frangolini,Luciano.<br>
 *         Clase que representa un controlador. Se encarga de relacionar las
 *         acciones tomadas en la ventana utilizada para añadir un pokémon con
 *         su correspondiente modelo y con las demás ventanas dependientes de
 *         ella.<br>
 */

public class ControladorAgregaPokemon extends Observable implements ActionListener {

	private IVistaAgregaPokemon vista;
	private Torneo torneo;
	private Entrenador entrenador;
	public static PokemonFactory factory = new PokemonFactory();

	/**
	 * Constructor de la clase ControladorAgregaPokemon<br>
	 * <b> Pre: </b> El parámetro vista debe ser distinto de null.<br>
	 * 
	 * @param vista      de tipo IVistaAgregaPokemon: Representa la vista
	 *                   supervisada por este controlador.<br>
	 * @param entrenador de tipo Entrenador: Representa el entrenador que poseerá el
	 *                   pokémon que se agregará.<br>
	 */

	public ControladorAgregaPokemon(IVistaAgregaPokemon vista, Entrenador entrenador) {
		this.vista = vista;
		this.entrenador = entrenador;
		this.torneo = Torneo.getInstance();
	}

	/**
	 * Método encargado de recibir eventos originados en el parámetro vista y
	 * realizar tareas acorde a estos eventos.<br>
	 * 
	 * @param evento de tipo ActionEvent : Identifica el evento que será analizado.
	 */

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getActionCommand().equalsIgnoreCase(IVistaAgregaPokemon.AGREGAR_POKEMON)) {
			String nombre = this.vista.getNombrePokemon();
			String tipo = this.vista.getTipoPokemon();
			String elemento = this.vista.getElementoPokemon();
			Pokemon pokemon = factory.creaPokemon(nombre, tipo, elemento);
			this.entrenador.agregaPokemon(pokemon);
			this.setChanged();
			this.notifyObservers(IVistaAgregaPokemon.AGREGAR_POKEMON);
			this.vista.cerrar();
		}
	}

	/**
	 * Método encargado de devolver el parámetro entrenador.
	 * 
	 * @return entrenador de tipo Entrenador: Representa el entrenador al que se le
	 *         agregará un pokémon.
	 */
	public Entrenador getEntrenadorActual() {
		return this.entrenador;
	}

}
