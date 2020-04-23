package modeloClases;

import interfaces.Hechizable;

public final class PokemonAgua extends PokemonDecorator {
	
	private Pokemon pokemon;

	public PokemonAgua(Hechizable hechizable) {
		super(hechizable);
		
		pokemon = (Pokemon) super.getHechizable();
		pokemon.setFuerza(120);
		pokemon.setEscudo(100);
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
		
		pokemon.setFuerza(pokemon.getFuerza()*0.93);
		pokemon.setVitalidad(pokemon.getVitalidad()*0.93);
		pokemon.setEscudo(pokemon.getEscudo()*0.93);
	}
	    
	public void hechizarViento() {
	   	pokemon.setFuerza(pokemon.getFuerza() - pokemon.getEscudo()*0.5);
	}
	    
	public void hechizarTormenta() {
		pokemon.setEscudo(pokemon.getEscudo()*0.8);
	}
	
	public void terminaCansancio() {
		pokemon.setFuerza(120);
	}
	
	public void recarga() {
		pokemon.setFuerza(pokemon.getFuerza()*1.1);
		pokemon.setFuerza(pokemon.getVitalidad()*1.1);
	}
	
	public void golpeFinal(Hechizable hechizable) {
		Pokemon contrincante = (Pokemon) hechizable;
		
		contrincante.recibeDaño(pokemon.getFuerza());
		pokemon.setFuerza(pokemon.getFuerza()*0.5);
	}
	
	/*
    public PokemonAgua(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 500;
        this.escudo = 100;
        this.fuerza = 120;
    }
    
    public void terminaCansancio(){
        this.fuerza = 120;
    }
    
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza);
        this.fuerza *= 0.5;
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
    	this.escudo*=0.93;
    	this.vitalidad*=0.93;
    	this.fuerza*=0.93;
    }
    
    public void hechizarViento() {
    	this.fuerza-= (this.escudo*0.5);
    }
    
    public void hechizarTormenta() {
    	this.escudo-=this.escudo*0.8;
    }
    
    */
}