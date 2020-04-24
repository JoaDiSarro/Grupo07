package modeloClases;

/**
 * @author Frangolini, Luciano.<br>
 *Interfaz que será implementada por cartas para hechizar personajes.
 */
public interface ICarta {
    
    /**
     * Método que se encarga de hechizar a un personaje. <br>
     * @param hechizable, de tipo IHechizable : Representa el personaje a hechizar con el método.<br>
     */
    public void hechizar(IHechizable hechizable);
}
