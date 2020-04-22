package modelo;

public final class PokemonFactory {
    public PokemonFactory() {
        super();
    }
    
    public Pokemon creaPokemon(String nombre, String tipo, String elemento){
        Pokemon pokemonTipo;
        
        if(tipo.equalsIgnoreCase("comun")){
            pokemonTipo = new PokemonComun(nombre);
        }else if(tipo.equalsIgnoreCase("legendario")){
            pokemonTipo = new PokemonLegendario(nombre);
        }else
            return null;
        
        if(elemento.equalsIgnoreCase("agua"))
            return new PokemonAgua(pokemonTipo);  
        if(elemento.equalsIgnoreCase("hielo"))
            return new PokemonHielo(pokemonTipo);
        if(elemento.equalsIgnoreCase("hielo recargado"))
            return new PokemonHieloRecargado(pokemonTipo);
        if(elemento.equalsIgnoreCase("fuego"))
            return new PokemonFuego(pokemonTipo);
        if(elemento.equalsIgnoreCase("tierra"))
            return new PokemonTierra(pokemonTipo);
        if(elemento.equalsIgnoreCase("electrico"))
            return new PokemonElectrico(pokemonTipo);
        
        return null;
    }
}
