package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class AgregaEntrenador extends JFrame {

	private JPanel panelRegistroEntrenador;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregaEntrenador frame = new AgregaEntrenador();
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
	public AgregaEntrenador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 416);
		panelRegistroEntrenador = new JPanel();
		panelRegistroEntrenador.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registrar entrenador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRegistroEntrenador.setLayout(new BorderLayout(0, 0));
		setContentPane(panelRegistroEntrenador);
		
		JPanel panelDatosEntrenador = new JPanel();
		panelRegistroEntrenador.add(panelDatosEntrenador, BorderLayout.CENTER);
		GridBagLayout gbl_panelDatosEntrenador = new GridBagLayout();
		gbl_panelDatosEntrenador.columnWidths = new int[]{470, 0};
		gbl_panelDatosEntrenador.rowHeights = new int[] {80, 194, 80, 0};
		gbl_panelDatosEntrenador.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelDatosEntrenador.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDatosEntrenador.setLayout(gbl_panelDatosEntrenador);
		
		JPanel panelNombre = new JPanel();
		GridBagConstraints gbc_panelNombre = new GridBagConstraints();
		gbc_panelNombre.fill = GridBagConstraints.BOTH;
		gbc_panelNombre.insets = new Insets(0, 0, 5, 0);
		gbc_panelNombre.gridx = 0;
		gbc_panelNombre.gridy = 0;
		panelDatosEntrenador.add(panelNombre, gbc_panelNombre);
		panelNombre.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelNombre.add(lblNombre);
		
		JPanel panelEnvNombre = new JPanel();
		panelNombre.add(panelEnvNombre);
		panelEnvNombre.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 30));
		
		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		panelEnvNombre.add(textNombre);
		textNombre.setColumns(20);
		
		JPanel panelListaPokemones = new JPanel();
		panelListaPokemones.setBorder(new TitledBorder(null, "Pokemones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelListaPokemones = new GridBagConstraints();
		gbc_panelListaPokemones.fill = GridBagConstraints.BOTH;
		gbc_panelListaPokemones.insets = new Insets(0, 0, 5, 0);
		gbc_panelListaPokemones.gridx = 0;
		gbc_panelListaPokemones.gridy = 1;
		panelDatosEntrenador.add(panelListaPokemones, gbc_panelListaPokemones);
		panelListaPokemones.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPokemones = new JScrollPane();
		panelListaPokemones.add(scrollPokemones, BorderLayout.CENTER);
		
		JList listPokemones = new JList();
		scrollPokemones.setViewportView(listPokemones);
		
		JPanel panelBotones = new JPanel();
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 0;
		gbc_panelBotones.gridy = 2;
		panelDatosEntrenador.add(panelBotones, gbc_panelBotones);
		panelBotones.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelEnvNuevoPokemon = new JPanel();
		panelBotones.add(panelEnvNuevoPokemon);
		panelEnvNuevoPokemon.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		JButton btnAgregaPokemon = new JButton("Agregar Pok\u00E9mon");
		btnAgregaPokemon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEnvNuevoPokemon.add(btnAgregaPokemon);
		
		JPanel panelEnvCrear = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEnvCrear.getLayout();
		flowLayout.setVgap(20);
		panelBotones.add(panelEnvCrear);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEnvCrear.add(btnAceptar);
	}

}
