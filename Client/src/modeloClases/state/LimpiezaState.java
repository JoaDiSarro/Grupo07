package modeloClases.state;

import modeloClases.Arena;
import modeloClases.ModeloBatalla;

public class LimpiezaState implements State {
    private Arena arena;
    
    public LimpiezaState(Arena arena) {
        this.arena = arena;
    }

    @Override
    public void ejecutar(ModeloBatalla modelo) {
        System.out.println("\n Estado LIMPIEZA "+arena.getNombre());
        arena.setEstado(null);
    }
}
