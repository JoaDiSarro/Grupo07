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
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento hielo recargado.
     * @param pokemon : Pokemon al que se lo decora con el elemento hielo recargado.
     */
    public PokemonHieloRecargado(Pokemon pokemon) {
        super(pokemon);
    }
    
     /**
      * Metodo por el cual el Pokemon de Hielo Recargado realiza una recarga de su fuerza aumentandola a un valor fijo de 400.
      * <b>Post:</b> Su fuerza aumenta a 400.
      */
    @Override
    public void recarga(){
        this.fuerza = 400;
    }
}

