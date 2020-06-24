package vista.interfacesVista;

/**
 * @author Frangolini, Luciano.<br>
 *         Clase que representa una interfaz utilizada por
 *         VistaDesarrolloTorneo. Posee los m�todos necesarios para su m�nimo
 *         funcionamiento.<br>
 */
public interface IVistaDesarrolloTorneo extends IVista {

	static final String AGREGA_DETALLES = "AgregaDetalles";

	/**
	 * M�todo encargado de a�adir texto en un �rea de texto.<br>
	 * 
	 * @param detalles de tipo String: Representa el texto a a�adir.<br>
	 */
	public void agregaDetalles(String detalles);
}
