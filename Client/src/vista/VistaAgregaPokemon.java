package vista;

import controlador.ControladorAgregaPokemon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;

import vista.interfacesVista.IVistaAgregaPokemon;
import javax.swing.ButtonGroup;

public class VistaAgregaPokemon extends JFrame implements IVistaAgregaPokemon, KeyListener,MouseListener {

	private static final long serialVersionUID = 1L;
	private boolean nombreOk=false;
	private boolean tipoOk=false;
	private boolean elementoOk=false;
	private JPanel panelAgregaPokemon;
	private JTextField textNombre;
	private ControladorAgregaPokemon controlador;
	private JRadioButton rdbtnComun;
	private JRadioButton rdbtnLegendario;
	private JRadioButton rdbtnFuego;
	private JRadioButton rdbtnHielo;
	private JRadioButton rdbtnAgua;
	private JRadioButton rdbtnTierra;
	private JRadioButton rdbtnHieloRecargado;
	private JRadioButton rdbtnElectrico;
	private JButton btnAceptar;
	private JButton btnAgregarOtro;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private final ButtonGroup buttonGroupElemento = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public VistaAgregaPokemon() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 450, 408); // Despues borrar
		this.setTitle("Registrar Pokémon");
		panelAgregaPokemon = new JPanel();
		panelAgregaPokemon.setLayout(new BorderLayout(0, 0));
		setContentPane(panelAgregaPokemon);

		JPanel panelDatos = new JPanel();
		panelAgregaPokemon.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new GridLayout(4, 0, 0, 0));

		JPanel panelNombre = new JPanel();
		panelDatos.add(panelNombre);
		panelNombre.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelNombre.add(lblNombre);

		JPanel panelEnvTextNombre = new JPanel();
		FlowLayout fl_panelEnvTextNombre = (FlowLayout) panelEnvTextNombre.getLayout();
		fl_panelEnvTextNombre.setAlignment(FlowLayout.LEADING);
		fl_panelEnvTextNombre.setVgap(38);
		panelNombre.add(panelEnvTextNombre);

		textNombre = new JTextField();
		panelEnvTextNombre.add(textNombre);
		textNombre.setColumns(15);

		JPanel panelTipo = new JPanel();
		panelTipo.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Seleccionar tipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatos.add(panelTipo);
		panelTipo.setLayout(new GridLayout(2, 0, 0, 0));

		this.rdbtnComun = new JRadioButton("Comun");
		this.rdbtnComun.setActionCommand("Comun");
		buttonGroupTipo.add(rdbtnComun);
		panelTipo.add(rdbtnComun);

		this.rdbtnLegendario = new JRadioButton("Legendario");
		this.rdbtnLegendario.setActionCommand("Legendario");
		buttonGroupTipo.add(rdbtnLegendario);
		panelTipo.add(rdbtnLegendario);

		JPanel panelElemento = new JPanel();
		panelElemento.setBorder(
				new TitledBorder(null, "Seleccionar elemento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatos.add(panelElemento);
		panelElemento.setLayout(new GridLayout(2, 3, 0, 0));

		this.rdbtnFuego = new JRadioButton("Fuego");
		this.rdbtnFuego.setActionCommand("Fuego");
		buttonGroupElemento.add(rdbtnFuego);
		panelElemento.add(rdbtnFuego);

		this.rdbtnHielo = new JRadioButton("Hielo");
		this.rdbtnHielo.setActionCommand("Hielo");
		buttonGroupElemento.add(rdbtnHielo);
		panelElemento.add(rdbtnHielo);

		this.rdbtnAgua = new JRadioButton("Agua");
		this.rdbtnAgua.setActionCommand("Agua");
		buttonGroupElemento.add(rdbtnAgua);
		panelElemento.add(rdbtnAgua);

		this.rdbtnTierra = new JRadioButton("Tierra");
		this.rdbtnTierra.setActionCommand("Tierra");
		buttonGroupElemento.add(rdbtnTierra);
		panelElemento.add(rdbtnTierra);

		this.rdbtnHieloRecargado = new JRadioButton("Hielo Recargado");
		this.rdbtnHieloRecargado.setActionCommand("Hielo Recargado");
		buttonGroupElemento.add(rdbtnHieloRecargado);
		panelElemento.add(rdbtnHieloRecargado);

		this.rdbtnElectrico = new JRadioButton("Electrico");
		this.rdbtnElectrico.setActionCommand("Electrico");
		buttonGroupElemento.add(rdbtnElectrico);
		panelElemento.add(rdbtnElectrico);

		JPanel panelBoton = new JPanel();
		panelDatos.add(panelBoton);
		panelBoton.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelEnvAgregaOtro = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEnvAgregaOtro.getLayout();
		flowLayout.setVgap(25);
		panelBoton.add(panelEnvAgregaOtro);

		this.btnAgregarOtro = new JButton("Agregar Otro");
		btnAgregarOtro.setEnabled(false);
		panelEnvAgregaOtro.add(btnAgregarOtro);
		btnAgregarOtro.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JPanel panelAceptar = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelAceptar.getLayout();
		flowLayout_1.setVgap(25);
		panelBoton.add(panelAceptar);

		this.btnAceptar = new JButton("Aceptar");
		panelAceptar.add(btnAceptar);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setEnabled(false);
		
		//Listeners:
		
		this.rdbtnAgua.addMouseListener(this);
		this.rdbtnComun.addMouseListener(this);
		this.rdbtnElectrico.addMouseListener(this);
		this.rdbtnFuego.addMouseListener(this);
		this.rdbtnHielo.addMouseListener(this);
		this.rdbtnHieloRecargado.addMouseListener(this);
		this.rdbtnLegendario.addMouseListener(this);
		this.rdbtnTierra.addMouseListener(this);
		this.textNombre.addKeyListener(this);
	}

	@Override
	public void abrir() {
		setBounds(300, 300, 450, 408);
		setVisible(true);
	}

	@Override
	public void cerrar() {
		setVisible(false);
	}

	@Override
	public void setControlador(ActionListener c) {
		controlador = (ControladorAgregaPokemon) c;
		this.btnAceptar.addActionListener(c);
		this.btnAgregarOtro.addActionListener(c);
	}

	@Override
	public String getNombrePokemon() {
		return this.textNombre.getText();
	}
	
	@Override
	public String getTipoPokemon() {
		return this.buttonGroupTipo.getSelection().getActionCommand();
	}
	
	@Override
	public String getElementoPokemon() {
		return this.buttonGroupElemento.getSelection().getActionCommand();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String nombrePokemon = null;

		nombrePokemon = this.textNombre.getText();

		this.nombreOk = (nombrePokemon != null) && (!nombrePokemon.isEmpty());
		if (this.nombreOk && this.elementoOk && this.tipoOk) {
			this.btnAceptar.setEnabled(true);
			this.btnAgregarOtro.setEnabled(true);
		}
		else {
			this.btnAceptar.setEnabled(false);
			this.btnAceptar.setEnabled(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object o = e.getSource();
		JRadioButton btn = (JRadioButton) o;

		if (btn.getActionCommand().contentEquals(IVistaAgregaPokemon.POKEMON_COMUN)
				|| btn.getActionCommand().contentEquals(IVistaAgregaPokemon.POKEMON_LEGENDARIO))
			this.tipoOk = true;
		else //Estoy seguro que los otros radio button son de un elemento
			this.elementoOk = true;

		if (this.nombreOk && this.elementoOk && this.tipoOk) {
			this.btnAceptar.setEnabled(true);
			this.btnAgregarOtro.setEnabled(true);
		}
		else {
			this.btnAceptar.setEnabled(false);
			this.btnAgregarOtro.setEnabled(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
