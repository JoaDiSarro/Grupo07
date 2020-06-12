package vista;

import controlador.ControladorAgregaPokemon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.ActionListener;

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
import javax.swing.JButton;
import java.awt.Font;

import vista.interfacesVista.IVistaAgregaPokemon;

public class VistaAgregaPokemon extends JFrame implements IVistaAgregaPokemon {

	private static final long serialVersionUID = 1L;
	private JPanel panelAgregaPokemon;
	private JTextField textNombre;
        private ControladorAgregaPokemon controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAgregaPokemon frame = new VistaAgregaPokemon();
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
	public VistaAgregaPokemon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 408); //Despues borrar
		panelAgregaPokemon = new JPanel();
		panelAgregaPokemon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Agregar Pokemon", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		fl_panelEnvTextNombre.setVgap(33);
		panelNombre.add(panelEnvTextNombre);
		
		textNombre = new JTextField();
		panelEnvTextNombre.add(textNombre);
		textNombre.setColumns(18);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Seleccionar tipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDatos.add(panelTipo);
		panelTipo.setLayout(new GridLayout(2, 0, 0, 0));
		
		JRadioButton rdbtnComun = new JRadioButton("Com\u00FAn");
		panelTipo.add(rdbtnComun);
		
		JRadioButton rdbtnLegendario = new JRadioButton("Legendario");
		panelTipo.add(rdbtnLegendario);
		
		JPanel panelElemento = new JPanel();
		panelElemento.setBorder(new TitledBorder(null, "Seleccionar elemento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatos.add(panelElemento);
		panelElemento.setLayout(new GridLayout(2, 3, 0, 0));
		
		JRadioButton rdbtnFuego = new JRadioButton("Fuego");
		panelElemento.add(rdbtnFuego);
		
		JRadioButton rdbtnHielo = new JRadioButton("Hielo");
		panelElemento.add(rdbtnHielo);
		
		JRadioButton rdbtnAgua = new JRadioButton("Agua");
		panelElemento.add(rdbtnAgua);
		
		JRadioButton rdbtnTierra = new JRadioButton("Tierra");
		panelElemento.add(rdbtnTierra);
		
		JRadioButton rdbtnHieloRecargado = new JRadioButton("Hielo Recargado");
		panelElemento.add(rdbtnHieloRecargado);
		
		JRadioButton rdbtnElectrico = new JRadioButton("El\u00E9ctrico");
		panelElemento.add(rdbtnElectrico);
		
		JPanel panelBoton = new JPanel();
		panelDatos.add(panelBoton);
		panelBoton.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelEnvAgregaOtro = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEnvAgregaOtro.getLayout();
		flowLayout.setVgap(25);
		panelBoton.add(panelEnvAgregaOtro);
		
		JButton btnAgregarOtro = new JButton("Agregar Otro");
		panelEnvAgregaOtro.add(btnAgregarOtro);
		btnAgregarOtro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelAceptar = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelAceptar.getLayout();
		flowLayout_1.setVgap(25);
		panelBoton.add(panelAceptar);
		
		JButton btnAceptar = new JButton("Aceptar");
		panelAceptar.add(btnAceptar);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	}

    @Override
    public void abrir() {
        setBounds(100, 100, 323, 457);
        setVisible(true);
    }

    @Override
    public void cerrar() {
        setVisible(false);
    }

    @Override
    public void setControlador(ActionListener c) {
        controlador = (ControladorAgregaPokemon) c;
        
    }

    @Override
    public void muestraMensajeAlerta(String mensaje) {
        // TODO Implement this method
    }
}
