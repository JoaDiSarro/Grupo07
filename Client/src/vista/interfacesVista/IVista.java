package vista.interfacesVista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modeloClases.Entrenador;

/**
 * @author Frangolini, Luciano.<br>
 *         Clase que representa una interfaz que será implementada por
 *         vistas.<br>
 *         Posee los métodos necesarios para su mínimo funcionamiento.<br>
 */

public interface IVista {
	/**
	 * Método encargado de hacer visible una vista.<br>
	 */
	public void abrir();

	/**
	 * Método encargado de ocultar una vista.<br>
	 */

	public void cerrar();

	/**
	 * Método encargado de asignar un controlador a una vista.<br>
	 * <b> Pre: </b> El parámetro no debe ser nulo.<br>
	 * 
	 * @param c de tipo ActionListener: Representa el controlador a asignar.<br>
	 */

	public void setControlador(ActionListener c);

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
