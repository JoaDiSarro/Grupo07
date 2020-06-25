package vista;

import controlador.ControladorRegistroDeParticipantes;
import modeloClases.Entrenador;
import modeloClases.Pokemon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import vista.interfacesVista.IVistaRegistroParticipantes;
import java.awt.event.MouseAdapter;

/**
 * @author Frangolini,Luciano.<br>
 *         Clase que representa una ventana donde se observan y registran los
 *         entrenadores y pokemones que participarán en un torneo<br>
 */

public class VistaRegistroDeParticipantes extends JFrame implements IVistaRegistroParticipantes {

	private static final long serialVersionUID = 1L;
	private JPanel panelGeneral;
	private ControladorRegistroDeParticipantes controlador; // ActionListener
	private JButton btnAgregarEntrenador = new JButton("Agregar Entrenador");
	private JButton btnClonaEntrenador = new JButton("Clonar Entrenador");
	private JButton btnAgregarPokemon = new JButton("Agregar Pokemon");
	private JButton btnClonaPokemon = new JButton("Clonar Pokemon");
	private JButton btnIniciarTorneo = new JButton("INICIO DEL TORNEO");
	private DefaultListModel<Entrenador> listModelEntrenadores = new DefaultListModel<Entrenador>();
	private JList<Entrenador> listEntrenadores;
	private DefaultListModel<Pokemon> listModelPokemones = new DefaultListModel<Pokemon>();
	private JList<Pokemon> listPokemones;
	private JLabel lblRestriccionTorneo;

	/**
	 * Constructor de la clase VistaRegistroDeParticipantes.<br>
	 */

