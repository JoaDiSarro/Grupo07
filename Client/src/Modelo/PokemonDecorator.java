package modelo;

public abstract class PokemonDecorator extends Pokemon{
    
    private Pokemon pokemon;
    
    public PokemonDecorator(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
