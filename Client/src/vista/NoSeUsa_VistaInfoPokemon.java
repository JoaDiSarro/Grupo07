package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class NoSeUsa_VistaInfoPokemon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelInfoPokemon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoSeUsa_VistaInfoPokemon frame = new NoSeUsa_VistaInfoPokemon();
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
	public NoSeUsa_VistaInfoPokemon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 457);
		panelInfoPokemon = new JPanel();
		panelInfoPokemon.setBorder(new TitledBorder(null, "Informaci\u00F3n del Pok\u00E9mon", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(panelInfoPokemon);
		panelInfoPokemon.setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfoPokemon.add(lblNombre);
		
		JLabel lblMuestraNombre = new JLabel("'Sin asignar'");
		lblMuestraNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblMuestraNombre);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblTipo);
		
		JLabel lblMuestraTipo = new JLabel("'Sin asignar'");
		lblMuestraTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblMuestraTipo);
		
		JLabel lblElemento = new JLabel("Elemento:");
		lblElemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblElemento.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfoPokemon.add(lblElemento);
		
		JLabel lblMuestraElemento = new JLabel("'Sin asignar'");
		lblMuestraElemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblMuestraElemento);
		
		JLabel lblVitalidad = new JLabel("Vitalidad:");
		lblVitalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblVitalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblVitalidad);
		
		JLabel lblMuestraVitalidad = new JLabel("'Sin asignar'");
		lblMuestraVitalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblMuestraVitalidad);
		
		JLabel lblEscudo = new JLabel("Escudo:");
		lblEscudo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscudo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblEscudo);
		
		JLabel lblMuestraEscudo = new JLabel("'Sin asignar'");
		lblMuestraEscudo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblMuestraEscudo);
		
		JLabel lblFuerza = new JLabel("Fuerza:");
		lblFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuerza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblFuerza);
		
		JLabel lblMuestraFuerza = new JLabel("'Sin asignar'");
		lblMuestraFuerza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblMuestraFuerza);
		
		JLabel lblClasificacionActual = new JLabel("Clasificaci\u00F3n Actual:");
		lblClasificacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClasificacionActual.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfoPokemon.add(lblClasificacionActual);
		
		JLabel lblMuestraClasificacionActual = new JLabel("'Sin asignar'");
		lblMuestraClasificacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblMuestraClasificacionActual);
		
		JLabel lblExperiencia = new JLabel("Experiencia:");
		lblExperiencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExperiencia.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfoPokemon.add(lblExperiencia);
		
		JLabel lblMuestraExperiencia = new JLabel("'Sin asignar'");
		lblMuestraExperiencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelInfoPokemon.add(lblMuestraExperiencia);
	}

}
