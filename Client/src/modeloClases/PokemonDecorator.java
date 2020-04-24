package modeloClases;

 /**
  * @author DiSarro,Joaquina.
  * @version 1.0
  * <br>
  * Clase que se encarga de decorar Pokemones dandoles asi distintos tipos de funcionalidades dependiendo el Elemento que sean.<br>
  * La clase extiende de Pokemon.<br>
  */
public abstract class PokemonDecorator extends Pokemon{
    
    private Pokemon pokemon;

    /**
     * Constructor parametrizado.<br>
     * <b>Post:</b> Se decora un pokemon con un elemento especifico.
     * @param pokemon : se encarga de guardar la referencia a memoria de un Pokemon base.
     */
    public PokemonDecorator(Pokemon pokemon){
        super();
        this.pokemon = pokemon;
    }
}
