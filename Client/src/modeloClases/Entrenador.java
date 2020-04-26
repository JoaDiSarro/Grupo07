package modeloClases;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author DiSarro,Joaquina.<br>
 * @version 1.0<br>
 * <br>
 * Clase que representa un entrenador participante de un torneo pokémon. Esta clase es clasificable y clonable.
 */
public class Entrenador implements IClasificable,Cloneable{
	
    private String nombre;
    private int clasificacionActual = 1;
    private ArrayList<Pokemon> pokemones = new ArrayList<>();;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int cartasDisponibles;
    private int creditos = 0;
    
    
    /**
     * Constructor de la clase Entrenador.<br>
     * <b> Pre : </b> Los parametros deben ser distintos de null y no deben estar vacíos. El parámetro cartasDisponibles debe ser mayor o igual a 0.<br>
     * @param nombre, de tipo String : Representa el nombre del entrenador.
     * @param cartasDisponibles, de tipo int : Representa la cantidad de cartas disponibles que puede usar el entrenador durante el torneo.
     */
    public Entrenador(String nombre, int cartasDisponibles) {
        this.nombre = nombre;
        this.cartasDisponibles = cartasDisponibles;
    }
    
    /**
     *  Método encargado de otorgarle cartas a un entrenador.<br>
     * <b> Pre: </b> El parámetro listaCartas debe ser distinto de null.<br>
     * <b> Post: </b> Se setea la lista de cartas del entrenador.<br>
     * @param listaCartas, de tipo ArrayList<Carta> : Representa la lista de cartas que se le añade al entrenador.
     */
    public void setMazo(ArrayList<Carta> listaCartas) {
    	this.cartas = listaCartas;
    }
    
    /**
     * Método encargado de agregar un objeto de tipo Pokemon a la lista pokemones.<br>
     * <b> Pre: </b> El parámetro de tipo Pokemon debe ser distinto de null.<br>
     * <b> Post: </b> Se agrega un pokemon a la lista.<br>
     * @param pokemon, de tipo Pokemon: Representa el pokemon a añadir en la lista de pokemones.
     */
    public void agregaPokemon(Pokemon pokemon) {
    	this.pokemones.add(pokemon);
    }
    
    public String getNombre() {
		return nombre;
	}

	public int getCartasDisponibles() {
		return cartasDisponibles;
	}

	public int getClasificacionActual() {
		return clasificacionActual;
	}

	public int getCreditos() {
		return creditos;
	}

	//verificar el -1 indice
    /**
     *Método encargado de elegir un pokémon al azar de la lista.<br>
     *<b> Pre: </b> La lista pokemones no debe estar vacía.<br>
     * @return Retorna un pokemon al azar. 
     */
    public Pokemon eligePokemon(){
        int indiceRandom = new Random().nextInt(pokemones.size()-1);
        return pokemones.get(indiceRandom);
    }
    
    
    /**
     * Método que permite a un entrenador utilizar una de sus cartas de manera aleatoria, afectando un objeto IHechizable.<br>
     * <b> Pre: </b> El parámetro pokemon debe ser distinto de null.<br>
     * <b> Post: </b> El IHechizable parámetro será hechizado por una carta y el Entrenador tendrá 1 carta menos para utilizar.<br>
     * @param pokemon, de tipo IHechizable : Representa el objeto a hechizar con una carta.
     */
    public void usarCarta(IHechizable pokemon){
        int randomCarta = new Random().nextInt(cartas.size()-1);
        cartas.get(randomCarta).hechizar(pokemon);
        this.cartasDisponibles--;
        
    }
    
    /**
     * Método encargado de otorgarle créditos al Entrenador cuando gana una batalla.
     */
    public void obtienePremio(){ //recordar añadirlo a batalla
        this.creditos +=1000;
    }

    /**
     *Método encargado de actualizar e incrementar la clasificaciónActual de un entrenador.<br>
     *<b> Pre: </b> La lista de pokemones no debe estar vacía.<br>
     *<b> Post: </b> Puede que el entrenador aumente su clasificacion, mejorando los atributos de sus pokemones.<br>
     */
    @Override
	public void actualizaClasificacion() {
		int auxClasificacion = 0;

		for (Pokemon itPokemones : this.pokemones) 
			auxClasificacion += itPokemones.clasificacionActual;
		
		if (auxClasificacion>25) {
			this.clasificacionActual=3;
			for (Pokemon itPokemones : this.pokemones) 
				itPokemones.fuerza+=100;
		}
		
		else
			if (auxClasificacion>10) {
				this.clasificacionActual=2;
				for (Pokemon itPokemones : this.pokemones) 
					itPokemones.vitalidad+=200;
			}
	}
    
    /**
     *Método encargado de clonar un entrenador.<br>
     *@return Retorna un objeto clonado de tipo Entrenador.<br>
     *@throws CloneNotSupportedException en caso que el entrenador posea un pokémon legendario, los cuales no se pueden clonar.
     */
    @Override
	public Object clone() throws CloneNotSupportedException {
		
		Entrenador entrenadorClonado = null;
		entrenadorClonado = (Entrenador) super.clone();
		
		if (this.cartas.isEmpty()==false) 
			for (Carta itCartas : this.cartas) 
				entrenadorClonado.cartas.add( (Carta) itCartas.clone() );
		
		if (this.pokemones.isEmpty()==false)   
			for (Pokemon itPokemones : this.pokemones) 
				entrenadorClonado.pokemones.add( (Pokemon) itPokemones.clone() );
		
		return entrenadorClonado;
	}
    
    /**
     * Método encargado de eliminar un pokémon de la lista de pokemones del entrenador.
     * <b> Pre: </b> El parámetro pokemon debe ser distinto de null.
     * <b> Post: </b> En caso de existir, se elimina el elemento pokemon de la lista de pokemones.
     * @param pokemon, de tipo Pokemon : Representa el pokémon a eliminar de la lista.
     */
    public void eliminaPokemon(Pokemon pokemon) {
    	if (this.pokemones.contains(pokemon))
    		this.pokemones.remove(pokemon);
    }
}
