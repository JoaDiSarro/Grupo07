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
     * <b>Post:</b> Se decora un pokemon con un elemento especifico.<br>
     * @param pokemon de tipo Pokemon : Se encarga de guardar la referencia a memoria de un Pokemon base.<br>
     * @param vitalidad de tipo double : Vitalidad que se le asigna al pokémon.<br>
     * @param fuerza de tipo double : Fuerza que se le asigna al pokémon.<br>
     * @param escudo de tipo double : Escudo que se le asigna al pokémon. <br>
     */    
    public PokemonDecorator(Pokemon pokemon,double vitalidad, double fuerza, double escudo) {
    	this.pokemon=pokemon;
    	this.pokemon.vitalidad=vitalidad;
        this.pokemon.fuerza=fuerza;
        this.pokemon.escudo=escudo;
    	
    }
    
    /**
     *Método encargado de clonar un pokémon de cualquier elemento.
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
    		e.getMessage();
    	}
		return clonElemento;
	}    

	/**
	 *Sobreescritura del método toString.<br>
	 *Muestra los atributos propios del pokemon.
	 */
	@Override
	public String toString() {
		return "Nombre: "+this.pokemon.nombre+" / "+
				"Vitalidad: "+this.pokemon.vitalidad+" / "+
				"Escudo: "+this.pokemon.escudo+" / "+
				"Fuerza: "+this.pokemon.fuerza+" / "+
				"Experiencia: "+this.pokemon.experiencia+" / "+
				"Clasificacion Actual: "+this.pokemon.clasificacionActual;
	}

	public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
    
    public String getNombre(){
        return this.pokemon.getNombre();
    }
    
    public double getFuerza(){
        return this.pokemon.getFuerza();
    }
    
    public double getVitalidad(){
        return this.pokemon.getVitalidad();
    }
    
    public double getEscudo(){
        return this.pokemon.getEscudo();
    }
    
    public int getExperiencia(){
        return this.pokemon.getExperiencia();
    }
    
    public int getClasificacion() {
    	return this.pokemon.getClasificacionActual();
    }
    

}
