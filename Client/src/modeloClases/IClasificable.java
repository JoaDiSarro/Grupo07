package modeloClases;

/**
 * @author Frangolini, Luciano.<br>
 *Interfaz que será implementada por aquellos objetos que puedan clasificarse en distintas categorías.
 */
public interface IClasificable {

	/**
	 * Método encargado de clasificar un objeto dependiendo de sus atributos.
	 * <b> Post: </b> Actualiza la clasificación del objeto que lo invoca.
	 */
	public void actualizaClasificacion();
	
}
