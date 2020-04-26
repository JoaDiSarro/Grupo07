package modeloClases;

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
     * Método encargado de enfrentar 2 entrenadores en una batalla pokémon y decidir un ganador.
     * <b> Pre: </b> Los parámetros entrenadorA, entrenadorB y listaResultados deben ser distintos de null.
     * @param entrenadorA, de tipo Entrenador : Representa uno de los dos entrenadores en el enfrentamiento pokémon.
     * @param entrenadorB, de tipo Entrenador : Representa uno de los dos entrenadores en el enfrentamiento pokémon.
     * @param listaResultados, de tipo ArrayList<Reporte> : Representa una lista con los resultados de cada enfrentamiento.
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
        	
        	if (randomCartaA) {
        		entrenadorA.usarCarta(p2);
        		randomCartaA=false;
        	}
        	p1.ataca(p2);
        	
        	if (p2.getVitalidad()==0) {
        		entrenadorB.eliminaPokemon(p2);
        		p1.actualizaClasificacion();
        		entrenadorA.actualizaClasificacion();
        		ganador = entrenadorA;
        		break;
        	}
        	else {
        		if (randomCartaB) {
        			entrenadorA.usarCarta(p1);
        			randomCartaB=false;
        		}
        		p2.ataca(p1);
        		
        		if (p1.getVitalidad() == 0) {
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

