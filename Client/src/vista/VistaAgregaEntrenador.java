package vista;

import controlador.ControladorAgregaEntrenador;
import controlador.ControladorRegistroDeParticipantes;
import modeloClases.Entrenador;
import modeloClases.Pokemon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Iterator;

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
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

import javax.swing.JOptionPane;

import vista.interfacesVista.IVistaAgregaEntrenador;

public class VistaAgregaEntrenador extends JFrame implements IVistaAgregaEntrenador, KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel panelRegistroEntrenador;
	private JTextField textNombre;
	private ControladorAgregaEntrenador controlador;
	private JButton btnAgregaPokemon = new JButton("Agregar Pok\u00E9mon");
	private JButton btnAceptar = new JButton("Aceptar");
	private JTextField textCantidadCartas;
	private DefaultListModel<Pokemon> listModelPokemones = new DefaultListModel<Pokemon>();
	private JList<Pokemon> listPokemones;

	/**
	 * Create the frame.
	 */
	public VistaAgregaEntrenador() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 430); // Borrar después, lo dejo para probar ahora
		this.setTitle("Registrar Entrenador");
		panelRegistroEntrenador = new JPanel();
		panelRegistroEntrenador.setLayout(new BorderLayout(0, 0));
		setContentPane(panelRegistroEntrenador);

		JPanel panelDatosEntrenador = new JPanel();
		panelRegistroEntrenador.add(panelDatosEntrenador, BorderLayout.CENTER);
		GridBagLayout gbl_panelDatosEntrenador = new GridBagLayout();
		gbl_panelDatosEntrenador.columnWidths = new int[] { 470, 0 };
		gbl_panelDatosEntrenador.rowHeights = new int[] { 80, 194, 80, 0 };
		gbl_panelDatosEntrenador.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelDatosEntrenador.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelDatosEntrenador.setLayout(gbl_panelDatosEntrenador);

		JPanel panelNombre = new JPanel();
		GridBagConstraints gbc_panelNombre = new GridBagConstraints();
		gbc_panelNombre.fill = GridBagConstraints.BOTH;
		gbc_panelNombre.insets = new Insets(0, 0, 5, 0);
		gbc_panelNombre.gridx = 0;
		gbc_panelNombre.gridy = 0;
		panelDatosEntrenador.add(panelNombre, gbc_panelNombre);
		panelNombre.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelNombre.add(lblNombre);

		JPanel panelEnvNombre = new JPanel();
		panelNombre.add(panelEnvNombre);
		panelEnvNombre.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

		textNombre = new JTextField();
		textNombre.setHorizontalAlignment(SwingConstants.LEFT);
		panelEnvNombre.add(textNombre);
		textNombre.setColumns(20);


		JLabel lblCartas = new JLabel("Cantidad de Cartas:");
		lblCartas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCartas.setHorizontalAlignment(SwingConstants.CENTER);
		panelNombre.add(lblCartas);

		JPanel panelEnvCartas = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelEnvCartas.getLayout();
		flowLayout_1.setVgap(15);
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		panelNombre.add(panelEnvCartas);

		textCantidadCartas = new JTextField();
		panelEnvCartas.add(textCantidadCartas);
		textCantidadCartas.setColumns(20);

		JPanel panelListaPokemones = new JPanel();
		panelListaPokemones
				.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pokemones agregados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelListaPokemones = new GridBagConstraints();
		gbc_panelListaPokemones.fill = GridBagConstraints.BOTH;
		gbc_panelListaPokemones.insets = new Insets(0, 0, 5, 0);
		gbc_panelListaPokemones.gridx = 0;
		gbc_panelListaPokemones.gridy = 1;
		panelDatosEntrenador.add(panelListaPokemones, gbc_panelListaPokemones);
		panelListaPokemones.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPokemones = new JScrollPane();
		panelListaPokemones.add(scrollPokemones, BorderLayout.CENTER);

		this.listPokemones = new JList<Pokemon>();
		scrollPokemones.setViewportView(listPokemones);
		listPokemones.setModel(this.listModelPokemones);

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
		btnAgregaPokemon.setEnabled(false);

		// Boton Agrega Pokemon
		btnAgregaPokemon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEnvNuevoPokemon.add(btnAgregaPokemon);
		btnAgregaPokemon.setActionCommand(IVistaAgregaEntrenador.AGREGAR_OTRO_POKEMON);

		JPanel panelEnvCrear = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEnvCrear.getLayout();
		flowLayout.setVgap(20);
		panelBotones.add(panelEnvCrear);

		// Boton Aceptar
		btnAceptar.setEnabled(false);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelEnvCrear.add(btnAceptar);
		btnAceptar.setActionCommand(ACEPTAR);
		
		//Listeners:
		
		//this.btnAceptar.addKeyListener(this);
		this.textCantidadCartas.addKeyListener(this);
		this.textNombre.addKeyListener(this);
	}

	public void abrir() {
		setBounds(100, 100, 493, 430);
		setVisible(true);
	}

	@Override
	public void cerrar() {
		setVisible(false);
	}

	@Override
	public void setControlador(ActionListener c) {
		controlador = (ControladorAgregaEntrenador) c;
		btnAgregaPokemon.addActionListener(c);
		btnAceptar.addActionListener(c);
	}

	@Override
	public String getNombreEntrenador() {
		return this.textNombre.getText();
	}

	@Override
	public int getCantidadDeCartas() {
		return Integer.parseInt(this.textCantidadCartas.getText());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String nombreEntrenador = null;
		int cantidadDeCartas=0;
		boolean cond = false;
		
		nombreEntrenador=this.textNombre.getText();
		try {
			cantidadDeCartas = Integer.parseInt(this.textCantidadCartas.getText());
		} catch (NumberFormatException arg) {}
		
		cond = cantidadDeCartas>0 && nombreEntrenador!=null && !nombreEntrenador.isEmpty();
		this.btnAceptar.setEnabled(cond);
		this.btnAgregaPokemon.setEnabled(cond);
	}
	
	@Override
	public void actualizarListaPokemones(Iterator<Pokemon> it) {
		this.listModelPokemones.clear();
		while (it.hasNext())
			this.listModelPokemones.addElement(it.next());
		this.repaint();
	}

}
