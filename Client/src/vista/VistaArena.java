package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.FlowLayout;

public class VistaArena extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelArena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaArena frame = new VistaArena();
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
	public VistaArena() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 563);
		panelArena = new JPanel();
		panelArena.setBorder(new TitledBorder(null, "Arena", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(panelArena);
		GridBagLayout gbl_panelArena = new GridBagLayout();
		gbl_panelArena.columnWidths = new int[]{427, 0};
		gbl_panelArena.rowHeights = new int[] {170, 240, 90, 0};
		gbl_panelArena.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelArena.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelArena.setLayout(gbl_panelArena);
		
		JPanel panelParticipantes = new JPanel();
		GridBagConstraints gbc_panelParticipantes = new GridBagConstraints();
		gbc_panelParticipantes.fill = GridBagConstraints.BOTH;
		gbc_panelParticipantes.insets = new Insets(0, 0, 5, 0);
		gbc_panelParticipantes.gridx = 0;
		gbc_panelParticipantes.gridy = 0;
		panelArena.add(panelParticipantes, gbc_panelParticipantes);
		panelParticipantes.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelParticipante1 = new JPanel();
		panelParticipante1.setBorder(new TitledBorder(null, "Participante 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParticipantes.add(panelParticipante1);
		panelParticipante1.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblNombreP1 = new JLabel("'Sin asignar'");
		lblNombreP1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreP1.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipante1.add(lblNombreP1);
		
		JButton btnInfoEntrenadorP1 = new JButton("Info entrenador");
		btnInfoEntrenadorP1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelParticipante1.add(btnInfoEntrenadorP1);
		
		JLabel lblPokemonP1 = new JLabel("'Sin asignar'");
		lblPokemonP1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPokemonP1.setHorizontalAlignment(SwingConstants.CENTER);
		panelParticipante1.add(lblPokemonP1);
		
		JButton btnInfoPokemonP1 = new JButton("Info pok\u00E9mon");
		btnInfoPokemonP1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelParticipante1.add(btnInfoPokemonP1);
		
		JPanel panelParticipante2 = new JPanel();
		panelParticipante2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Participante 2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelParticipantes.add(panelParticipante2);
		panelParticipante2.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblNombreP2 = new JLabel("'Sin asignar'");
		lblNombreP2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreP2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelParticipante2.add(lblNombreP2);
		
		JButton btnInfoEntrenadorP2 = new JButton("Info entrenador");
		btnInfoEntrenadorP2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelParticipante2.add(btnInfoEntrenadorP2);
		
		JLabel lblPokemonP2 = new JLabel("'Sin asignar'");
		lblPokemonP2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonP2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelParticipante2.add(lblPokemonP2);
		
		JButton btnInfoPokemonP2 = new JButton("Info pok\u00E9mon");
		btnInfoPokemonP2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelParticipante2.add(btnInfoPokemonP2);
		
		JPanel panelHistorial = new JPanel();
		panelHistorial.setBorder(new TitledBorder(null, "Resumen de batalla", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelHistorial = new GridBagConstraints();
		gbc_panelHistorial.fill = GridBagConstraints.BOTH;
		gbc_panelHistorial.insets = new Insets(0, 0, 5, 0);
		gbc_panelHistorial.gridx = 0;
		gbc_panelHistorial.gridy = 1;
		panelArena.add(panelHistorial, gbc_panelHistorial);
		panelHistorial.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollBatalla = new JScrollPane();
		panelHistorial.add(scrollBatalla, BorderLayout.CENTER);
		
		JTextPane textHistorial = new JTextPane();
		scrollBatalla.setViewportView(textHistorial);
		
		JPanel panelBoton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBoton.getLayout();
		flowLayout.setVgap(30);
		GridBagConstraints gbc_panelBoton = new GridBagConstraints();
		gbc_panelBoton.fill = GridBagConstraints.BOTH;
		gbc_panelBoton.gridx = 0;
		gbc_panelBoton.gridy = 2;
		panelArena.add(panelBoton, gbc_panelBoton);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBoton.add(btnAceptar);
	}

}
