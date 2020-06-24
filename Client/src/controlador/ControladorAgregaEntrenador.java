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

public class ControladorAgregaEntrenador implements ActionListener, Observer {

	private IVistaAgregaEntrenador vista;
	private Torneo torneo;
	private Entrenador entrenador;
	private ArrayList<Observable> observados = new ArrayList<Observable>();

	public ControladorAgregaEntrenador(IVistaAgregaEntrenador vista) {
		this.vista = vista;
		this.torneo = Torneo.getInstance();
		this.entrenador = null;
	}

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
