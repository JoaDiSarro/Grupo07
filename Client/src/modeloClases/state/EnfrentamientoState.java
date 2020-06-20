package modeloClases.state;

import modeloClases.Arena;
import modeloClases.Entrenador;
import modeloClases.ModeloBatalla;
import modeloClases.Pokemon;

public class EnfrentamientoState implements State{
    private Arena arena;
    private ModeloBatalla modelo;
    
    public EnfrentamientoState(Arena arena) {
        this.arena = arena;
    }

    @Override
    public void ejecutar(ModeloBatalla modelo) {
        System.out.println("\n Estado ENFRENTAMIENTO "+arena.getNombre());
        this.modelo = modelo;
        modelo.setGanador(iniciaEnfrentamiento());
        arena.setEstado(new DefinicionState(arena));
        arena.continua(modelo);
    }
    
    private Entrenador iniciaEnfrentamiento(){
        Entrenador ganadorEncuentro = null;
        for(int i = 0;i<modelo.getAtaques();i++) {
            ganadorEncuentro = generaAtaque(modelo.getEntrenadorA(), modelo.getEntrenadorB(), modelo.getPokemonEntrenadorA(),
                                            modelo.getPokemonEntrenadorB(), modelo.entrenadorAUtilizaraCarta());
            modelo.setEntrenadorAUtilizaraCarta(false);
            if (ganadorEncuentro != null) {
                return ganadorEncuentro;
            } else {
                ganadorEncuentro = generaAtaque(modelo.getEntrenadorB(), modelo.getEntrenadorA(), modelo.getPokemonEntrenadorB(),
                                                modelo.getPokemonEntrenadorA(), modelo.entrenadorBUtilizaraCarta());
                modelo.setEntrenadorBUtilizaraCarta(false);
                if (ganadorEncuentro != null) {
                    return ganadorEncuentro;
                }
            }
        }
        return defineGanadorPorEmpate();
    }
    
    private void actualizaEstado(Entrenador entrenador, Pokemon pokemon){
        pokemon.ganaBatalla();
        pokemon.actualizaClasificacion();
        entrenador.actualizaClasificacion();
        entrenador.obtienePremio();
    }
    
    private Entrenador generaAtaque(Entrenador atacante, Entrenador atacado, Pokemon pokemonAtacante,
                              Pokemon pokemonAtacado, boolean usaraCarta) {
        if (usaraCarta) {
            atacante.usarCarta(pokemonAtacado);
        }
        pokemonAtacante.ataca(pokemonAtacado);
        if (pokemonAtacado.isMuerto()) {
            atacado.eliminaPokemon(pokemonAtacado);
            actualizaEstado(atacante, pokemonAtacante);
            return atacante;
        }
        return null;
    }
    
    private Entrenador defineGanadorPorEmpate() {
        if (modelo.getPokemonEntrenadorA().comparaEstado(modelo.getPokemonEntrenadorB())== 1) {
                modelo.getPokemonEntrenadorB().pierdeBatalla();
                actualizaEstado(modelo.getEntrenadorA(), modelo.getPokemonEntrenadorA());
                return modelo.getEntrenadorA();
        }
        else {
            modelo.getPokemonEntrenadorA().pierdeBatalla();
            actualizaEstado(modelo.getEntrenadorB(), modelo.getPokemonEntrenadorB());
            return modelo.getEntrenadorB();
        }
    }
}
