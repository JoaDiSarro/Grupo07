package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0 <br>
 *          Esta clase contiene metodos correspondientes a un Pokemon Comun.<br>
 *          La clase extiende de Pokemon y permite ser clonable.
 */
public class PokemonComun extends Pokemon implements Cloneable {

	/**
	 * Constructor parametrizado.<br>
	 * <b>Pre:</b> El parametro nombre debe ser distinto de null y distinto de
	 * vacio.<br>
	 * <b>Post:</b> Se crea un objeto de tipo Pokemon Comun.<br>
	 * 
	 * @param nombre de tipo String: Nombre que se le asignara al Pokemon.
	 */
	public PokemonComun(String nombre) {
		super(nombre);
	}

	/**
	 * Método que clona un pokémon común.<br>
	 * 
	 * @return Retorna el clon de un pokémon común .
	 */
	@Override
	public Object clone() {

		Object clon = null;
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// Nunca entro aca
		}
		return clon;
	}

	/**
	 * Método encargado de terminar el cansancio de un pokémon. Este método se
	 * encuentra vacío porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pokémon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o Eléctrico.<br>
	 * Por lo tanto, el método terminaCansancio estará implementado por el elemento
	 * al que pertenezca el pokémon.<br>
	 */
	@Override
	public void terminaCansancio() {
	}

	/**
	 * Método encargado de realizar la recarga de un pokémon. Este método se
	 * encuentra vacío porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pokémon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o Eléctrico.<br>
	 * Por lo tanto, el método recarga estará implementado por el elemento al que
	 * pertenezca el pokémon.<br>
	 */
	@Override
	public void recarga() {
	}

	/**
	 * Método encargado de realizar el golpe final de un pokémon. Este método se
	 * encuentra vacío porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pokémon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o Eléctrico.<br>
	 * Por lo tanto, el método golpeFinal estará implementado por el elemento al que
	 * pertenezca el pokémon.<br>
	 */
	@Override
	public void golpeFinal(Pokemon pokemon) {
	}

	/**
	 * Método encargado de hacer recibir daño a un pokémon. Este método se encuentra
	 * vacío porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pokémon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o Eléctrico.<br>
	 * Por lo tanto, el método recibeDaño estará implementado por el elemento al que
	 * pertenezca el pokémon.<br>
	 */
	@Override
	public void recibeDaño(double daño) {
	}

	/**
	 * Método encargado de hechizar un pokémon con el efecto de niebla. Este método
	 * se encuentra vacío porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pokémon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o Eléctrico.<br>
	 * Por lo tanto, el método hechizarNiebla estará implementado por el elemento al
	 * que pertenezca el pokémon.<br>
	 */
	@Override
	public void hechizarNiebla() {
	}

	/**
	 * Método encargado de hechizar un pokémon con el efecto de viento. Este método
	 * se encuentra vacío porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pokémon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o Eléctrico.<br>
	 * Por lo tanto, el método hechizarViento estará implementado por el elemento al
	 * que pertenezca el pokémon.<br>
	 */
	@Override
	public void hechizarViento() {
	}

	/**
	 * Método encargado de hechizar un pokémon con el efecto de Tormenta. Este
	 * método se encuentra vacío porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pokémon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o Eléctrico.<br>
	 * Por lo tanto, el método hechizarTormenta estará implementado por el elemento
	 * al que pertenezca el pokémon.<br>
	 */
	@Override
	public void hechizarTormenta() {
	}

}
