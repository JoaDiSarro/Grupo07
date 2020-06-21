package vista.interfacesVista;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JList;

import modeloClases.Entrenador;
import modeloClases.Pokemon;

public interface IVistaRegistroParticipantes extends IVista{
	
    static final String AGREGAR_ENTRENADOR = "AgregarEntrenador";
    static final String CLONA_ENTRENADOR = "ClonaEntrenador";
    static final String AGREGAR_POKEMON = "AgregarPokemon";
    static final String CLONA_POKEMON = "ClonaPokemon";
    static final String INICIAR_TORNEO = "IniciarTorneo";
    static final String SELECCIONA_ENTRENADOR = "SeleccionaEntrenador";
    
    public int getCantidadParticipantes();
    public void actualizarListaEntrenadores(Iterator<Entrenador> it);
    public void actualizarListaPokemones(Iterator<Pokemon> it);
    public Entrenador getEntrenadorActual();
    public Pokemon getPokemonActual();
}
