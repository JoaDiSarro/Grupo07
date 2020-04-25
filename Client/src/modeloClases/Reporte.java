package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 */
public class Reporte { //REVISAR LOS COMENTARIOS!!!!!!!!!!!!!!!!!
    private Entrenador entrenadorA;
    private Pokemon pokemonA;
    private Entrenador entrenadorB;
    private Pokemon pokemonB;
    private String resultado; //No deberia ser de tipo Entrenador?
    
    public Reporte(Entrenador entrenadorA,Pokemon pokemonA ,Entrenador entrenadorB,Pokemon pokemonB,Entrenador ganador) {
        this.entrenadorA = entrenadorA;
        this.pokemonA = pokemonA;
        this.entrenadorB = entrenadorB;
        this.pokemonB = pokemonB;
        this.resultado = "-Ganador del encuentro: "+ganador;
    }

	@Override //Escribir el metodo toString
	public String toString() {
		return "Batalla: <"+this.entrenadorA.getNombre()+" junto a "+pokemonA.getNombre()+"> vs <"+
				this.entrenadorB.getNombre()+" junto a "+pokemonB.getNombre()+">\n"+
				"Ganador : "+resultado.getNombre(); //Si resultado fuese de tipo entrenador, podria hacer esto
	}
    
    
    
}
