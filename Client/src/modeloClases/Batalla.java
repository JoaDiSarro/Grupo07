package modeloClases;

import exceptions.SinCartasDisponiblesException;

import java.util.ArrayList;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase que representa una batalla en un torneo pokemon.<br>
 * Se encarga de hacer batallar objetos de tipo Entrenador.
 */
public class Batalla {
	
    private final int maxAtaques = 3;
    
    /**
     * Constructor por defecto de la clase Batalla.
     */
    public Batalla() {
        super();
    }
    
    /**
     * Método encargado de enfrentar 2 entrenadores en una batalla pokémon y decidir un ganador.<br>
     * <b> Pre: </b> Los parámetros entrenadorA, entrenadorB y listaResultados deben ser distintos de null.<br>
     * @param entrenadorA  de tipo Entrenador : Representa uno de los dos entrenadores en el enfrentamiento pokémon.<br>
     * @param entrenadorB  de tipo Entrenador : Representa uno de los dos entrenadores en el enfrentamiento pokémon.<br>
     * @param listaResultados  de tipo ArrayList<Reporte> : Representa una lista con los resultados de cada enfrentamiento.<br>
     * @return Retorna el ganador del enfrentamiento pokémon.
     */
    public Entrenador enfrentamiento(Entrenador entrenadorA, Entrenador entrenadorB,ArrayList<Reporte> listaResultados){
        
        Pokemon p1, p2;
        int i=0;
        Entrenador ganador=null;
        boolean randomCartaA =false;
        boolean randomCartaB =false;
        p1 = entrenadorA.eligePokemon();
        p2 = entrenadorB.eligePokemon();
        System.out.println("\n----------------------COMIENZA LA BATALLA----------------------\n");
        System.out.println("Se enfrentan: \n"+entrenadorA.getNombre()+" junto a "+p1.toString()+"\n        vs\n"+entrenadorB.getNombre()+" junto a "+p2.toString());
        try {
        	randomCartaA = entrenadorA.cartaDisponible();
        }
        catch(SinCartasDisponiblesException e) {
        	System.out.println(e.getMessage());
        }
        
        try {
        	randomCartaB = entrenadorB.cartaDisponible();
        }
        catch(SinCartasDisponiblesException e) {
           	System.out.println(e.getMessage());
        }
        System.out.println("\nComienza el combate");
        while (i<maxAtaques) {
                i++;
        	if (randomCartaA) {
        		entrenadorA.usarCarta(p2);
                        System.out.println("\n-->El entrenador "+entrenadorA.getNombre()+" uso una carta");
        		randomCartaA=false;
        	}
        	p1.ataca(p2);
        	System.out.println(p2.getNombre() +":\n-Vida:" + p2.getVitalidad()+"  --  Escudo:"+p2.getEscudo());
        	if (p2.getVitalidad()<=0) {
                        System.out.println("\n"+p2.getNombre()+" ha muerto");
        		entrenadorB.eliminaPokemon(p2);
        		actualizaEstado(entrenadorA, p1);;    
        		ganador = entrenadorA;
        		break;
        	}
        	else {
        		if (randomCartaB) {
        			entrenadorA.usarCarta(p1);
                                System.out.println("\n-->El entrenador "+entrenadorB.getNombre()+" uso una carta");
        			randomCartaB=false;
        		}
        		p2.ataca(p1);
                        System.out.println(p1.getNombre() +":\n-Vida:" + p1.getVitalidad()+"  --  Escudo:"+p1.getEscudo());
        		if (p1.getVitalidad() <= 0) {
                                System.out.println("\n"+p1.getNombre()+" ha muerto");
        			entrenadorA.eliminaPokemon(p1);
                                actualizaEstado(entrenadorB, p2);
        			ganador= entrenadorB;
        			break;
        		}
        	}
        	
        }    
        if (ganador==null) {
        	if (p1.comparaEstado(p2)== 1) {
                        p2.pierdeBatalla();
        		actualizaEstado(entrenadorA, p1);
        		ganador = entrenadorA;
        	}
        	else {
        	    p1.pierdeBatalla();
        	    actualizaEstado(entrenadorB, p2);
                    ganador = entrenadorB;
        	}  		
        }      
        listaResultados.add(new Reporte(entrenadorA,p1,entrenadorB,p2,ganador));
        return ganador;
    }

    /**
     * Metodo que se encarga de actualizar el estado de un Entrenador y su pokemon luego de ganar una batalla.<br>
     * <b>Pre:</b> El entrenador y el pokemon deben ser distintos de null.<br>
     * <b>Post:</b> Se actualizan los premios y estados del Entrenador y su Pokemon.<br>
     * @param entrenador  de tipo Entrenador: Entrenador ganador de la batalla.<br>
     * @param pokemon  de tipo Pokemon: Pokemon ganador de la batalla.<br>
     */
    private void actualizaEstado(Entrenador entrenador, Pokemon pokemon) {
        pokemon.ganaBatalla();
        pokemon.actualizaClasificacion();
        entrenador.actualizaClasificacion();
        entrenador.obtienePremio();
    }
     
}

