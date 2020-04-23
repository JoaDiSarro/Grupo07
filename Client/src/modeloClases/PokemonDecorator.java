package modeloClases;

public abstract class PokemonDecorator extends Pokemon{
    
    private Pokemon pokemon;
    
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
    
    public String getNombre(){
        return this.pokemon.getNombre();
    }
}
