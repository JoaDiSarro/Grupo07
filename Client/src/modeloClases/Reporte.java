package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 */
public class Reporte { 
    private Entrenador entrenadorA;
    private Pokemon pokemonA;
    private Entrenador entrenadorB;
    private Pokemon pokemonB;
    private String resultado; 
    
    public Reporte(Entrenador entrenadorA,Pokemon pokemonA ,Entrenador entrenadorB,Pokemon pokemonB,Entrenador ganador) {
        this.entrenadorA = entrenadorA;
        this.pokemonA = pokemonA;
        this.entrenadorB = entrenadorB;
        this.pokemonB = pokemonB;
        this.resultado = "-Ganador del encuentro: "+ganador.getNombre();
    }

	@Override
	public String toString() {
		return "Batalla: <"+this.entrenadorA.getNombre()+" junto a "+pokemonA.getNombre()+"> vs <"+
				this.entrenadorB.getNombre()+" junto a "+pokemonB.getNombre()+">\n"+
				this.resultado; 
	}
    
    
    
}
