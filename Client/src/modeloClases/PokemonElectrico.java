package modeloClases;

import interfaces.Hechizable;

public final class PokemonElectrico extends PokemonDecorator {
	
	private Pokemon pokemon;

	public PokemonElectrico(Hechizable hechizable) {
		super(hechizable);
		
		pokemon = (Pokemon) super.getHechizable();
		pokemon.setFuerza(200);
		pokemon.setEscudo(70);
		pokemon.setVitalidad(400);
		
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
		
		pokemon.setFuerza(pokemon.getFuerza()*0.85);
		pokemon.setVitalidad(pokemon.getVitalidad()*0.85);
		pokemon.setEscudo(pokemon.getEscudo()*0.85);
	}
	    
	public void hechizarViento() {
	   	pokemon.setFuerza(pokemon.getFuerza() - pokemon.getEscudo()*0.2);
	}
	    
	public void hechizarTormenta() {
		pokemon.setVitalidad(pokemon.getVitalidad()*0.9);
	}
	
	public void terminaCansancio() {
		pokemon.setFuerza(200);
	}
	
	public void recarga() {
		pokemon.setFuerza(pokemon.getFuerza()*1.1);
		pokemon.setFuerza(pokemon.getVitalidad()*1.5);
	}
	
	public void golpeFinal(Hechizable hechizable) {
		Pokemon contrincante = (Pokemon) hechizable;
		
		contrincante.recibeDaño(pokemon.getFuerza());
		pokemon.setFuerza(pokemon.getFuerza()*0.9);
	}
	
	/*
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
    */
}
