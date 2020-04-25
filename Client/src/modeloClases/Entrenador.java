package modeloClases;

import java.util.ArrayList;
import java.util.Random;

public class Entrenador {
    private ArrayList<Pokemon> pokemones;
    private ArrayList<ICarta> cartas;
    private int cartasDisponibles;
    private int creditos;
    
    public Entrenador() {
        super();
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
    //metodo obtienePremio me sume creditos
    //agregar actualizaClasificacion  sumar todas las clasificaciones de mis pokemones y si el total > 20 pasa algo, y si es > 30 pasa otra cosa
}
