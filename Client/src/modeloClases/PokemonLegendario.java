package modeloClases;

public class PokemonLegendario extends Pokemon {
	
    public PokemonLegendario(String nombre) {
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

