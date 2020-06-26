package modeloClases.state;

import modeloClases.Arena;
import modeloClases.Entrenador;
import modeloClases.ModeloBatalla;
import modeloClases.Pokemon;

/**
 * @author Di Sarro,Joaquina.<br>
 *         Clase que representa el estado de enfrentamiento de una arena en la
 *         cual se llevan a cabo combates pokémon .<br>
 */
public class EnfrentamientoState implements State {
	private Arena arena;
	private ModeloBatalla modelo;

	/**
	 * Constructor de la clase EnfrentamientoState.<br>
	 * 
	 * @param arena de tipo Arena: Representa la arena que cambiará de estado.<br>
	 */
	public EnfrentamientoState(Arena arena) {
		this.arena = arena;
	}

	/**
	 * Método encargado de cambiar el estado de la arena.<br>
	 * 
	 * @param modelo de tipo ModeloBatalla: Representa el estado de los
	 *               participantes en la arena.<br>
	 */
	@Override
	public void ejecutar(ModeloBatalla modelo) {
		arena.notificarEstado("\n La arena " + arena.getNombre() + " se encuentra ahora en estado de enfrentamiento.");
		this.modelo = modelo;
		modelo.setGanador(iniciaEnfrentamiento());
		arena.setEstado(new DefinicionState(arena));
		arena.continua(modelo);
	}

	/**
	 * Método encargado de enfrentar a los entrenadores y sus pokemones en la
	 * arena.<br>
	 * 
	 * @return Entrenador: Representa al ganador del enfrentamiento.<br>
	 */
	private Entrenador iniciaEnfrentamiento() {
		Entrenador ganadorEncuentro = null;
		for (int i = 0; i < modelo.getAtaques(); i++) {
			ganadorEncuentro = generaAtaque(modelo.getEntrenadorA(), modelo.getEntrenadorB(),
					modelo.getPokemonEntrenadorA(), modelo.getPokemonEntrenadorB(), modelo.entrenadorAUtilizaraCarta());
			modelo.setEntrenadorAUtilizaraCarta(false);
			if (ganadorEncuentro != null) {
				return ganadorEncuentro;
			} else {
				ganadorEncuentro = generaAtaque(modelo.getEntrenadorB(), modelo.getEntrenadorA(),
						modelo.getPokemonEntrenadorB(), modelo.getPokemonEntrenadorA(),
						modelo.entrenadorBUtilizaraCarta());
				modelo.setEntrenadorBUtilizaraCarta(false);
				if (ganadorEncuentro != null) {
					return ganadorEncuentro;
				}
			}
		}
		return defineGanadorPorEmpate();
	}

	/**
	 * Método encargado de actualizar el estado del ganador de la batalla en la
	 * arena.<br>
	 * 
	 * @param entrenador de tipo Entrenador: Representa el entrenador ganador.<br>
	 * @param pokemon    de tipo Pokemon: Representa el pokémon ganador.<br>
	 */
	private void actualizaEstado(Entrenador entrenador, Pokemon pokemon) {
		pokemon.ganaBatalla();
		pokemon.actualizaClasificacion();
		entrenador.actualizaClasificacion();
		entrenador.obtienePremio();
	}

	/**
	 * Método encargado de generar cada ataque de los pokemones durante su
	 * enfrentamiento.<br>
	 * 
	 * @param atacante        de tipo Entrenador: Representa al entrenador que
	 *                        ataca.<br>
	 * @param atacado         de tipo Entrenador: Representa al entrenador que
	 *                        recibe un ataque.<br>
	 * @param pokemonAtacante de tipo Pokemon: Representa al pokémon que ataca.<br>
	 * @param pokemonAtacado  de tipo Pokemon: Representa al pokémon que recibe
	 *                        daño.<br>
	 * @param usaraCarta      de tipo boolean: Indica si el entrenador atacante
	 *                        utilizará una carta durante su ataque.<br>
	 * @return Entrenador o null: En caso de haber un ganador en el combate, se
	 *         devuelve al entrenador ganador.<br>
	 */
	private Entrenador generaAtaque(Entrenador atacante, Entrenador atacado, Pokemon pokemonAtacante,
			Pokemon pokemonAtacado, boolean usaraCarta) {
		if (usaraCarta) {
			atacante.usarCarta(pokemonAtacado);
		}
		arena.notificarEstado("\nArena " + this.arena.getNombre() + ": El pokemon " + pokemonAtacante.getNombre()
				+ " ataca a " + pokemonAtacado.getNombre());
		pokemonAtacante.ataca(pokemonAtacado);
		if (pokemonAtacado.isMuerto()) {
			arena.notificarEstado(
					"\nArena " + this.arena.getNombre() + ": " + pokemonAtacado.getNombre() + " ha muerto.");
			atacado.eliminaPokemon(pokemonAtacado);
			actualizaEstado(atacante, pokemonAtacante);
			return atacante;
		}
		return null;
	}

	/**
	 * Método encargado de definir un ganador, mediante los estados resultantes, en
	 * caso de haber un empate.<br>
	 * 
	 * @return Entrenador: Representa al ganador del combate.<br>
	 */
	private Entrenador defineGanadorPorEmpate() {
		arena.notificarEstado("\nArena " + this.arena.getNombre()
				+ ": Hubo un empate y se decidirá el ganador comparando los estados de los pokemones.");
		if (modelo.getPokemonEntrenadorA().comparaEstado(modelo.getPokemonEntrenadorB()) == 1) {
			modelo.getPokemonEntrenadorB().pierdeBatalla();
			actualizaEstado(modelo.getEntrenadorA(), modelo.getPokemonEntrenadorA());
			return modelo.getEntrenadorA();
		} else {
			modelo.getPokemonEntrenadorA().pierdeBatalla();
			actualizaEstado(modelo.getEntrenadorB(), modelo.getPokemonEntrenadorB());
			return modelo.getEntrenadorB();
		}
	}

	@Override
	public String toString() {
		return " de enfrentamiento.";
	}
}
