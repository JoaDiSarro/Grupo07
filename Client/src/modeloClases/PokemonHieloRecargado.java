package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase final que extiende de PokemonHielo donde se decora a un Pokemon brindandole las funcionalidades pertenecientes al elemento Hielo Recargado.
 */
public final class PokemonHieloRecargado extends PokemonHielo {
    
    /**
     * Metodo constructor parametrizado<br>
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento hielo recargado.<br>
     * @param pokemon de tipo Pokemon: Pokemon al que se lo decora con el elemento hielo recargado.<br>
     */
    public PokemonHieloRecargado(Pokemon pokemon) {
        super(pokemon);
    }
    
     /**
      * Metodo por el cual el Pokemon de Hielo Recargado realiza una recarga de su fuerza aumentandola a un valor fijo de 400.<br>
      * <b>Post:</b> Su fuerza aumenta a 400.
      */
    @Override
    public void recarga(){
        this.pokemon.fuerza = 400;
    }
    
    /**
     *Sobreescritura del metodo toString para mostrar que el pokémon es de hielo recargado.
     */
    @Override
	public String toString() {
		return super.toString()+" Recargado";
	}
}

