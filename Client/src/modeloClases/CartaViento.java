package modeloClases;

import interfaces.IHechizable;

/**
 * @author Frangolini,Luciano.<br>
 *         Clase que representa una carta de viento. Esta carta ser� utilizada
 *         por los participantes de un torneo pok�mon.<br>
 */
public class CartaViento extends Carta {

	/**
	 * Constructor de la carta de viento.
	 */
	public CartaViento() {
		super();
	}

	/**
	 * M�todo que se encarga de hechizar con una carta de viento.<br>
	 * 
	 * @param hechizable de tipo IHechizable : Representa el objeto a hechizar con
	 *                   la carta de viento.<br>
	 *                   <b> Pre: </b> El par�metro hechizable debe ser distinto de
	 *                   null.<br>
	 *                   <b> Post: </b> El objeto queda hechizado por una carta de
	 *                   viento.<br>
	 */
	public void hechizar(IHechizable hechizable) {
		hechizable.hechizarViento();
	}
}
