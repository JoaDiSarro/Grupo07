package modeloClases;

public abstract class PokemonDecorator extends Pokemon{
    
    private Pokemon pokemon;
    
    public PokemonDecorator(Pokemon pokemon){
        super();
        this.pokemon = pokemon;
    }
}
