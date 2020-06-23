package modeloClases;

public class ModeloBatalla {
    private Entrenador entrenadorA;
    private Entrenador entrenadorB;
    private Entrenador ganador;
    private Pokemon pokemonEntrenadorA;
    private Pokemon pokemonEntrenadorB;
    private boolean entrenadorAUtilizaraCarta;
    private boolean entrenadorBUtilizaraCarta;
    private int ataques;


    public ModeloBatalla(Entrenador entrenadorA, Pokemon p1,boolean cartaA, Entrenador entrenadorB, Pokemon p2,
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
}
