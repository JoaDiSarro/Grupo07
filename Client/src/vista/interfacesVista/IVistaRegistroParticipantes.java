package vista.interfacesVista;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import modeloClases.Entrenador;
import modeloClases.Pokemon;

public interface IVistaRegistroParticipantes extends IVista{
	
    static final String AGREGAR_ENTRENADOR = "AgregarEntrenador";
    static final String CLONA_ENTRENADOR = "ClonaEntrenador";
    static final String AGREGAR_POKEMON = "AgregarPokemon";
    static final String CLONA_POKEMON = "ClonaPokemon";
    static final String INICIAR_TORNEO = "IniciarTorneo";
    static final String SELECCIONA_ENTRENADOR = "SeleccionaEntrenador";
    static final String FIN_TORNEO = "Fin";
    static final String FIN_RONDA = "Fin Ronda";
    
    public int getCantidadParticipantes();
    public void actualizarListaEntrenadores(Iterator<Entrenador> it);
    public void actualizarListaPokemones(Iterator<Pokemon> it);
    public Entrenador getEntrenadorActual();
    public Pokemon getPokemonActual();
    public void setResultado(String ganador);
    public void deshabilitaBotonTorneo();
    
    public static void muestraMensajeAlerta(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
