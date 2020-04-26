package interfaces;


/**
 * @author Frangolini, Luciano.<br>
 *Interfaz que ser� implementada por cartas para hechizar objetos participantes de las batallas de un torneo pok�mon.
 */
public interface ICarta {
    
    /**
     * M�todo que se encarga de hechizar a un objeto participante de la batalla pok�mon. <br>
     * @param hechizable  de tipo IHechizable : Representa el objeto a hechizar con el m�todo.<br>
     * <b> Pre: </b> El par�metro hechizable debe ser distinto de null.<br>
     * <b> Post: </b> El objeto queda hechizado por una carta.<br>
     */
    public void hechizar(IHechizable hechizable);
}
