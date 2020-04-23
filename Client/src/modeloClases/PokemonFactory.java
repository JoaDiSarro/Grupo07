package modeloClases;

import interfaces.Hechizable;

public final class PokemonFactory {
    public PokemonFactory() {
        super();
    }
    
    public Hechizable creaPokemon(String nombre, String tipo, String elemento){
        Hechizable pokemonTipo;
        
        if(tipo.equalsIgnoreCase("comun")){
            pokemonTipo = new PokemonComun(nombre);
        }else if(tipo.equalsIgnoreCase("legendario")){
            pokemonTipo = new PokemonLegendario(nombre);
        }else
            return null;
        
        if(elemento.equalsIgnoreCase("agua"))
            return new PokemonAgua(pokemonTipo);  
        else if(elemento.equalsIgnoreCase("hielo"))
            return new PokemonHielo(pokemonTipo);
        //if(elemento.equalsIgnoreCase("hielo recargado"))
        //    return new PokemonHieloRecargado(pokemonTipo);
        else if(elemento.equalsIgnoreCase("fuego"))
            return new PokemonFuego(pokemonTipo);
        else if(elemento.equalsIgnoreCase("tierra"))
            return new PokemonTierra(pokemonTipo);
        else if(elemento.equalsIgnoreCase("electrico"))
            return new PokemonElectrico(pokemonTipo);
        
        return null;
    }
}
