package modeloClases;

import exceptions.SinCartasDisponiblesException;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase que representa una batalla en un torneo pokemon.<br>
 * Se encarga de hacer batallar objetos de tipo Entrenador.
 */
public class Batalla extends Observable implements Runnable{
	
    private final int maxAtaques = 3;
    private Entrenador entrenadorA;
    private Entrenador entrenadorB;
    private Arena arena;


    public Batalla(Entrenador entrenadorA, Entrenador entrenadorB,Arena arena) {
        this.entrenadorA = entrenadorA;
        this.entrenadorB = entrenadorB;
        this.arena = arena;
    }

    //Aclaracion: deje comentado los system.out.println para ver bien el funcionamiento de los hilos. Esa informacion es la que deberiamos de mostrar en la ui?
    @Override
    public void run() {
        Pokemon p1, p2;
        Entrenador ganador=null;
        boolean randomCartaA =false;
        boolean randomCartaB =false;
        p1 = entrenadorA.eligePokemon();
        p2 = entrenadorB.eligePokemon();
        //System.out.println("\n----------------------COMIENZA LA BATALLA----------------------\n");
       // System.out.println("Se enfrentan: \n"+entrenadorA.getNombre()+" junto a "+p1.toString()+"\n        vs\n"+entrenadorB.getNombre()+" junto a "+p2.toString());
        try {
                randomCartaA = entrenadorA.cartaDisponible();
        }
        catch(SinCartasDisponiblesException e) {
                //System.out.println(e.getMessage());
        }
        
        try {
                randomCartaB = entrenadorB.cartaDisponible();
        }
        catch(SinCartasDisponiblesException e) {
                //System.out.println(e.getMessage());
        }
        
        //EJECUCION DE LA ARENA
        
        ganador = arena.inicia(entrenadorA, p1, randomCartaA, entrenadorB, p2, randomCartaB, maxAtaques);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        arena.termina();
        
        setChanged();
        notifyObservers(ganador);
    }

}

