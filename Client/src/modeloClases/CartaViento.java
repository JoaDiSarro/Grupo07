package modeloClases;

/**
 * @author Frangolini,Luciano.<br>
 * Clase que representa una carta de viento. Esta carta ser� utilizada por los entrenadores participantes de un torneo pok�mon.<br>
 */
public class CartaViento implements ICarta{
	
	
    /**
     * Constructor de la carta de viento.
     */
    public CartaViento() {
        super();
    }
    
    /**
     *M�todo que se encarga de hechizar con una carta de viento.<br>
     *@param hechizable, de tipo IHechizable : Representa el personaje a hechizar con la carta de viento.<br>
     *<b> Pre: <\b> El par�metro hechizable debe ser distinto de null.<br>
     *<b> Post: <\b> El personaje queda hechizado por una carta de viento.<br>
     */
    public void hechizar(IHechizable hechizable) {
        hechizable.hechizarViento();
    }
}
