package vista;

import controlador.ControladorRegistroDeParticipantes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.event.ActionListener;

import vista.interfacesVista.IVistaRegistroParticipantes;

public class RegistroDeParticipantes extends JFrame implements IVistaRegistroParticipantes {


	private static final long serialVersionUID = 1L;
	private JPanel panelGeneral;
        private ControladorRegistroDeParticipantes controlador;
        private JButton btnAgregarEntrenador = new JButton("Agregar Entrenador");
        private JButton btnClonaEntrenador = new JButton("Clonar Entrenador");
        private JButton btnAgregarPokemon = new JButton("Agregar Pokemon");
        private JButton btnClonaPokemon = new JButton("Clonar Pokemon");
        private JButton btnIniciarTorneo = new JButton("INICIO DEL TORNEO");
  
  //TODO: cambiar estos main, solo deberia de haber un main en Prueba, donde llame a la ejecucion a la ventana principal. No en cada ui un main.
        
/*
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroDeParticipantes frame = new RegistroDeParticipantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public RegistroDeParticipantes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelGeneral = new JPanel();
		panelGeneral.setBorder(new TitledBorder(null, "Registro de Participantes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(panelGeneral);
		GridBagLayout gbl_panelGeneral = new GridBagLayout();
		gbl_panelGeneral.columnWidths = new int[]{503, 0};
		gbl_panelGeneral.rowHeights = new int[]{481, 238, 0};
		gbl_panelGeneral.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelGeneral.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
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
		panelEntrenadores.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Entrenadores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 1, true)));
		panelListas.add(panelEntrenadores);
		panelEntrenadores.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollListaEntrenadores = new JScrollPane();
		panelEntrenadores.add(scrollListaEntrenadores, BorderLayout.CENTER);
		
		JList listEntrenadores = new JList();
		scrollListaEntrenadores.setViewportView(listEntrenadores);
		
		JPanel panelPokemones = new JPanel();
		panelPokemones.setBorder(new CompoundBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pokemones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 1, true)));
		panelListas.add(panelPokemones);
		panelPokemones.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollListaPokemones = new JScrollPane();
		panelPokemones.add(scrollListaPokemones, BorderLayout.CENTER);
		
		JList listPokemones = new JList();
		scrollListaPokemones.setViewportView(listPokemones);
		
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
		
		//AgregarEntrenador
		panelEnvAgregaEntrenador.add(btnAgregarEntrenador);
                btnAgregarEntrenador.setActionCommand(AGREGARENTRENADOR);
		
		JPanel panelEnvClonaEntrenador = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEnvClonaEntrenador.getLayout();
		flowLayout.setVgap(25);
		panelAgregaObjetos.add(panelEnvClonaEntrenador);
		
		//ClonaEntrenador
		panelEnvClonaEntrenador.add(btnClonaEntrenador);
                btnClonaEntrenador.setActionCommand(CLONAENTRENADOR);
		
		JPanel panelEnvAgregaPokemon = new JPanel();
		panelAgregaObjetos.add(panelEnvAgregaPokemon);
		
                //AgregarPokemon
		panelEnvAgregaPokemon.add(btnAgregarPokemon);
                btnAgregarPokemon.setActionCommand(AGREGARPOKEMON);
		
		JPanel panelEnvClonaPokemon = new JPanel();
		panelAgregaObjetos.add(panelEnvClonaPokemon);
		
		//ClonaPokemon
		panelEnvClonaPokemon.add(btnClonaPokemon);
                btnClonaPokemon.setActionCommand(CLONAPOKEMON);
		
		JPanel panelInicioTorneo = new JPanel();
		panelBotones.add(panelInicioTorneo);
		panelInicioTorneo.setLayout(new GridLayout(2, 0, 0, 0));
		
		//IniciarTorneo
		btnIniciarTorneo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelInicioTorneo.add(btnIniciarTorneo);
                btnIniciarTorneo.setActionCommand(INICIARTORNEO);
		
		JPanel panelEnvRestriccionTorneo = new JPanel();
		panelEnvRestriccionTorneo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		panelInicioTorneo.add(panelEnvRestriccionTorneo);
		panelEnvRestriccionTorneo.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollRestriccionTorneo = new JScrollPane();
		panelEnvRestriccionTorneo.add(scrollRestriccionTorneo);
		
		JLabel lblRestriccionTorneo = new JLabel(" Se requieren 16 entrenadores con al menos 5 pokemones cada uno para comenzar el torneo ");
		lblRestriccionTorneo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRestriccionTorneo.setHorizontalAlignment(SwingConstants.CENTER);
		scrollRestriccionTorneo.setViewportView(lblRestriccionTorneo);
	}

    public void setControlador(ActionListener c){
        controlador = (ControladorRegistroDeParticipantes) c;
        btnAgregarEntrenador.addActionListener(c);
        btnClonaEntrenador.addActionListener(c);
        btnAgregarPokemon.addActionListener(c);
        btnClonaPokemon.addActionListener(c);
        btnIniciarTorneo.addActionListener(c);
    }
    
    @Override
    public void abrir(){
        setBounds(100, 100, 634, 588);
        setVisible(true);
    }

    @Override
    public void cerrar() {
        setVisible(false);
    }

    @Override
    public void muestraMensajeAlerta(String mensaje) {
        // TODO Implement this method
    }
}
