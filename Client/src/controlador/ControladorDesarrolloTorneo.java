package controlador;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import modeloClases.Entrenador;
import modeloClases.Torneo;
import vista.interfacesVista.IVistaAgregaPokemon;
import vista.interfacesVista.IVistaDesarrolloTorneo;
import vista.interfacesVista.IVistaRegistroParticipantes;

/**
 * @author Frangolini,Luciano.<br>
 *         Clase que representa un controlador. Se encarga de relacionar los
 *         avisos que suceden en el modelo con la vista encargada de mostrar el
 *         desarrollo del torneo.<br>
 */

public class ControladorDesarrolloTorneo implements Observer {

	private IVistaDesarrolloTorneo vista;
	private Torneo torneo;
	private ArrayList<Observable> observables = new ArrayList<>();

	/**
	 * Constructor de la clase ControladorDesarrolloTorneo<br>
	 * <b> Pre: </b> El parámetro debe ser distinto de null.<br>
	 * 
	 * @param vista de tipo IVistaDesarrolloTorneo: Representa la vista supervisada
	 *              por este controlador.<br>
	 */

	public ControladorDesarrolloTorneo(IVistaDesarrolloTorneo vista) {
		this.vista = vista;
		this.torneo = Torneo.getInstance();
		this.observables.add(this.torneo);
		this.torneo.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!this.observables.contains(o))
			throw new InvalidParameterException();

		if (!arg.toString().contentEquals(IVistaRegistroParticipantes.FIN_TORNEO)
				&& !arg.toString().contentEquals(IVistaRegistroParticipantes.FIN_RONDA)) {
			
			this.vista.agregaDetalles((String) arg);
			
		}
		
			
	}

}
