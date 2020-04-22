package Modelo;

public final class PokemonElectrico extends PokemonDecorator {
    public PokemonElectrico(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 400;
        this.escudo = 70;
        this.fuerza = 200;
    }
}
