package modeloClases;

import interfaces.Hechizable;

public final class PokemonFuego extends PokemonDecorator {
	
	private Pokemon pokemon;

	public PokemonFuego(Hechizable hechizable) {
		super(hechizable);
		
		pokemon = (Pokemon) super.getHechizable();
		pokemon.setFuerza(80);
		pokemon.setEscudo(200);
		pokemon.setVitalidad(530);
		
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
		
		pokemon.setFuerza(pokemon.getFuerza()*0.9);
		pokemon.setVitalidad(pokemon.getVitalidad()*0.9);
		pokemon.setEscudo(pokemon.getEscudo()*0.9);
	}
	    
	public void hechizarViento() {
	   	pokemon.setFuerza(pokemon.getFuerza() - pokemon.getVitalidad()*0.1);
	}
	    
	public void hechizarTormenta() {
		pokemon.setEscudo(pokemon.getVitalidad()*0.6);
	}
	
	public void terminaCansancio() {
		pokemon.setFuerza(80);
	}
	
	public void recarga() {
		pokemon.setFuerza(pokemon.getFuerza()*1.1);
		pokemon.setFuerza(pokemon.getVitalidad()*1.1);
	}
	
	public void golpeFinal(Hechizable hechizable) {
		Pokemon contrincante = (Pokemon) hechizable;
		
		contrincante.recibeDaño(pokemon.getFuerza()*1.25);
		pokemon.setFuerza(0);
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
