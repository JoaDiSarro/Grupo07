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
import vista.interfacesVista.IVistaAgregaPokemon;
import vista.interfacesVista.IVistaRegistroParticipantes;

public class ControladorAgregaPokemon extends Observable implements ActionListener {

	private IVistaAgregaPokemon vista;
	private Torneo torneo;
	private Entrenador entrenador;
	public static PokemonFactory factory = new PokemonFactory();

	public ControladorAgregaPokemon(IVistaAgregaPokemon vista, Entrenador entrenador) {
		this.vista = vista;
		this.entrenador = entrenador;
		this.torneo = Torneo.getInstance();
	}

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

	public Entrenador getEntrenadorActual() {
		return entrenador;
	}
	
	
}
