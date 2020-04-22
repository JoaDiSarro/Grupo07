package modeloClases;

import interfaces.Hechizable;

public abstract class PokemonDecorator implements Hechizable{
    
    private Hechizable hechizable;
    
    public PokemonDecorator(Hechizable hechizable){
        super();
        this.hechizable = hechizable;
    }
    
    public Hechizable getHechizable() {
    	return this.hechizable;
    }
    
	public String getNombre() {
		return this.hechizable.getNombre();
	}
    
    
}
