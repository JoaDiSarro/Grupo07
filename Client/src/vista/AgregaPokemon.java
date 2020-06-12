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

public class AgregaPokemon extends JFrame implements IVistaAgregaPokemon {

	private JPanel panelAgregaPokemon;
	private JTextField textNombre;
        private ControladorAgregaPokemon controlador;

	/**
	 * Create the frame.
	 */
	public AgregaPokemon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		fl_panelEnvTextNombre.setVgap(38);
		panelNombre.add(panelEnvTextNombre);
		
		textNombre = new JTextField();
		panelEnvTextNombre.add(textNombre);
		textNombre.setColumns(12);
		
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
		panelElemento.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollElemento = new JScrollPane();
		panelElemento.add(scrollElemento);
		
		JList listElementos = new JList();
		scrollElemento.setViewportView(listElementos);
		
		JPanel panelBoton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBoton.getLayout();
		flowLayout.setVgap(25);
		panelDatos.add(panelBoton);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelBoton.add(btnAceptar);
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
