package modeloClases;

/**
 * @author Di Sarro,Joaquina.<br>
 *         Clase que representa un modelo de batalla en el cual se poseen los
 *         datos de los participantes de una arena .<br>
 */
public class ModeloBatalla {
	private Entrenador entrenadorA;
	private Entrenador entrenadorB;
	private Entrenador ganador;
	private Pokemon pokemonEntrenadorA;
	private Pokemon pokemonEntrenadorB;
	private boolean entrenadorAUtilizaraCarta;
	private boolean entrenadorBUtilizaraCarta;
	private int ataques;

	/**
	 * Constructor de la clase ModeloBatalla.<br>
	 * 
	 * @param entrenadorA de tipo Entrenador: Representa el entrenador 1 que
	 *                    participará en la arena.<br>
	 * @param p1          de tipo Pokemon: Representa el pokémon 1 que participará
	 *                    en la arena.<br>
	 * @param cartaA      de tipo boolean: Indica si el entrenador 1 utilizará una
	 *                    carta en su ataque.<br>
	 * @param entrenadorB de tipo Entrenador: Representa el entrenador 2 que
	 *                    participará en la arena.<br>
	 * @param p2          de tipo Pokemon: Representa el pokémon 2 que participará
	 *                    en la arena.<br>
	 * @param cartaB      de tipo boolean: Indica si el entrenador 2 utilizará una
	 *                    carta en su ataque.<br>
	 * @param ataques     de tipo int: Representa la cantidad de turnos que tendrán
	 *                    los participantes en la arena para atacar.<br>
	 */
	public ModeloBatalla(Entrenador entrenadorA, Pokemon p1, boolean cartaA, Entrenador entrenadorB, Pokemon p2,
			boolean cartaB, int ataques) {
		this.entrenadorA = entrenadorA;
		this.entrenadorB = entrenadorB;
		this.pokemonEntrenadorA = p1;
		this.pokemonEntrenadorB = p2;
		this.entrenadorAUtilizaraCarta = cartaA;
		this.entrenadorBUtilizaraCarta = cartaB;
		this.ataques = ataques;
	}

	public Entrenador getEntrenadorA() {
		return entrenadorA;
	}

	public Entrenador getEntrenadorB() {
		return entrenadorB;
	}

	public Pokemon getPokemonEntrenadorA() {
		return pokemonEntrenadorA;
	}

	public Pokemon getPokemonEntrenadorB() {
		return pokemonEntrenadorB;
	}

	public void setGanador(Entrenador ganador) {
		this.ganador = ganador;
	}

	public void setEntrenadorAUtilizaraCarta(boolean entrenadorAUtilizaraCarta) {
		this.entrenadorAUtilizaraCarta = entrenadorAUtilizaraCarta;
	}

	public void setEntrenadorBUtilizaraCarta(boolean entrenadorBUtilizaraCarta) {
		this.entrenadorBUtilizaraCarta = entrenadorBUtilizaraCarta;
	}

	public Entrenador getGanador() {
		return ganador;
	}

	public boolean entrenadorAUtilizaraCarta() {
		return entrenadorAUtilizaraCarta;
	}

	public boolean entrenadorBUtilizaraCarta() {
		return entrenadorBUtilizaraCarta;
	}

	public int getAtaques() {
		return ataques;
	}

	/**
	 *Sobreescritura del método toString.<br>
	 */
	@Override
	public String toString() {
		return "\n---ENFRENTAMIENTO: \n-Entrenador: " + this.entrenadorA + "-Pokemon: " + this.pokemonEntrenadorA
				+ "\nVS \n-Entrenador: " + this.entrenadorB + "-Pokemon:" + this.pokemonEntrenadorB;
	}

}
