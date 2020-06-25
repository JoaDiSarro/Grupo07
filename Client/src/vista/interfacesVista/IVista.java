package vista.interfacesVista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modeloClases.Entrenador;

/**
 * @author Frangolini, Luciano.<br>
 *         Clase que representa una interfaz que ser� implementada por
 *         vistas.<br>
 *         Posee los m�todos necesarios para su m�nimo funcionamiento.<br>
 */

public interface IVista {
	/**
	 * M�todo encargado de hacer visible una vista.<br>
	 */
	public void abrir();

	/**
	 * M�todo encargado de ocultar una vista.<br>
	 */

	public void cerrar();

	/**
	 * M�todo encargado de asignar un controlador a una vista.<br>
	 * <b> Pre: </b> El par�metro no debe ser nulo.<br>
	 * 
	 * @param c de tipo ActionListener: Representa el controlador a asignar.<br>
	 */

	public void setControlador(ActionListener c);

	/**
	 * M�todo encargado de mostrar una ventana con un mensaje de error.<br>
	 * 
	 * @param mensaje de tipo String: Representa el mensaje que ser� mostrado en una
	 *                nueva ventana.<br>
	 */

	public static void muestraMensajeAlerta(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
