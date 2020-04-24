package modeloClases;

/**
 * @author Frangolini, Luciano.<br>
 *Interfaz que ser� implementada por cartas para hechizar personajes.
 */
public interface ICarta {
    
    /**
     * M�todo que se encarga de hechizar a un personaje. <br>
     * @param hechizable, de tipo IHechizable : Representa el personaje a hechizar con el m�todo.<br>
     */
    public void hechizar(IHechizable hechizable);
}
