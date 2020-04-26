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
     * <b>Pre:</b> entrenadorA distinto de null, pokemonA distinto de null, entrenadorB distinto de null, pokemonB distinto de null, ganador distinto de null<br>
     * <b>Post:</b> Se genera un reporte con los datelles y resultado de la Batalla.<br>
     * @param entrenadorA de tipo Entrenador: Entrenador que participo dentro de la batalla<br>
     * @param pokemonA de tipo Pokemon: Pokemon utilizado durante la batalla por el entrenadorA<br>
     * @param entrenadorB de tipo Entrenador: Entrenador que participo dentro de la batalla<br>
     * @param pokemonB de tipo Pokemon: Pokemon utilizado durante la batalla por el entrenadorB<br>
     * @param ganador de tipo Entrenador: Ganador de la batalla, puede ser el entrenadorA o el entrenadorB<br>
     */
    public Reporte(Entrenador entrenadorA,Pokemon pokemonA ,Entrenador entrenadorB,Pokemon pokemonB,Entrenador ganador) {
        this.entrenadorA = entrenadorA;
        this.pokemonA = pokemonA;
        this.entrenadorB = entrenadorB;
        this.pokemonB = pokemonB;
        this.resultado = "-Ganador del encuentro: "+ganador.getNombre();
    }
    
    /**
     *Sobreescritura del metodo toString. Se utiliza para mostrar los participantes de un enfrentamiento pokémon y el resultado de la batalla.
     */
    @Override
	public String toString() {
		return "Batalla: <"+this.entrenadorA.getNombre()+" junto a su pokemon: "+pokemonA.getNombre()+"> vs <"+
				this.entrenadorB.getNombre()+" junto a su pokemon: "+pokemonB.getNombre()+">\n"+
				this.resultado; 
	}
    
}
