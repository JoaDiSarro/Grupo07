package modeloClases;

public final class PokemonElectrico extends PokemonDecorator {
    public PokemonElectrico(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 400;
        this.escudo = 70;
        this.fuerza = 200;
    }
    
    public void terminaCansancio(){
        this.fuerza = 200;
    }
    
    public void recarga(){
        this.vitalidad *=1.5;
        this.fuerza *=1.1;
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza);
        this.fuerza *= 0.9;
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
    
    public void hechizarNiebla() {
    	this.fuerza*=0.85;
    	this.escudo*=0.85;
    	this.vitalidad*=0.85;
    }
    
    public void hechizarViento() {
    	this.fuerza-= (this.escudo*0.2);
    }
    
    public void hechizarTormenta() {
    	this.vitalidad*=0.9;
    }
}
