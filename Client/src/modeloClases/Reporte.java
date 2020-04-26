package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase que se encarga de llevar un Reporte con los datos obtenidos por Batalla dentro del Torneo. Cuenta con sus atributos y metodos correspondientes.
 */
public class Reporte { 
    private Entrenador entrenadorA;
    private Pokemon pokemonA;
    private Entrenador entrenadorB;
    private Pokemon pokemonB;
    private String resultado;


    /**
     * Metodo constructor parametrizado<br>
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.<br>
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento agua.<br>
     * @param pokemon : Pokemon al que se lo decora con el elemento agua.
     */
    
    /**
     * Metodo constructor parametrizado
     * <b>Pre:</b> entrenadorA distinto de null, pokemonA distinto de null, entrenadorB distinto de null, pokemonB distinto de null, ganador distinto de null
     * <b>Post:</b> Se genera un reporte con los datelles y resultado de la Batalla.
     * @param entrenadorA : entrenador que participo dentro de la batalla
     * @param pokemonA : pokemon utilizado durante la batalla por el entrenadorA
     * @param entrenadorB : entrenador que participo dentro de la batalla
     * @param pokemonB : pokemon utilizado durante la batalla por el entrenadorB
     * @param ganador : ganador de la batalla, puede ser el entrenadorA o el entrenadorB
     */
    public Reporte(Entrenador entrenadorA,Pokemon pokemonA ,Entrenador entrenadorB,Pokemon pokemonB,Entrenador ganador) {
        this.entrenadorA = entrenadorA;
        this.pokemonA = pokemonA;
        this.entrenadorB = entrenadorB;
        this.pokemonB = pokemonB;
        this.resultado = "-Ganador del encuentro: "+ganador.getNombre();
    }
    
    @Override
	public String toString() {
		return "Batalla: <"+this.entrenadorA.getNombre()+" junto a su pokemon: "+pokemonA.getNombre()+"> vs <"+
				this.entrenadorB.getNombre()+" junto a su pokemon: "+pokemonB.getNombre()+">\n"+
				this.resultado; 
	}
    
}
