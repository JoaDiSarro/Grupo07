package modeloClases;

/**
 * @author Frangolini,Luciano.<br>
 * Clase que representa una carta de tormenta. Esta carta ser� utilizada por los participantes de un torneo pok�mon.<br>
 */
public class CartaTormenta implements ICarta{
	
	
    /**
     * Constructor de la carta de tormenta.
     */
    public CartaTormenta() {
        super();
    }

    /**
     *M�todo que se encarga de hechizar con una carta de tormenta.<br>
     *@param hechizable, de tipo IHechizable : Representa el objeto a hechizar con la carta de tormenta.<br>
     *<b> Pre: <\b> El par�metro hechizable debe ser distinto de null.<br>
     *<b> Post: <\b> El objeto queda hechizado por una carta de tormenta.<br>
     */
    public void hechizar(IHechizable hechizable) {
        hechizable.hechizarTormenta();
    }
}
