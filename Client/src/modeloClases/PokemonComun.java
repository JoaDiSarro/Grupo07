package modeloClases;

public class PokemonComun extends Pokemon implements Cloneable{
	
    public PokemonComun(String nombre) {
        super(nombre);
    }
    
    public double getFuerza() {
		return super.fuerza;
	}

	public double getVitalidad() {
		return super.vitalidad;
	}

	public double getEscudo() {
		return super.escudo;
	}
	
	public String getNombre() {
		return super.nombre;
	}


	
    
    
}
