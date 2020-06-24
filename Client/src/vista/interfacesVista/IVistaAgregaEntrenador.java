package vista.interfacesVista;

import java.util.Iterator;

import javax.swing.JButton;

import modeloClases.Pokemon;

public interface IVistaAgregaEntrenador extends IVista {
	
    static final String AGREGAR_OTRO_POKEMON = "AgregarPokemon";
    static final String ACEPTAR = "Aceptar";
    
    public String getNombreEntrenador();
    public int getCantidadDeCartas();
    public void actualizarListaPokemones(Iterator<Pokemon> it);
}
