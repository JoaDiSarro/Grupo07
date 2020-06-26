package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0 <br>
 *          Clase que se encarga de generar un Pokemon dependiendo de los
 *          parametros de entrada.<br>
 *          Se especifica el tipo de Pokemon a crear: Comun o Legendario.<br>
 *          Se especifica el nombre que se le quiere asignar al pokemon.<br>
 *          Se especifica el elemento al que el Pokemon pertenece: Hielo, Hielo
 *          Recargado, Agua, Fuego, Tierra o Electrico.<br>
 */
public final class PokemonFactory {
	/**
	 * Metodo Constructor por defecto.<br>
	 */
	public PokemonFactory() {
		super();
	}

	/**
	 * Metodo que crea un pokemon dependiendo de los parametros de entrada.<br>
	 * Se debe de ingresar el nombre, el tipo (Comun o Legendario) y el elemento
	 * (Hielo, Hielo Recargado, Agua, Fuego, Tierra o Electrico). En caso contrario,
	 * devolvera un null.<br>
	 * <b>Pre:</b> Los parametros nombre,tipo y elemento deben ser distintos de null
	 * y de vacio.<br>
	 * <b>Post:</b> Se genera un Pokemon con su respectivo nombre, tipo y elemento.
	 * En caso que alguno de los parametros de entrada sean incorrectos, se
	 * devolvera un null.<br>
	 * 
	 * @param nombre   de tipo String: Nombre que se le asiganara al Pokemon.<br>
	 * @param tipo     de tipo String: Puede ser Comun o Legendario.<br>
	 * @param elemento de tipo String: Puede ser Hielo, Hielo Recargado, Agua,
	 *                 Fuego, Tierra o Electrico<br>
	 * @return Devuelve un Pokemon.
	 */
	public Pokemon creaPokemon(String nombre, String tipo, String elemento) {
		Pokemon pokemonTipo;

		if (tipo.equalsIgnoreCase("comun")) {
			pokemonTipo = new PokemonComun(nombre);
		} else if (tipo.equalsIgnoreCase("legendario")) {
			pokemonTipo = new PokemonLegendario(nombre);
		} else
			return null;

		if (elemento.equalsIgnoreCase("agua"))
			return new PokemonAgua(pokemonTipo);
		if (elemento.equalsIgnoreCase("hielo"))
			return new PokemonHielo(pokemonTipo);
		if (elemento.equalsIgnoreCase("hielo recargado"))
			return new PokemonHieloRecargado(pokemonTipo);
		if (elemento.equalsIgnoreCase("fuego"))
			return new PokemonFuego(pokemonTipo);
		if (elemento.equalsIgnoreCase("tierra"))
			return new PokemonTierra(pokemonTipo);
		if (elemento.equalsIgnoreCase("electrico"))
			return new PokemonElectrico(pokemonTipo);

		return null;
	}
}
