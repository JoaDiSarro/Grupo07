package modeloClases;

/**
 * @author Frangolini, Luciano.
 * Clase extendida de Excepcion.<br>
 * Se encarga de resolver la excepci�n al no poseer cartas disponibles durante un torneo pok�mon.
 */
@SuppressWarnings({ "serial", "oracle.jdeveloper.java.serialversionuid-field-missing" })
public class SinCartasDisponiblesException extends Exception {

	/**
	 * Constructor parametrizado de la clase SinCartasDisponiblesException
	 * @param msj de tipo String : Este par�metro se encarga de proveer el mensaje que se mostrar� cuando se emite una excepci�n de este tipo.
	 */
	public SinCartasDisponiblesException(String msj) {
		super(msj);
	}

}
