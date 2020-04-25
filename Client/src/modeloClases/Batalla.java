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
    
    public Entrenador enfrentamiento(Entrenador entrenadorA, Entrenador entrenadorB){
        Pokemon p1, p2;
        p1 = entrenadorA.eligePokemon();
        p2 = entrenadorB.eligePokemon();
        //random de usar o no carta
        boolean randomCartaA = new Random().nextBoolean();
        boolean randomCartaB = new Random().nextBoolean();
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

