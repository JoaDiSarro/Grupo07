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

public class VistaDesarrolloTorneo extends JFrame implements IVistaDesarrolloTorneo{

	private JPanel panelPrincipal;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaDesarrolloTorneo frame = new VistaDesarrolloTorneo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaDesarrolloTorneo() {
		setTitle("Desarrollo de batallas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 619);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);
		
		JScrollPane scrollPane = new JScrollPane();
		panelPrincipal.add(scrollPane, BorderLayout.CENTER);
		
		this.textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
	}

	@Override
	public void abrir() {
		setBounds(100, 100, 519, 619);
		this.setVisible(true);
	}

	@Override
	public void cerrar() {
		this.setVisible(false);
	}

	@Override
	public void setControlador(ActionListener c) {}

	@Override
	public void agregaDetalles(String detalles) {
		this.textArea.append("\n"+detalles);
	}

	

}
