package modeloClases;

import interfaces.Hechizable;

public final class PokemonAgua extends PokemonDecorator {

	public PokemonAgua(Hechizable hechizable) {
		super(hechizable);
		
		Pokemon auxPokemon = (Pokemon) this.getHechizable();
		auxPokemon.setFuerza(120);
		auxPokemon.setEscudo(100);
		auxPokemon.setVitalidad(500);
		
	}

	public double getFuerza() {
		return this.getHechizable().getFuerza();
	}

	public double getVitalidad() {
		return this.getHechizable().getVitalidad();
	}

	public double getEscudo() {
		return this.getHechizable().getEscudo();
	}

	public void hechizarNiebla() {
		Pokemon auxPokemon = (Pokemon) this.getHechizable();
		
		auxPokemon.setFuerza(auxPokemon.getFuerza()*0.93);
		auxPokemon.setVitalidad(auxPokemon.getVitalidad()*0.93);
		auxPokemon.setEscudo(auxPokemon.getEscudo()*0.93);
	}
	    
	public void hechizarViento() {
	    Pokemon auxPokemon = (Pokemon) this.getHechizable();
	   	auxPokemon.setFuerza(auxPokemon.getFuerza() - auxPokemon.getEscudo()*0.5);
	}
	    
	public void hechizarTormenta() {
		Pokemon auxPokemon = (Pokemon) this.getHechizable();
		auxPokemon.setEscudo(auxPokemon.getEscudo()*0.8);
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