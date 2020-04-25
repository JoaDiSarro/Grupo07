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
    private int clasificacionActual;
    private ArrayList<Pokemon> pokemones;
    private ArrayList<ICarta> cartas;
    private int cartasDisponibles;
    private int creditos;
    
    public Entrenador(String nombre, int cartasDisponibles) {
        this.nombre = nombre;
        this.clasificacionActual = 1;
        pokemones = new ArrayList<>();
        cartas = new ArrayList<>();
        this.cartasDisponibles = cartasDisponibles;
        this.creditos = 0;
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
    //agregar actualizaClasificacion  sumar todas las clasificaciones de mis pokemones y si el total > 20 pasa algo, y si es > 30 pasa otra cosa
    @Override
    public void actualizaClasificacion() {
        // TODO Implement this method
    }
}
