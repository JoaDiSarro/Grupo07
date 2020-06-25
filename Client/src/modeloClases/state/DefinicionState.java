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
        arena.notificarEstado("\n La arena "+arena.getNombre()+" se encuentra ahora en estado de definición.");
        arena.setEstado(new LimpiezaState(arena));
        arena.continua(modelo);
    }
    
	@Override
	public String toString() {
		return " de definición.";
	}
    
    
}
