package Modelo;

public final class PokemonFuego extends PokemonDecorator {
    public PokemonFuego(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 530;
        this.escudo = 200;
        this.fuerza = 80;
    }
}
