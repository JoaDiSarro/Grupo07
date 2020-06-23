package modeloClases.state;

import modeloClases.Arena;
import modeloClases.ModeloBatalla;

public class PreliminarState implements State{
    private Arena arena;
    
    public PreliminarState(Arena arena) {
        this.arena = arena;
    }

    @Override
    public void ejecutar(ModeloBatalla modelo) {
        arena.notificarEstado("\n Estado PRELIMINAR "+arena.getNombre());
        arena.setEstado(new EnfrentamientoState(arena));
        arena.continua(modelo);
    }
}
