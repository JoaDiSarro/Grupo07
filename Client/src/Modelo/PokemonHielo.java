package modelo;

public class PokemonHielo extends PokemonDecorator {
    public PokemonHielo(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 500;
        this.escudo = 120;
        this.fuerza = 100;
    }
    
    public void terminaCansancio(){
        this.fuerza = 100;    
    }
    
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;    
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.fuerza*0.90);    
    }
    
    public void recibeDa�o(double da�o){
        double aux = 0;
        if(da�o*0.75 < this.escudo)
            this.escudo -= da�o*0.75;
        else{
            aux = da�o*0.75 - escudo;
            this.escudo = 0;
        }
        
        if((da�o*0.25 + aux) < this.vitalidad)     
            this.vitalidad -= da�o*0.25 + aux;
        //else
            //Reveer que sucede si muere    
    }
}
