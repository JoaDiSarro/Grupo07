package modeloClases;

 /**
  * @author DiSarro,Joaquina.
  * @version 1.0
  * <br>
  * Clase que se encarga de decorar Pokemones dandoles asi distintos tipos de funcionalidades dependiendo el Elemento que sean.<br>
  * La clase extiende de Pokemon.<br>
  */
public abstract class PokemonDecorator extends Pokemon implements Cloneable{
    
    protected Pokemon pokemon;

    /**
     * Constructor parametrizado.<br>
     * <b>Pre:</b> El parametro pokemon debe ser distinto de null. Ademas, vitalidad, fuerza y escudo deben ser distinto de null y mayores a 0.<br>
     * <b>Post:</b> Se decora un pokemon con un elemento especifico.<br>
     * @param pokemon  de tipo Pokemon : Se encarga de guardar la referencia a memoria de un Pokemon base.<br>
     * @param vitalidad  de tipo double : Vitalidad que se le asigna al pokémon.<br>
     * @param fuerza  de tipo double : Fuerza que se le asigna al pokémon.<br>
     * @param escudo  de tipo double : Escudo que se le asigna al pokémon. <br>
     */    
    public PokemonDecorator(Pokemon pokemon,double vitalidad, double fuerza, double escudo) {
    	super(pokemon.getNombre(), vitalidad, fuerza, escudo);
        this.pokemon = pokemon;
    }
    
    /**
     *Método encargado de clonar un pokémon de cualquier elemento.
     * <b>Post:</b> Se clona el objeto.<br>
     */
    @Override
	public Object clone() {
    	PokemonDecorator clonElemento=null;
    	
    	try {
    		Pokemon pokemonAux = (Pokemon) pokemon.clone();
    		clonElemento = (PokemonDecorator) super.clone();
    		clonElemento.setPokemon(pokemonAux);
    	}
    	catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
    	}
		return clonElemento;
	}    

	/**
	 *Sobreescritura del método toString.<br>
	 *Muestra los atributos propios del pokemon.
	 */
	@Override
	public String toString() {
		return "Nombre: "+this.nombre+" / "+
				"Vitalidad: "+this.vitalidad+" / "+
				"Escudo: "+this.escudo+" / "+
				"Fuerza: "+this.fuerza+" / "+
				"Experiencia: "+this.experiencia+" / "+
				"Clasificacion Actual: "+this.clasificacionActual;
	}

	public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
    
    public int getClasificacion() {
    	return this.getClasificacionActual();
    }

}
