package modeloClases;

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
    
    //ver el tema de los return, y agregar el reporte y evaluar tema del finally (despues del try / catch)
    public Entrenador enfrentamiento(Entrenador entrenadorA, Entrenador entrenadorB){
        Pokemon p1, p2;
        boolean randomCartaA =false;
        boolean randomCartaB =false;
        p1 = entrenadorA.eligePokemon();
        p2 = entrenadorB.eligePokemon();

        try {
        	if (entrenadorA.getCartasDisponibles() > 0) 
        		randomCartaA = new Random().nextBoolean();
        	else
        		throw new SinCartasDisponiblesException("El entrenador "+entrenadorA.getNombre()+" quizo utilizar una carta y no tiene disponiles.\n");
        }
        catch(SinCartasDisponiblesException e) {
        	e.getMessage();
        }
        
        try {
        	if (entrenadorB.getCartasDisponibles() > 0)
        		randomCartaB = new Random().nextBoolean();
        	else
        		throw new SinCartasDisponiblesException("El entrenador "+entrenadorB.getNombre()+" quizo utilizar una carta y no tiene disponiles.\n");
        }
        catch(SinCartasDisponiblesException e) {
        	e.getMessage();
        }
        
        for(int i=0 ; i<maxAtaques ; i++){
            if(randomCartaA)
                entrenadorA.usarCarta(p2);
            p1.ataca(p2);
            if (p2.getVitalidad() == 0){
                p1.actualizaClasificacion();
                entrenadorA.actualizaClasificacion();
                return entrenadorA;
            }else{
                if(randomCartaB)
                    entrenadorA.usarCarta(p1);
                p2.ataca(p1);
                if (p1.getVitalidad() == 0){
                    p2.actualizaClasificacion();
                    entrenadorB.actualizaClasificacion();
                    return entrenadorB;
                }
            }
        }
        if(p1.comparaEstado(p2)== 1){
            p1.actualizaClasificacion();
            entrenadorA.actualizaClasificacion();
            return entrenadorA;
        }else{
            p2.actualizaClasificacion();
            entrenadorB.actualizaClasificacion();
             return entrenadorB;
        }
    }
}

