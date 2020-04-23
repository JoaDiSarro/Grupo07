package modeloClases;

import interfaces.Hechizable;

public class PokemonHielo extends PokemonDecorator {
	
	private Pokemon pokemon;

	public PokemonHielo(Hechizable hechizable) {
		super(hechizable);
		
		pokemon = (Pokemon) super.getHechizable();
		pokemon.setFuerza(100);
		pokemon.setEscudo(120);
		pokemon.setVitalidad(500);
		
	}

	public double getFuerza() {
		return super.getHechizable().getFuerza();
	}

	public double getVitalidad() {
		return super.getHechizable().getVitalidad();
	}

	public double getEscudo() {
		return super.getHechizable().getEscudo();
	}

	public void hechizarNiebla() {
		double auxFuerza = pokemon.getFuerza()*0.3;
		
		pokemon.setFuerza(pokemon.getFuerza()*auxFuerza);
		pokemon.setVitalidad(pokemon.getVitalidad()*auxFuerza);
		pokemon.setEscudo(pokemon.getEscudo()*auxFuerza);
	}
	    
	public void hechizarViento() {
		double auxVitalidad = pokemon.getVitalidad();
		double auxEscudo = pokemon.getEscudo();
		
	   	pokemon.setFuerza(pokemon.getFuerza() - auxVitalidad*0.1 - auxEscudo*0.1);
	}
	    
	public void hechizarTormenta() {
		pokemon.setEscudo(pokemon.getEscudo()*0.85);
		pokemon.setVitalidad(pokemon.getVitalidad()*0.85);
	}
	
	public void terminaCansancio() {
		pokemon.setFuerza(100);
	}
	
	public void recarga() {
		pokemon.setFuerza(pokemon.getFuerza()*1.1);
		pokemon.setFuerza(pokemon.getVitalidad()*1.1);
	}
	
	public void golpeFinal(Hechizable hechizable) {
		Pokemon contrincante = (Pokemon) hechizable;
		
		contrincante.recibeDaño(pokemon.getFuerza()*0.9);
	}
	
	/*
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
    
    */
}
