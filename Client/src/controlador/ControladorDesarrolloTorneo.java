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

public class ControladorDesarrolloTorneo implements Observer {

	private IVistaDesarrolloTorneo vista;
	private Torneo torneo;
	private ArrayList<Observable> observables = new ArrayList<>();

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
				&& !arg.toString().contentEquals(IVistaRegistroParticipantes.FIN_RONDA))
			this.vista.agregaDetalles((String) arg);
	}

}
