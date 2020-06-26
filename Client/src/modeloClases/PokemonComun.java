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
	 * M�todo que clona un pok�mon com�n.<br>
	 * 
	 * @return Retorna el clon de un pok�mon com�n .
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
	 * M�todo encargado de terminar el cansancio de un pok�mon. Este m�todo se
	 * encuentra vac�o porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pok�mon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o El�ctrico.<br>
	 * Por lo tanto, el m�todo terminaCansancio estar� implementado por el elemento
	 * al que pertenezca el pok�mon.<br>
	 */
	@Override
	public void terminaCansancio() {
	}

	/**
	 * M�todo encargado de realizar la recarga de un pok�mon. Este m�todo se
	 * encuentra vac�o porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pok�mon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o El�ctrico.<br>
	 * Por lo tanto, el m�todo recarga estar� implementado por el elemento al que
	 * pertenezca el pok�mon.<br>
	 */
	@Override
	public void recarga() {
	}

	/**
	 * M�todo encargado de realizar el golpe final de un pok�mon. Este m�todo se
	 * encuentra vac�o porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pok�mon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o El�ctrico.<br>
	 * Por lo tanto, el m�todo golpeFinal estar� implementado por el elemento al que
	 * pertenezca el pok�mon.<br>
	 */
	@Override
	public void golpeFinal(Pokemon pokemon) {
	}

	/**
	 * M�todo encargado de hacer recibir da�o a un pok�mon. Este m�todo se encuentra
	 * vac�o porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pok�mon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o El�ctrico.<br>
	 * Por lo tanto, el m�todo recibeDa�o estar� implementado por el elemento al que
	 * pertenezca el pok�mon.<br>
	 */
	@Override
	public void recibeDa�o(double da�o) {
	}

	/**
	 * M�todo encargado de hechizar un pok�mon con el efecto de niebla. Este m�todo
	 * se encuentra vac�o porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pok�mon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o El�ctrico.<br>
	 * Por lo tanto, el m�todo hechizarNiebla estar� implementado por el elemento al
	 * que pertenezca el pok�mon.<br>
	 */
	@Override
	public void hechizarNiebla() {
	}

	/**
	 * M�todo encargado de hechizar un pok�mon con el efecto de viento. Este m�todo
	 * se encuentra vac�o porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pok�mon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o El�ctrico.<br>
	 * Por lo tanto, el m�todo hechizarViento estar� implementado por el elemento al
	 * que pertenezca el pok�mon.<br>
	 */
	@Override
	public void hechizarViento() {
	}

	/**
	 * M�todo encargado de hechizar un pok�mon con el efecto de Tormenta. Este
	 * m�todo se encuentra vac�o porque nunca se va a ejecutar.<br>
	 * Esto sucede ya que al momento de crearse un pok�mon, se lo decora con un
	 * elemento : Agua, Tierra, Fuego, Hielo, Hielo Recargado o El�ctrico.<br>
	 * Por lo tanto, el m�todo hechizarTormenta estar� implementado por el elemento
	 * al que pertenezca el pok�mon.<br>
	 */
	@Override
	public void hechizarTormenta() {
	}

}
