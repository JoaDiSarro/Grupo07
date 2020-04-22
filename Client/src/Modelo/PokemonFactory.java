package Modelo;

public final class PokemonFactory {
    public PokemonFactory() {
        super();
    }
    
    public Pokemon creaPokemon(String tipo, String elemento){
        Pokemon pokemonTipo;
        
        if(tipo.equalsIgnoreCase("comun")){
            pokemonTipo = new PokemonComun();
        }else if(tipo.equalsIgnoreCase("legendario")){
            pokemonTipo = new PokemonLegendario();
        }else
            return null;
        
        if(elemento.equalsIgnoreCase("agua"))
          return new PokemonAgua(pokemonTipo);  
        if(elemento.equalsIgnoreCase("hielo"))
          return new PokemonHielo(pokemonTipo);
        if(elemento.equalsIgnoreCase("fuego"))
          return new PokemonFuego(pokemonTipo);
        if(elemento.equalsIgnoreCase("tierra"))
          return new PokemonTierra(pokemonTipo);
        if(elemento.equalsIgnoreCase("electrico"))
          return new PokemonElectrico(pokemonTipo);
        
        return null;
    }
}
