package modeloClases;

import interfaces.Hechizable;

public final class PokemonFuego extends PokemonDecorator {
	
	public PokemonFuego(Hechizable hechizable) {
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
		
		auxPokemon.setFuerza(auxPokemon.getFuerza()*0.9);
		auxPokemon.setVitalidad(auxPokemon.getVitalidad()*0.9);
		auxPokemon.setEscudo(auxPokemon.getEscudo()*0.9);
	}
	    
	public void hechizarViento() {
	    Pokemon auxPokemon = (Pokemon) this.getHechizable();
	   	auxPokemon.setFuerza(auxPokemon.getFuerza() - auxPokemon.getVitalidad()*0.1);
	}
	    
	public void hechizarTormenta() {
		Pokemon auxPokemon = (Pokemon) this.getHechizable();
		auxPokemon.setVitalidad(auxPokemon.getVitalidad()*0.6);
	}
	
	/*
	
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
        pokemon.recibeDaño(this.fuerza*1.25);
        this.fuerza = 0;
    }

    public void recibeDaño(double daño){
        double aux = 0;
        if(daño*0.5 < this.escudo)
            this.escudo -= daño*0.5;
        else{
            aux = daño*0.5 - escudo;
            this.escudo = 0;
        }
        if((daño*0.5 + aux) < this.vitalidad)     
            this.vitalidad -= daño*0.5 + aux;
        //else
            //Reveer que sucede si muere
    }
    
    public void hechizarNiebla() {
    	this.escudo*=0.9;
    	this.fuerza*=0.9;
    	this.vitalidad*=0.9;
    }
    
    public void hechizarViento() {
    	this.fuerza-= (this.vitalidad*0.1);
    }
    
    public void hechizarTormenta() {
    	this.vitalidad*=0.6;
    }
    
    */
}
