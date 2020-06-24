package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import modeloClases.Entrenador;
import modeloClases.Torneo;

import vista.VistaAgregaPokemon;

import vista.interfacesVista.IVistaAgregaEntrenador;
import vista.interfacesVista.IVistaAgregaPokemon;

/**
 * @author Frangolini,Luciano.<br>
 *         Clase que representa un controlador. Se encarga de relacionar las
 *         acciones tomadas en la ventana utilizada para agregar entrenadores
 *         con su correspondiente modelo y con las demás ventanas dependientes
 *         de ella.<br>
 */
public class ControladorAgregaEntrenador implements ActionListener, Observer {

	private IVistaAgregaEntrenador vista;
	private Torneo torneo;
	private Entrenador entrenador;
	private ArrayList<Observable> observados = new ArrayList<Observable>();

	/**
	 * Constructor de la clase ControladorAgregaEntrenador.<br>
	 * <b> Pre: </b> El parámetro debe ser distinto de null.<br>
	 * 
	 * @param vista de tipo IVistaAgregaEntrenador: Representa la vista que
	 *              supervisa este controlador.<br>
	 */
	public ControladorAgregaEntrenador(IVistaAgregaEntrenador vista) {
		this.vista = vista;
		this.torneo = Torneo.getInstance();
		this.entrenador = null;
	}

	/**
	 * Método encargado de recibir eventos originados en el parámetro vista y
	 * realizar tareas acorde a estos eventos.<br>
	 * 
	 * @param evento de tipo ActionEvent : Identifica el evento que será analizado.
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equalsIgnoreCase(IVistaAgregaEntrenador.ACEPTAR)) {
			if (this.entrenador == null) {
				String nombreEntrenador = vista.getNombreEntrenador();
				int cantidadDeCartas = vista.getCantidadDeCartas();
				if (nombreEntrenador != null && !nombreEntrenador.isEmpty()) {
					torneo.agregaEntrenador(nombreEntrenador, cantidadDeCartas);
					vista.cerrar();
				}
			} else if (this.entrenador.getNombre() != null && !this.entrenador.getNombre().isEmpty()) {
				torneo.agregaEntrenador(this.entrenador);
				vista.cerrar();
			}
		} else if (evento.getActionCommand().equalsIgnoreCase(IVistaAgregaEntrenador.AGREGAR_OTRO_POKEMON)) {
			if (this.entrenador == null)
				this.entrenador = new Entrenador(vista.getNombreEntrenador(), vista.getCantidadDeCartas());
			this.abrirVentanaPokemon();
		}

	}

	/**
	 * Método encargado de instanciar y mostrar una ventana con su respectivo
	 * controlador para añadir un pokémon.
	 */
	public void abrirVentanaPokemon() {
		IVistaAgregaPokemon vistaPokemon = new VistaAgregaPokemon();
		ControladorAgregaPokemon controlador = new ControladorAgregaPokemon(vistaPokemon, this.entrenador);
		this.observados.add(controlador);
		controlador.addObserver(this);
		vistaPokemon.setControlador(controlador);
		vistaPokemon.abrir();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!this.observados.contains(o))
			throw new InvalidParameterException();

		if (arg.toString().contentEquals(IVistaAgregaPokemon.AGREGAR_POKEMON)) {
			this.vista.actualizarListaPokemones(this.entrenador.getPokemones().iterator());
		}
	}
}
