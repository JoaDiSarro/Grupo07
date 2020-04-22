package Modelo;

public final class PokemonHielo extends PokemonDecorator {
    public PokemonHielo(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 500;
        this.escudo = 120;
        this.fuerza = 100;
    }
}
