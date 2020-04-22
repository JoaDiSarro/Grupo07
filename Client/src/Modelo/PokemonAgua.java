package Modelo;

public final class PokemonAgua extends PokemonDecorator {
    
    public PokemonAgua(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 500;
        this.escudo = 100;
        this.fuerza = 120;
    }
}
