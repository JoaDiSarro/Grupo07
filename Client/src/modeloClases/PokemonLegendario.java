package modeloClases;

import java.awt.Toolkit;

import vista.interfacesVista.IVista;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0 <br>
 *          Esta clase contiene metodos correspondientes a un Pokemon
 *          Legendario.<br>
 *          La clase extiende de Pokemon y no permite ser clonable.
 */
public class PokemonLegendario extends Pokemon implements Cloneable {

	/**
	 * Constructor parametrizado.<br>
	 * <b>Pre:</b> El parametro nombre debe ser distinto de null y distinto de
	 * vacio.<br>
	 * <b>Post:</b> Se crea un objeto de tipo Pokemon Legendario.<br>
	 * 
	 * @param nombre de tipo String: Nombre que se le asignara al Pokemon.
	 */
	public PokemonLegendario(String nombre) {
		super(nombre);
	}

	/**
	 * Método que se encarga de no permitir la clonación de los pokemones
	 * legendarios.<br>
	 * 
	 * @throws CloneNotSupportedException : Se lanzará siempre que se intente clonar
	 *                                    un pokémon legendario.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Toolkit.getDefaultToolkit().beep();
		IVista.muestraMensajeAlerta("No se puede clonar un pokémon legendario o un entrenador en posesión de uno");
		throw new CloneNotSupportedException("");

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
