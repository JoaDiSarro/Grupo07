package modelo;

public final class PokemonTierra extends PokemonDecorator {
    public PokemonTierra(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 600;
        this.escudo = 120;
        this.fuerza = 40;
    }
    
    public void terminaCansancio(){
        this.fuerza = 40;    
    }
    
    public void recarga(){
        this.fuerza = 40;    
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza*1.4);
    }
    
    public void recibeDaño(double daño){
        if(daño < this.escudo)
            this.escudo -= daño;
        else if(this.vitalidad > (daño-this.escudo)){
            this.vitalidad = daño - this.escudo;
            this.escudo = 0;
        }//else
            //Reveer que sucede si muere      
    }
}
