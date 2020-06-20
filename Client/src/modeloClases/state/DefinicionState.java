package modeloClases.state;

import modeloClases.Arena;
import modeloClases.ModeloBatalla;

public class DefinicionState implements State{
    private Arena arena;
    
    public DefinicionState(Arena arena) {
        this.arena = arena;
    }
    //TODO: Debe de avisarle a la vista quien es el ganador de la arena
    @Override
    public void ejecutar(ModeloBatalla modelo) {
        System.out.println("\n Estado DEFINICION "+arena.getNombre());
        arena.setEstado(new LimpiezaState(arena));
        arena.continua(modelo);
    }
}
