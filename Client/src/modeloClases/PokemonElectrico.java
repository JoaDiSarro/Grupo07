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
        pokemon.recibeDa�o(this.fuerza);
        this.fuerza *= 0.9;
    }
    
    public void recibeDa�o(double da�o){
        if(da�o < this.escudo)
            this.escudo -= da�o;
        else if(this.vitalidad > (da�o-this.escudo)){
            this.vitalidad = da�o - this.escudo;
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
