package vista.interfacesVista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public interface IVistaAgregaPokemon extends IVista{
	
	static final String AGREGAR_POKEMON = "Aceptar";
	static final String AGREGAR_OTRO = "Agregar Otro";
	static final String POKEMON_AGUA = "Agua";
	static final String POKEMON_TIERRA = "Tierra";
	static final String POKEMON_HIELO = "Hielo";
	static final String POKEMON_ELECTRICO= "Electrico";
	static final String POKEMON_HIELO_RECARGADO = "Hielo Recargado";
	static final String POKEMON_FUEGO = "Fuego";
	static final String POKEMON_COMUN = "Comun";
	static final String POKEMON_LEGENDARIO = "Legendario";
	
	String getNombrePokemon();
	String getTipoPokemon();
	String getElementoPokemon();
    
}
