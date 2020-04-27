package interfaces;


/**
 * @author Frangolini, Luciano.<br>
 *Interfaz que será implementada por cartas para hechizar objetos participantes de las batallas de un torneo pokémon.
 */
public interface ICarta {
    
    /**
     * Método que se encarga de hechizar a un objeto participante de la batalla pokémon. <br>
     * @param hechizable  de tipo IHechizable : Representa el objeto a hechizar con el método.<br>
     * <b> Pre: </b> El parámetro hechizable debe ser distinto de null.<br>
     * <b> Post: </b> El objeto queda hechizado por una carta.<br>
     */
    public void hechizar(IHechizable hechizable);
}
