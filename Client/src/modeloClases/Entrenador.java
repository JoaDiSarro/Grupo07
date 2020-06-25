package modeloClases;

import exceptions.SinCartasDisponiblesException;

import interfaces.IClasificable;

import interfaces.IHechizable;
import vista.interfacesVista.IVistaRegistroParticipantes;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 * @author DiSarro,Joaquina.<br>
 * @version 1.0<br>
 *          <br>
 *          Clase que representa un entrenador participante de un torneo
 *          pokémon. Esta clase es clasificable y clonable.
 */

public class Entrenador extends Observable implements IClasificable,Cloneable, Serializable {
	
    private String nombre;
    private int clasificacionActual = 1;
    private ArrayList<Pokemon> pokemones = new ArrayList<>();;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int cartasDisponibles;
    private int creditos = 0;
    
    
    /**
     * Constructor de la clase Entrenador.<br>
     * <b> Pre : </b> Los parametros deben ser distintos de null y no deben estar vacíos. El parámetro cartasDisponibles debe ser mayor o igual a 0.<br>
     * @param nombre  de tipo String : Representa el nombre del entrenador.<br>
     * @param cartasDisponibles  de tipo int : Representa la cantidad de cartas disponibles que puede usar el entrenador durante el torneo.
     */
    public Entrenador(String nombre, int cartasDisponibles) {
        this.nombre = nombre;
        this.cartasDisponibles = cartasDisponibles;
    }
    
    /**
     *  Método encargado de otorgarle cartas a un entrenador.<br>
     * <b> Pre: </b> El parámetro listaCartas debe ser distinto de null.<br>
     * <b> Post: </b> Se setea la lista de cartas del entrenador.<br>
     * @param listaCartas  de tipo ArrayList<Carta> : Representa la lista de cartas que se le añade al entrenador.
     */
    public void setMazo(ArrayList<Carta> listaCartas) {
    	this.cartas = listaCartas;
    }
    
    /**
     * Método encargado de agregar un objeto de tipo Pokemon a la lista pokemones.<br>
     * <b> Pre: </b> El parámetro de tipo Pokemon debe ser distinto de null.<br>
     * <b> Post: </b> Se agrega un pokemon a la lista.<br>
     * @param pokemon  de tipo Pokemon: Representa el pokemon a añadir en la lista de pokemones.
     */
    public void agregaPokemon(Pokemon pokemon) {
    	this.pokemones.add(pokemon);
		this.setChanged();
		this.notifyObservers(IVistaRegistroParticipantes.AGREGAR_POKEMON);
    }
    
    public ArrayList<Pokemon> getPokemones() {
            return pokemones;
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

    /**
     *Método encargado de elegir un pokémon al azar de la lista.<br>
     *<b> Pre: </b> La lista pokemones no debe estar vacía.<br>
     * @return Retorna un pokemon al azar. 
     */
    public Pokemon eligePokemon(){
        int indiceRandom = new Random().nextInt(pokemones.size());
        return pokemones.get(indiceRandom);
    }
    
    
    /**
     * Método que permite a un entrenador utilizar una de sus cartas de manera aleatoria, afectando un objeto IHechizable.<br>
     * <b> Pre: </b> El parámetro pokemon debe ser distinto de null.<br>
     * <b> Post: </b> El IHechizable parámetro será hechizado por una carta y el Entrenador tendrá 1 carta menos para utilizar.<br>
     * @param pokemon  de tipo IHechizable : Representa el objeto a hechizar con una carta.
     */
    public void usarCarta(IHechizable pokemon){
        int randomCarta = new Random().nextInt(cartas.size());
        cartas.get(randomCarta).hechizar(pokemon);
        this.cartasDisponibles--;
        
    }
    
    /**
     * Método encargado de otorgarle créditos al Entrenador cuando gana una batalla.
     * <b>Post:</b> se aumentan los creditos del Entrenador en 1000.<br>
     */
    public void obtienePremio(){
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
			auxClasificacion += itPokemones.getClasificacionActual();

		if (auxClasificacion > 20) {
			this.clasificacionActual = 3;
			for (Pokemon itPokemones : this.pokemones)
				itPokemones.setFuerza(itPokemones.getFuerza() + 100);
		}

		else if (auxClasificacion > 10) {
			this.clasificacionActual = 2;
			for (Pokemon itPokemones : this.pokemones)
				itPokemones.setVitalidad(itPokemones.getVitalidad() + 200);
		}
	}

	/**
	 * Método encargado de clonar un entrenador.<br>
	 * 
	 * @return Retorna un objeto clonado de tipo Entrenador.<br>
	 * @throws CloneNotSupportedException en caso que el entrenador posea un pokémon
	 *                                    legendario, los cuales no se pueden
	 *                                    clonar.<br>
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {

		Entrenador entrenadorClonado = null;
		entrenadorClonado = (Entrenador) super.clone();
		ArrayList<Carta> cartasClon = new ArrayList<>();
		ArrayList<Pokemon> pokemonClon = new ArrayList<>();

		if (this.cartas.isEmpty() == false)
			for (Carta itCartas : this.cartas)
				cartasClon.add((Carta) itCartas.clone());
		entrenadorClonado.setMazo(cartasClon);

		if (this.pokemones.isEmpty() == false)
			for (Pokemon itPokemones : this.pokemones)
				pokemonClon.add((Pokemon) itPokemones.clone());
		entrenadorClonado.setPokemones(pokemonClon);

		return entrenadorClonado;
	}

    public void setPokemones(ArrayList<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }

    /**
     * Método encargado de eliminar un pokémon de la lista de pokemones del entrenador.<br>
     * <b> Pre: </b> El parámetro pokemon debe ser distinto de null.<br>
     * <b> Post: </b> En caso de existir, se elimina el elemento pokemon de la lista de pokemones.<br>
     * @param pokemon  de tipo Pokemon : Representa el pokémon a eliminar de la lista.
     */
    public void eliminaPokemon(Pokemon pokemon) {
    	if (this.pokemones.contains(pokemon))
    		this.pokemones.remove(pokemon);
    }

    /**
     * Metodo por el cual un Entrenador verifica si tiene cartas disponibles para utilizar.<br>
     * @return true en caso de poder utilizar una carta.<br>
     */
    public boolean decideUtilizarCarta(){
        return cartasDisponibles > 0 ? new Random().nextBoolean() : false;
    }

	/**
	 * Sobreescritura del metodo toString. Se utiliza para mostrar los atributos de
	 * un entrenador.
	 */
	@Override
	public String toString() {
		return "Nombre: " + nombre + " | Cartas Disponibles: " + this.cartasDisponibles + " | ClasificacionActual: "
				+ clasificacionActual + " | Creditos: " + creditos + "\n";
	}

}
