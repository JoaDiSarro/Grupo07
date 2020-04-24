package Modelo;

/**
 * @author Ivo Vucetic <br>
 *         Esta clase representa uno de los enfrentamientos de los varios que se
 *         dan en cada ronda. Cuenta con dos variables de instancia que hacen
 *         referencia de los entrenadores que lucharán en la misma.
 */
public class Batalla
{
	private Entrenador entrenador1;
	private Entrenador entrenador2;

	/**
	 * Este método incializa ambos entrenadores.
	 * @param entrenador1
	 * @param entrenador2
	 */
	public Batalla(Entrenador entrenador1, Entrenador entrenador2)
	{
		this.entrenador1 = entrenador1;
		this.entrenador2 = entrenador2;
	}
	
	
	public Entrenador iniciaBatalla()
	{
		entrenador1.eligePokemon()
	}

}
