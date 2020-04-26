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
        try {
        	randomCartaA = entrenadorA.utilizaCarta();
        }
        catch(SinCartasDisponiblesException e) {
        	System.out.println(e.getMessage());
        }
        
        try {
        	randomCartaB = entrenadorB.utilizaCarta();
        }
        catch(SinCartasDisponiblesException e) {
           	System.out.println(e.getMessage());
        }
        
        while (i<maxAtaques) {
                i++;
        	if (randomCartaA) {
        		entrenadorA.usarCarta(p2);
                        System.out.println("El entrenador "+entrenadorA.getNombre()+" uso una carta");
        		randomCartaA=false;
        	}
        	p1.ataca(p2);
        	System.out.println(p2.getVitalidad());
        	if (p2.getVitalidad()<=0) {
                        System.out.println("\nEl pokemon del entrenador "+entrenadorB.getNombre()+" ha muerto");
        		entrenadorB.eliminaPokemon(p2);
        		p1.actualizaClasificacion();
        		entrenadorA.actualizaClasificacion();
        		ganador = entrenadorA;
        		break;
        	}
        	else {
        		if (randomCartaB) {
        			entrenadorA.usarCarta(p1);
                                System.out.println("El entrenador "+entrenadorB.getNombre()+" uso una carta");
        			randomCartaB=false;
        		}
        		p2.ataca(p1);
                        System.out.println(p1.getVitalidad());
        		if (p1.getVitalidad() <= 0) {
                                System.out.println("\nEl pokemon del entrenador "+entrenadorA.getNombre()+" ha muerto");
        			entrenadorA.eliminaPokemon(p1);
        			p2.actualizaClasificacion();
        			entrenadorB.actualizaClasificacion();
        			ganador= entrenadorB;
        			break;
        		}
        	}
        	
        }    
        if (ganador==null) {
        	if (p1.comparaEstado(p2)== 1) {
        		p1.actualizaClasificacion();
        		entrenadorA.actualizaClasificacion();
        		entrenadorA.obtienePremio();
        		ganador = entrenadorA;
        	}
        	else {
        		p2.actualizaClasificacion();
        		entrenadorB.actualizaClasificacion();
        		entrenadorB.obtienePremio();
        		ganador = entrenadorB;
        	}  		
        }      
        listaResultados.add(new Reporte(entrenadorA,p1,entrenadorB,p2,ganador));
        return ganador;
    }
    
    
    
}

