package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class NoSeUsa_VistaInfoEntrenador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelInfoEntrenador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoSeUsa_VistaInfoEntrenador frame = new NoSeUsa_VistaInfoEntrenador();
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
	public NoSeUsa_VistaInfoEntrenador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 377);
		panelInfoEntrenador = new JPanel();
		panelInfoEntrenador.setBorder(new TitledBorder(null, "Informaci\u00F3n Entrenador", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(panelInfoEntrenador);
		panelInfoEntrenador.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panelAtributos = new JPanel();
		panelInfoEntrenador.add(panelAtributos);
		panelAtributos.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelAtributos.add(lblNombre);
		
		JLabel lblMuestraNombre = new JLabel("'Se asigna'");
		lblMuestraNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAtributos.add(lblMuestraNombre);
		
		JLabel lblClasifActual = new JLabel("Clasificaci\u00F3n Actual:");
		lblClasifActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasifActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAtributos.add(lblClasifActual);
		
		JLabel lblMuestraClasifActual = new JLabel("'Se asigna'");
		lblMuestraClasifActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAtributos.add(lblMuestraClasifActual);
		
		JLabel lblCreditos = new JLabel("Cr\u00E9ditos");
		lblCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		panelAtributos.add(lblCreditos);
		
		JLabel lblMuestraCreditos = new JLabel("'Se asigna'");
		lblMuestraCreditos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAtributos.add(lblMuestraCreditos);
		
		JLabel lblCantCartas = new JLabel("Cantidad de Cartas:");
		lblCantCartas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantCartas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAtributos.add(lblCantCartas);
		
		JLabel lblMuestraCantCartas = new JLabel("'Se asigna'");
		lblMuestraCantCartas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelAtributos.add(lblMuestraCantCartas);
		
		JPanel panelPokemones = new JPanel();
		panelPokemones.setBorder(new TitledBorder(null, "Lista de Pokemones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfoEntrenador.add(panelPokemones);
		panelPokemones.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPokemones = new JScrollPane();
		panelPokemones.add(scrollPokemones);
		
		JList listPokemones = new JList();
		scrollPokemones.setViewportView(listPokemones);
	}

}
