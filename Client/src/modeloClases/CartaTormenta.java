package modeloClases;

/**
 * @author Frangolini,Luciano.<br>
 * Clase que representa una carta de tormenta. Esta carta ser� utilizada por los entrenadores participantes de un torneo pok�mon.<br>
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
     *@param hechizable, de tipo IHechizable : Representa el personaje a hechizar con la carta de tormenta.<br>
     */
    public void hechizar(IHechizable hechizable) {
        hechizable.hechizarTormenta();
    }
}
