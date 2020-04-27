package interfaces;

/**
 * @author Frangolini, Luciano.<br>
 * Interfaz que será implementada por aquellos objetos que puedan ser hechizados.
 */
public interface IHechizable {
    
    /**
     * Método que se encarga de hechizar un objeto participante de una batalla pokémon con el efecto de niebla.<br>
     * <b> Post : </b> El objeto que invoque este método será hechizado por un efecto de niebla.<br>
     */
    public void hechizarNiebla();
    
    /**
     * Método que se encarga de hechizar un objeto participante de una batalla pokémon con el efecto de viento.<br>
     * <b> Post : </b> El objeto que invoque este método será hechizado por un efecto de viento.<br>
     */
    public void hechizarViento();
    
    /**
     * Método que se encarga de hechizar un objeto participante de una batalla pokémon con el efecto de tormenta.<br>
     * <b> Post : </b> El objeto que invoque este método será hechizado por un efecto de tormenta.<br>
     */
    public void hechizarTormenta();
    
}
