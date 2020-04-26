package modeloClases;

/**
 * @author Frangolini, Luciano.
 * Clase extendida de Excepcion.<br>
 * Se encarga de resolver la excepción al no poseer cartas disponibles durante un torneo pokémon.
 */
@SuppressWarnings({ "serial", "oracle.jdeveloper.java.serialversionuid-field-missing" })
public class SinCartasDisponiblesException extends Exception {

	/**
	 * Constructor parametrizado de la clase SinCartasDisponiblesException
	 * @param msj de tipo String : Este parámetro se encarga de proveer el mensaje que se mostrará cuando se emite una excepción de este tipo.
	 */
	public SinCartasDisponiblesException(String msj) {
		super(msj);
	}

}
