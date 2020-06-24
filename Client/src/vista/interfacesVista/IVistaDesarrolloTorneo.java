package vista.interfacesVista;

/**
 * @author Frangolini, Luciano.<br>
 *         Clase que representa una interfaz utilizada por
 *         VistaDesarrolloTorneo. Posee los métodos necesarios para su mínimo
 *         funcionamiento.<br>
 */
public interface IVistaDesarrolloTorneo extends IVista {

	static final String AGREGA_DETALLES = "AgregaDetalles";

	/**
	 * Método encargado de añadir texto en un área de texto.<br>
	 * 
	 * @param detalles de tipo String: Representa el texto a añadir.<br>
	 */
	public void agregaDetalles(String detalles);
}
