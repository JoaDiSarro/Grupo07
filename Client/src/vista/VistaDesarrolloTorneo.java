package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorRegistroDeParticipantes;
import vista.interfacesVista.IVista;
import vista.interfacesVista.IVistaDesarrolloTorneo;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

/**
 * @author Frangolini,Luciano.<br>
 *         Clase que representa una ventana donde se detallan los eventos que
 *         ocurren durante un torneo<br>
 */
public class VistaDesarrolloTorneo extends JFrame implements IVistaDesarrolloTorneo {

	private JPanel panelPrincipal;
	private JTextArea textArea;

	/**
	 * Constructor de la clase VistaDesarrolloTorneo.<br>
	 */
	public VistaDesarrolloTorneo() {
		setTitle("Desarrollo de batallas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 619);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);

		JScrollPane scrollPane = new JScrollPane();
		panelPrincipal.add(scrollPane, BorderLayout.CENTER);

		this.textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

	}

	/**
	 * M�todo encargado de posicionar y hacer visible �sta ventana.<br>
	 */

	@Override
	public void abrir() {
		setBounds(500, 100, 1000, 619);
		this.setVisible(true);
	}

	/**
	 * M�todo encargado de ocultar �sta ventana.<br>
	 */

	@Override
	public void cerrar() {
		this.setVisible(false);
	}

	@Override
	public void setControlador(ActionListener c) {
	}

	/**
	 * M�todo encargado de a�adir texto en el �rea de texto de la ventana.<br>
	 * <b> Pre: </b> El par�metro debe ser distinto de null. <br>
	 * 
	 * @param detalles de tipo String: Representa el texto a a�adir en el �rea de
	 *                 texto.<br>
	 */
	@Override
	public synchronized void agregaDetalles(String detalles) {
		this.textArea.append("\n" + detalles);
		notifyAll();
	}

}
