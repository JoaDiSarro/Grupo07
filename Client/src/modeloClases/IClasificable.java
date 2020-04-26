package modeloClases;

/**
 * @author Frangolini, Luciano.<br>
 *Interfaz que ser� implementada por aquellos objetos que puedan clasificarse en distintas categor�as.
 */
public interface IClasificable {

	/**
	 * M�todo encargado de clasificar un objeto dependiendo de sus atributos.
	 * <b> Post: </b> Actualiza la clasificaci�n del objeto que lo invoca.
	 */
	public void actualizaClasificacion();
	
}
