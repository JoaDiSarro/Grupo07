package modelo;

public final class PokemonHieloRecargado extends PokemonHielo {
    public PokemonHieloRecargado(Pokemon pokemon) {
        super(pokemon);
    }
    
    public void recarga(){
        this.fuerza = 400;
    }
}
