package controlador;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import modeloClases.Arena;
import modeloClases.Carta;
import modeloClases.CartaNiebla;
import modeloClases.CartaTormenta;
import modeloClases.CartaViento;
import modeloClases.Entrenador;
import modeloClases.Pokemon;
import modeloClases.Torneo;
import vista.VistaAgregaEntrenador;
import vista.VistaAgregaPokemon;
import vista.VistaDesarrolloTorneo;
import vista.interfacesVista.IVista;
import vista.interfacesVista.IVistaAgregaEntrenador;
import vista.interfacesVista.IVistaAgregaPokemon;
import vista.interfacesVista.IVistaDesarrolloTorneo;
import vista.interfacesVista.IVistaRegistroParticipantes;

public class ControladorRegistroDeParticipantes implements ActionListener, Observer {

	private IVistaRegistroParticipantes vista;
	private Torneo torneo;
	private ArrayList<Observable> observables = new ArrayList<>();

	public ControladorRegistroDeParticipantes(IVistaRegistroParticipantes vista) {
		this.vista = vista;
		this.torneo = Torneo.getInstance();
		this.observables.add(this.torneo);
		this.torneo.addObserver(this);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getActionCommand().equalsIgnoreCase(IVistaRegistroParticipantes.AGREGAR_ENTRENADOR)) {
			this.abreVistaAgregaEntrenador();

		} else if (actionEvent.getActionCommand().equalsIgnoreCase(IVistaRegistroParticipantes.CLONA_ENTRENADOR)) {
			Object entrenadorClon;
			try {
				entrenadorClon = vista.getEntrenadorActual().clone();
				Entrenador entrenadorNuevo = (Entrenador) entrenadorClon;
				if (!entrenadorNuevo.getPokemones().contains(null)) {
					torneo.agregaEntrenador(entrenadorNuevo);
				}
			} catch (CloneNotSupportedException e) {
			}

		} else if (actionEvent.getActionCommand().equalsIgnoreCase(IVistaRegistroParticipantes.AGREGAR_POKEMON)) {
			this.abreVistaAgregaPokemon();

		} else if (actionEvent.getActionCommand().equalsIgnoreCase(IVistaRegistroParticipantes.CLONA_POKEMON)) {
			Entrenador entrenador = this.vista.getEntrenadorActual();
			Object pokemonClon;
			try {
				pokemonClon = vista.getPokemonActual().clone();
				Pokemon pokemonNuevo = (Pokemon) pokemonClon;
				if (pokemonNuevo!=null) {
					this.observables.add(entrenador);
					entrenador.addObserver(this);					
					entrenador.agregaPokemon((Pokemon) pokemonClon);
				}
			} catch (CloneNotSupportedException e) {
			} catch (NullPointerException e) {
				Toolkit.getDefaultToolkit().beep();
				IVistaRegistroParticipantes.muestraMensajeAlerta("Debe seleccionar un entrenador con su pokemon para clonar el pokemon");
			}

		} else if (actionEvent.getActionCommand().equalsIgnoreCase(IVistaRegistroParticipantes.INICIAR_TORNEO)) {
			this.vista.deshabilitaBotonTorneo();
			abreVistaTorneo();
			repartoDeCartas();
			preparaArenas();
			this.torneo.ejecutaTorneo();
		}
	}
	
	public void abreVistaTorneo() {
		IVistaDesarrolloTorneo vistaDesarrollo = new VistaDesarrolloTorneo();
		ControladorDesarrolloTorneo controlador = new ControladorDesarrolloTorneo(vistaDesarrollo);
		vistaDesarrollo.abrir();
	}

	public void abreVistaAgregaEntrenador() {
		IVistaAgregaEntrenador vistaAgregaEntrenador = new VistaAgregaEntrenador();
		ControladorAgregaEntrenador controlador = new ControladorAgregaEntrenador(vistaAgregaEntrenador);
		vistaAgregaEntrenador.setControlador(controlador);
		vistaAgregaEntrenador.abrir();
	}

	public void abreVistaAgregaPokemon() {
		Entrenador entrenadorSeleccionado = this.vista.getEntrenadorActual();
		IVistaAgregaPokemon vistaAgregaPokemon = new VistaAgregaPokemon();
		ControladorAgregaPokemon controlador = new ControladorAgregaPokemon(vistaAgregaPokemon,entrenadorSeleccionado);
		this.observables.add(controlador);
		controlador.addObserver(this);
		vistaAgregaPokemon.setControlador(controlador);
		vistaAgregaPokemon.abrir();
	}

	@Override
	public void update(Observable o, Object arg) {
		if(!this.observables.contains(o))
			throw new InvalidParameterException();

		if (arg.toString().contentEquals(IVistaRegistroParticipantes.AGREGAR_ENTRENADOR))
			this.vista.actualizarListaEntrenadores(this.torneo.getListaEntrenadores().iterator());
		else if (arg.toString().contentEquals(IVistaAgregaPokemon.AGREGAR_POKEMON)) {
			ControladorAgregaPokemon controlador = (ControladorAgregaPokemon) o;
			Entrenador entrenadorActual = controlador.getEntrenadorActual();
			this.vista.actualizarListaPokemones(entrenadorActual.getPokemones().iterator());
			this.vista.actualizarListaEntrenadores(this.torneo.getListaEntrenadores().iterator());
		}
		else if (arg.toString().contentEquals(IVistaRegistroParticipantes.AGREGAR_POKEMON)) {
			Entrenador entrenador = (Entrenador) o;
			this.vista.actualizarListaPokemones(entrenador.getPokemones().iterator());
			this.vista.actualizarListaEntrenadores(this.torneo.getListaEntrenadores().iterator());
		}
		else if (arg.toString().contentEquals(IVistaRegistroParticipantes.FIN_TORNEO)) {
			this.vista.setResultado("Felicitaciones al ganador del torneo!: "+this.torneo.getGanadorTorneo());
		}
		else if (arg.toString().contentEquals(IVistaRegistroParticipantes.FIN_RONDA)) {
			this.vista.actualizarListaEntrenadores(this.torneo.getListaEntrenadores().iterator());
		}
	}
	
	public void repartoDeCartas() {
		Carta cartaNiebla = new CartaNiebla();
        Carta cartaTormenta = new CartaTormenta();
        Carta cartaViento = new CartaViento();
        
        ArrayList<Carta> mazo = new ArrayList<>();
        mazo.add(cartaNiebla);
        mazo.add(cartaTormenta);
        mazo.add(cartaViento);
        
        for (Entrenador entrenadores : this.torneo.getListaEntrenadores()) {
        	entrenadores.setMazo(mazo);
        }
	}
	
	public void preparaArenas() {
		this.torneo.agregaArena(new Arena("ARENA 1"));
		this.torneo.agregaArena(new Arena("ARENA 2"));
		this.torneo.agregaArena(new Arena("ARENA 3"));
	}
}
