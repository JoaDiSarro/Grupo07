package modeloClases;

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
        pokemon.recibeDaño(this.fuerza*0.90);    
    }
    
    public void recibeDaño(double daño){
        double aux = 0;
        if(daño*0.75 < this.escudo)
            this.escudo -= daño*0.75;
        else{
            aux = daño*0.75 - escudo;
            this.escudo = 0;
        }
        
        if((daño*0.25 + aux) < this.vitalidad)     
            this.vitalidad -= daño*0.25 + aux;
        //else
            //Reveer que sucede si muere    
    }
    
    public void hechizarNiebla() {
    	double auxFuerza = this.fuerza*0.3;
    	
    	this.fuerza-=auxFuerza;
    	this.vitalidad-=auxFuerza;
    	this.escudo-=auxFuerza;
    }
    
    public void hechizarViento() {
    	this.fuerza -= ((this.escudo*0.1) + (this.vitalidad*0.1));
    }
    
    public void hechizarTormenta() {
    	this.vitalidad*=0.85;
    	this.escudo*=0.85;
    }
}
