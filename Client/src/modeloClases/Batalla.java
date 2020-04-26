package modeloClases;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 */
public class Batalla {
	
    private final int maxAtaques = 3;
    
    public Batalla() {
        super();
    }
    
    //Agregar el reporte y evaluar tema del finally con un prueba(despues del try / catch)
    public Entrenador enfrentamiento(Entrenador entrenadorA, Entrenador entrenadorB,ArrayList<Reporte> listaResultados){
        Pokemon p1, p2;
        int i=0;
        Entrenador ganador=null;
        boolean randomCartaA =false;
        boolean randomCartaB =false;
        p1 = entrenadorA.eligePokemon();
        p2 = entrenadorB.eligePokemon();

        //Me parece que hay que hacer el finally, entonces... quedaria mejor hacer una funcion analizaCartas(..) que se encargue de asignar la carta o tirar la excepcion
        //Y aca solo poner try{analizaCartas(entrenadorA);  analizaCartas(entrenadorB)} catch { e.getMessage()} finally {etc}
        //La funcion estaria en esta misma clase, no se si les parece bien la idea. Creeria que tiene que funcionar
        try {
        	if (entrenadorA.getCartasDisponibles() > 0) 
        		randomCartaA = new Random().nextBoolean();
        	else
        		throw new SinCartasDisponiblesException("El entrenador "+entrenadorA.getNombre()+" quizo utilizar una carta y no tiene disponibles.\n");
        }
        catch(SinCartasDisponiblesException e) {
        	e.getMessage();
        }
        
        try {
        	if (entrenadorB.getCartasDisponibles() > 0)
        		randomCartaB = new Random().nextBoolean();
        	else
        		throw new SinCartasDisponiblesException("El entrenador "+entrenadorB.getNombre()+" quizo utilizar una carta y no tiene disponibles.\n");
        }
        catch(SinCartasDisponiblesException e) {
        	e.getMessage();
        }
        
        while (i<maxAtaques) {
        	if (randomCartaA) {
        		entrenadorA.usarCarta(p2);
        		randomCartaA=false;
        	}
        	p1.ataca(p2);
        	if (p2.getVitalidad()==0) {
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
        		ganador = entrenadorA;
        	}
        	else {
        		p2.actualizaClasificacion();
        		entrenadorB.actualizaClasificacion();
        		ganador = entrenadorB;
        	}  		
        }      
        listaResultados.add(new Reporte(entrenadorA,p1,entrenadorB,p2,ganador));
        return ganador;
    }
    
    
    
}

