package modeloClases;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 */
public class Entrenador implements IClasificable{
	
    private String nombre;
    private int clasificacionActual = 1;
    private ArrayList<Pokemon> pokemones = new ArrayList<>();;
    private ArrayList<Carta> cartas = new ArrayList<>();
    private int cartasDisponibles;
    private int creditos = 0;
    
    
    public Entrenador(String nombre, int cartasDisponibles) {
        this.nombre = nombre;
        this.cartasDisponibles = cartasDisponibles;
    }
    
    public void setMazo(ArrayList<Carta> listaCartas) {
    	this.cartas = listaCartas;
    }
    
    public void agregaPokemon(Pokemon pokemon) {
    	this.pokemones.add(pokemon);
    }
    
    
    
    public String getNombre() {
		return nombre;
	}

	public int getCartasDisponibles() {
		return cartasDisponibles;
	}

	//verificar el -1 indice
    public Pokemon eligePokemon(){
        int indiceRandom = new Random().nextInt(pokemones.size()-1);
        return pokemones.get(indiceRandom);
    }
    
    
    public void usarCarta(IHechizable pokemon){
        int randomCarta = new Random().nextInt(cartas.size()-1);
        cartas.get(randomCarta).hechizar(pokemon);
        this.cartasDisponibles--;
        
    }
    
    
    public void obtienePremio(){
        this.creditos +=1000;
    }

    @Override
	public void actualizaClasificacion() {
		
	}
    
    
    //agregar actualizaClasificacion  sumar todas las clasificaciones de mis pokemones y si el total > 20 pasa algo, y si es > 30 pasa otra cosa
    
    
}
