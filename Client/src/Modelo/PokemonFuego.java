package modelo;

public final class PokemonFuego extends PokemonDecorator {
    public PokemonFuego(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 530;
        this.escudo = 200;
        this.fuerza = 80;
    }
    
    public void terminaCansancio(){
        this.fuerza = 80;    
    }
    
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;    
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.fuerza*1.25);
        this.fuerza = 0;
    }

    public void recibeDa�o(double da�o){
        double aux = 0;
        if(da�o*0.5 < this.escudo)
            this.escudo -= da�o*0.5;
        else{
            aux = da�o*0.5 - escudo;
            this.escudo = 0;
        }
        if((da�o*0.5 + aux) < this.vitalidad)     
            this.vitalidad -= da�o*0.5 + aux;
        //else
            //Reveer que sucede si muere
    }
}