	public VistaRegistroDeParticipantes() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 800, 619);
		this.setTitle("Registro de Participantes");
		panelGeneral = new JPanel();
		setContentPane(panelGeneral);
		GridBagLayout gbl_panelGeneral = new GridBagLayout();
		gbl_panelGeneral.columnWidths = new int[] { 503, 0 };
		gbl_panelGeneral.rowHeights = new int[] { 481, 238, 0 };
		gbl_panelGeneral.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelGeneral.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panelGeneral.setLayout(gbl_panelGeneral);

		JPanel panelListas = new JPanel();
		GridBagConstraints gbc_panelListas = new GridBagConstraints();
		gbc_panelListas.insets = new Insets(0, 0, 5, 0);
		gbc_panelListas.fill = GridBagConstraints.BOTH;
		gbc_panelListas.gridx = 0;
		gbc_panelListas.gridy = 0;
		panelGeneral.add(panelListas, gbc_panelListas);
		panelListas.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelEntrenadores = new JPanel();
		panelEntrenadores
				.setBorder(new CompoundBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						new LineBorder(new Color(0, 0, 0), 1, true)));
		panelListas.add(panelEntrenadores);
		panelEntrenadores.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollListaEntrenadores = new JScrollPane();
		panelEntrenadores.add(scrollListaEntrenadores, BorderLayout.CENTER);

		this.listEntrenadores = new JList<Entrenador>();
		scrollListaEntrenadores.setViewportView(listEntrenadores);
		listEntrenadores.setModel(this.listModelEntrenadores);

		JPanel panelPokemones = new JPanel();
		panelPokemones
				.setBorder(
						new CompoundBorder(
								new TitledBorder(
										new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
												new Color(160, 160, 160)),
										"Pokemones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
								new LineBorder(new Color(0, 0, 0), 1, true)));
		panelListas.add(panelPokemones);
		panelPokemones.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollListaPokemones = new JScrollPane();
		panelPokemones.add(scrollListaPokemones, BorderLayout.CENTER);

		this.listPokemones = new JList<Pokemon>();
		scrollListaPokemones.setViewportView(listPokemones);
		listPokemones.setModel(this.listModelPokemones);

		JPanel panelBotones = new JPanel();
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 0;
		gbc_panelBotones.gridy = 1;
		panelGeneral.add(panelBotones, gbc_panelBotones);
		panelBotones.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelAgregaObjetos = new JPanel();
		panelBotones.add(panelAgregaObjetos);
		panelAgregaObjetos.setLayout(new GridLayout(2, 2, 0, 0));

		JPanel panelEnvAgregaEntrenador = new JPanel();
		FlowLayout fl_panelEnvAgregaEntrenador = (FlowLayout) panelEnvAgregaEntrenador.getLayout();
		fl_panelEnvAgregaEntrenador.setVgap(25);
		panelAgregaObjetos.add(panelEnvAgregaEntrenador);

		// AgregarEntrenador
		panelEnvAgregaEntrenador.add(btnAgregarEntrenador);
		btnAgregarEntrenador.setActionCommand(AGREGAR_ENTRENADOR);

		JPanel panelEnvClonaEntrenador = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEnvClonaEntrenador.getLayout();
		flowLayout.setVgap(25);
		panelAgregaObjetos.add(panelEnvClonaEntrenador);
		btnClonaEntrenador.setEnabled(false);

		// ClonaEntrenador
		panelEnvClonaEntrenador.add(btnClonaEntrenador);
		btnClonaEntrenador.setActionCommand(CLONA_ENTRENADOR);

		JPanel panelEnvAgregaPokemon = new JPanel();
		panelAgregaObjetos.add(panelEnvAgregaPokemon);
		btnAgregarPokemon.setEnabled(false);

		// AgregarPokemon
		panelEnvAgregaPokemon.add(btnAgregarPokemon);
		btnAgregarPokemon.setActionCommand(AGREGAR_POKEMON);

		JPanel panelEnvClonaPokemon = new JPanel();
		panelAgregaObjetos.add(panelEnvClonaPokemon);
		btnClonaPokemon.setEnabled(false);

		// ClonaPokemon
		panelEnvClonaPokemon.add(btnClonaPokemon);
		btnClonaPokemon.setActionCommand(CLONA_POKEMON);

		JPanel panelInicioTorneo = new JPanel();
		panelBotones.add(panelInicioTorneo);
		panelInicioTorneo.setLayout(new GridLayout(2, 0, 0, 0));
		btnIniciarTorneo.setEnabled(false);

		// IniciarTorneo
		btnIniciarTorneo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelInicioTorneo.add(btnIniciarTorneo);
		btnIniciarTorneo.setActionCommand(INICIAR_TORNEO);

		JPanel panelEnvRestriccionTorneo = new JPanel();
		panelEnvRestriccionTorneo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panelInicioTorneo.add(panelEnvRestriccionTorneo);
		panelEnvRestriccionTorneo.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollRestriccionTorneo = new JScrollPane();
		panelEnvRestriccionTorneo.add(scrollRestriccionTorneo);

		this.lblRestriccionTorneo = new JLabel(
				" Se requieren 16 entrenadores con al menos 1 pokémon cada uno para comenzar el torneo ");
		lblRestriccionTorneo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRestriccionTorneo.setHorizontalAlignment(SwingConstants.CENTER);
		scrollRestriccionTorneo.setViewportView(lblRestriccionTorneo);

		// Listeners:

		addListeners();
	}

	/**
	 * Método encargado de asignarle un Listener a cada lista de la ventana, las
	 * cuales son la de entrenadores y la de pokemones.
	 */

	private void addListeners() {
		ListSelectionListener escuchaEntrenadores = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Entrenador entrenador = listEntrenadores.getSelectedValue();

				actualizaListaPokemones(entrenador);
			}

			private void actualizaListaPokemones(Entrenador entrenador) {
				if (entrenador != null) {
					btnAgregarPokemon.setEnabled(true);
					actualizarListaPokemones(entrenador.getPokemones().iterator());
					if (listModelEntrenadores.size() < 16)
						btnClonaEntrenador.setEnabled(true);
				}
			}
		};

		ListSelectionListener escuchaPokemones = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				Pokemon pokemon = listPokemones.getSelectedValue();

				if (pokemon != null) {
					btnClonaPokemon.setEnabled(true);
				}
			}

		};

		this.listEntrenadores.addListSelectionListener(escuchaEntrenadores);
		this.listPokemones.addListSelectionListener(escuchaPokemones);
	}

	/**
	 * Método encargado de asignar un controlador a ésta ventana y sus
	 * elementos.<br>
	 * <b> Pre: </b> El parámetro debe ser distinto de null.<br>
	 * 
	 * @param c de tipo ActionListener: Representa el controlador que controlará
	 *          esta ventana.<br>
	 */

	public void setControlador(ActionListener c) {
		controlador = (ControladorRegistroDeParticipantes) c;
		btnAgregarEntrenador.addActionListener(c);
		btnClonaEntrenador.addActionListener(c);
		btnAgregarPokemon.addActionListener(c);
		btnClonaPokemon.addActionListener(c);
		btnIniciarTorneo.addActionListener(c);
	}

	/**
	 * Método encargado de posicionar y hacer visible ésta ventana.<br>
	 */

	@Override
	public void abrir() {
		setBounds(300, 300, 920, 619);
		setVisible(true);
	}

	/**
	 * Método encargado de ocultar ésta ventana.<br>
	 */

	@Override
	public void cerrar() {
		setVisible(false);
	}

	/**
	 * Método encargado de cambiar el texto del label Restriccion Torneo para que
	 * muestre al ganador del torneo.<br>
	 * <b> Pre: </b> El parámetro debe ser distinto de null.<br>
	 * 
	 * @param ganador de tipo String: Representa el nombre y los atributos del
	 *                ganador del torneo en formato String.<br>
	 */

	@Override
	public void setResultado(String ganador) {
		this.lblRestriccionTorneo.setText(ganador);
	}

	/**
	 * Método encargado de devolver la cantidad de participantes que se encuentran
	 * actualmente registrados al torneo.<br>
	 * 
	 * @return Cantidad de entrenadores registrados en el torneo. Tipo int.<br>
	 */

	@Override
	public int getCantidadParticipantes() {
		return this.listModelEntrenadores.size();
	}

	/**
	 * Método encargado de devolver el entrenador seleccionado de la lista de
	 * participantes.<br>
	 * 
	 * @return Entrenador seleccionado de la lista de participantes. Tipo
	 *         Entrenador.<br>
	 */

	@Override
	public Entrenador getEntrenadorActual() {
		return this.listEntrenadores.getSelectedValue();
	}

	/**
	 * Método encargado de devolver el pokémon seleccionado de la lista de
	 * pokémones.<br>
	 * 
	 * @return Pokemon seleccionado de la lista de pokemones. Tipo Pokemon.<br>
	 */

	@Override
	public Pokemon getPokemonActual() {
		return this.listPokemones.getSelectedValue();
	}

	/**
	 * Método encargado de actualizar la lista de entrenadores de la ventana.<br>
	 * 
	 * @param it de tipo Iterator<Entrenador>: Representa un iterador de la lista de
	 *           entrenadores registrados al torneo.<br>
	 */

	@Override
	public void actualizarListaEntrenadores(Iterator<Entrenador> it) {
		this.listModelEntrenadores.clear();
		boolean completos = true;
		while (it.hasNext()) {
			Entrenador entrenador = it.next();
			this.listModelEntrenadores.addElement(entrenador);
			if (completos && entrenador.getPokemones().size() == 0)
				completos = false;
		}
		this.repaint();
		this.btnClonaEntrenador.setEnabled(false);
		this.btnAgregarPokemon.setEnabled(false);
		this.btnClonaPokemon.setEnabled(false);
		if (this.listModelEntrenadores.size() == 16) {
			this.btnAgregarEntrenador.setEnabled(false);
			if (completos)
				this.btnIniciarTorneo.setEnabled(true);
		}
	}

	/**
	 * Método encargado de actualizar la lista de pokemones de la ventana.<br>
	 * 
	 * @param it de tipo Iterator<Pokemon>: Representa un iterador de la lista de
	 *           pokemones registrados al torneo.<br>
	 */

	@Override
	public void actualizarListaPokemones(Iterator<Pokemon> it) {
		this.listModelPokemones.clear();
		while (it.hasNext())
			this.listModelPokemones.addElement(it.next());
		this.repaint();
		this.btnClonaPokemon.setEnabled(false);
	}

	/**
	 * Método encargado de deshabilitar el botón para comenzar el torneo.
	 */

	@Override
	public void deshabilitaBotonTorneo() {
		this.btnIniciarTorneo.setEnabled(false);
	}

}
