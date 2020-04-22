package modeloClases;

import interfaces.Hechizable;

public abstract class Pokemon implements Hechizable{
	
    protected String nombre;
    protected double vitalidad;
    protected double escudo;
    protected double fuerza;
    protected int experiencia;
    
    public Pokemon(){}
    
    public Pokemon(String nombre){
        this.nombre = nombre;
        this.experiencia = 0;
    }
    
    public String getNombre() {
		return nombre;
	}

	public double getVitalidad() {
		return vitalidad;
	}

	public double getEscudo() {
		return escudo;
	}

	public double getFuerza() {
		return fuerza;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setFuerza(double fuerza) {
    	this.fuerza=fuerza;
    }
    
    public void setEscudo(double escudo) {
    	this.escudo=escudo;
    }
    
    public void setVitalidad(double vitalidad) {
    	this.vitalidad=vitalidad;
    }
    
    public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public void ataca(Pokemon pokemon){
        golpeInicial(pokemon);
        recarga();
        golpeFinal(pokemon);
    }
    
    public void golpeInicial(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza);
        //se cansa
        this.fuerza *= 0.5;
    }
    
    //estos metodos son para poder utilizar el gancho con cada elemento
    
    public void terminaCansancio(){}
    
    public void recarga(){}
    
    public void golpeFinal(Pokemon pokemon){}
    
    //Evaluar que sucede si el pokemon muere
    
    public void recibeDaño(double daño){}
    
    
    
}
