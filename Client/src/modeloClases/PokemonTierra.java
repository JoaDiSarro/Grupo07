package modeloClases;

import interfaces.Hechizable;

public final class PokemonTierra extends PokemonDecorator {
    
	private Pokemon pokemon;

	public PokemonTierra(Hechizable hechizable) {
		super(hechizable);
		
		pokemon = (Pokemon) super.getHechizable();
		pokemon.setFuerza(40);
		pokemon.setEscudo(120);
		pokemon.setVitalidad(600);
		
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
		double auxVitalidad = pokemon.getVitalidad()*0.2;
		
		pokemon.setFuerza(pokemon.getFuerza()-auxVitalidad);
		pokemon.setVitalidad(pokemon.getVitalidad()-auxVitalidad);
		pokemon.setEscudo(pokemon.getEscudo()-auxVitalidad);
	}
	    
	public void hechizarViento() {
	   	pokemon.setFuerza(pokemon.getFuerza()*0.8);
	}
	    
	public void hechizarTormenta() {
		pokemon.setVitalidad(pokemon.getVitalidad()- pokemon.getEscudo());
	}
	
	public void terminaCansancio() {
		pokemon.setFuerza(40);
	}
	
	public void recarga() {
		pokemon.setFuerza(40);
	}
	
	public void golpeFinal(Hechizable hechizable) {
		Pokemon contrincante = (Pokemon) hechizable;
		
		contrincante.recibeDaño(pokemon.getFuerza());
		pokemon.setFuerza(pokemon.getFuerza()*1.4);
	}
	
	/*
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
    
    public void hechizarNiebla() {
    	double auxVitalidad = this.vitalidad*0.2;
    	this.vitalidad-=auxVitalidad;
    	this.escudo-=auxVitalidad;
    	this.fuerza-=auxVitalidad;
    }
    
    public void hechizarViento() {
    	this.fuerza*=0.8;
    }
    
    public void hechizarTormenta() {
    	this.vitalidad-=this.escudo;
    }
    */
}
