package modeloClases;

import interfaces.ICarta;
import interfaces.IHechizable;

/**
 * @author Frangolini,Luciano.<br>
 * Clase que representa una carta utilizada por participantes de un torneo pok�mon.
 */
public abstract class Carta implements ICarta,Cloneable{

	/**
	 *M�todo encargado de hechizar un objeto de tipo IHechizable.<br>
	 *@param hechizable  de tipo IHechizable : Objeto a hechizar.<br>
	 */
	public abstract void hechizar(IHechizable hechizable);

	/**
	 *Sobreescritura del m�todo clone. Permite la clonaci�n de objetos de tipo Carta.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	

}
