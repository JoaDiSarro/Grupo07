package modeloClases;

import interfaces.ICarta;
import interfaces.IHechizable;

/**
 * @author Frangolini,Luciano.<br>
 * Clase que representa una carta utilizada por participantes de un torneo pokémon.
 */
public abstract class Carta implements ICarta,Cloneable{

	/**
	 *Método encargado de hechizar un objeto de tipo IHechizable.<br>
	 *@param hechizable  de tipo IHechizable : Objeto a hechizar.<br>
	 */
	public abstract void hechizar(IHechizable hechizable);

	/**
	 *Sobreescritura del método clone. Permite la clonación de objetos de tipo Carta.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	

}
