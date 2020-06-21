package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modeloClases.Torneo;

import vista.VistaAgregaPokemon;

import vista.interfacesVista.IVistaAgregaEntrenador;
import vista.interfacesVista.IVistaAgregaPokemon;

public class ControladorAgregaEntrenador implements ActionListener{

	private IVistaAgregaEntrenador vista;
	private Torneo torneo;

	public ControladorAgregaEntrenador(IVistaAgregaEntrenador vista) {
		this.vista = vista;
		this.torneo = Torneo.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equalsIgnoreCase(IVistaAgregaEntrenador.ACEPTAR)) {
			String nombreEntrenador = vista.getNombreEntrenador();
			int cantidadDeCartas = vista.getCantidadDeCartas();
			if (nombreEntrenador != null && !nombreEntrenador.isEmpty()) {
				torneo.agregaEntrenador(nombreEntrenador, cantidadDeCartas);
				vista.cerrar();
			}
		} else if (evento.getActionCommand().equalsIgnoreCase(vista.AGREGARPOKEMON)) {
			//abrirVentanaPokemon();
		}
		
	}

	/*public void abrirVentanaPokemon() {
		IVistaAgregaPokemon vista = new VistaAgregaPokemon();
		ControladorAgregaPokemon controlador = new ControladorAgregaPokemon(vista);
		vista.setControlador(controlador);
		vista.abrir();
	}*/
}
