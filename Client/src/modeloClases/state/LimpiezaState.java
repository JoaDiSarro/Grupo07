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
        arena.notificarEstado("\n La arena "+arena.getNombre()+" se encuentra en estado de limpieza.");
        arena.setEstado(null);
    }
    
    @Override
	public String toString() {
		return " de limpieza.";
	}
}
