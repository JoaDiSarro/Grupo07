package interfaces;

/**
 * @author Frangolini, Luciano.<br>
 * Interfaz que ser� implementada por aquellos objetos que puedan ser hechizados.
 */
public interface IHechizable {
    
    /**
     * M�todo que se encarga de hechizar un objeto participante de una batalla pok�mon con el efecto de niebla.<br>
     * <b> Post : </b> El objeto que invoque este m�todo ser� hechizado por un efecto de niebla.<br>
     */
    public void hechizarNiebla();
    
    /**
     * M�todo que se encarga de hechizar un objeto participante de una batalla pok�mon con el efecto de viento.<br>
     * <b> Post : </b> El objeto que invoque este m�todo ser� hechizado por un efecto de viento.<br>
     */
    public void hechizarViento();
    
    /**
     * M�todo que se encarga de hechizar un objeto participante de una batalla pok�mon con el efecto de tormenta.<br>
     * <b> Post : </b> El objeto que invoque este m�todo ser� hechizado por un efecto de tormenta.<br>
     */
    public void hechizarTormenta();
    
}
