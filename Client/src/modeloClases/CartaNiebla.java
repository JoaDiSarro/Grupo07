package modeloClases;

/**
 * @author Frangolini,Luciano.<br>
 * Clase que representa una carta de niebla. Esta carta será utilizada por los entrenadores participantes de un torneo pokémon.<br>
 */
public class CartaNiebla implements ICarta {
	
    
    /**
     * Constructor de la carta de niebla.<br>
     */
    public CartaNiebla() {
        super();
    }

    /**
     *Método que se encarga de hechizar con una carta de niebla.<br>
     *@param hechizable, de tipo IHechizable : Representa el personaje a hechizar con la carta de niebla.<br>
     */
    public void hechizar(IHechizable hechizable) {
        hechizable.hechizarNiebla();
    }
}
