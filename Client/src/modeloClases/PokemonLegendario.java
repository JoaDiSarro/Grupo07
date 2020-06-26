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
	 * M�todo que se encarga de no permitir la clonaci�n de los pokemones
	 * legendarios.<br>
	 * 
	 * @throws CloneNotSupportedException : Se lanzar� siempre que se intente clonar
	 *                                    un pok�mon legendario.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Toolkit.getDefaultToolkit().beep();
		IVista.muestraMensajeAlerta("No se puede clonar un pok�mon legendario o un entrenador en posesi�n de uno");
		throw new CloneNotSupportedException("");

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
