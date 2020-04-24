package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Ivo Vucetic <br>
 *         Esta clase cuenta con una variable de instancia numero, que
 *         representa la ronda actual y una lista de los ganadores de cada
 *         batalla.
 *
 */
public class Ronda
{
	private int numero;
	private ArrayList<Entrenador> listaGanadores;

	/**
	 * Constructor que inicializa la ronda actual, junto con la lista
	 * corresponiente.<br>
	 * 
	 * @param numeroR: Ronda actual
	 */
	public Ronda(int numeroR)
	{
		this.numero = numeroR;
		this.listaGanadores = new ArrayList<Entrenador>();
	}

	/**
	 * Este método recibe como parámetro a los entrenadores que lucharán en la
	 * ronda. Se encarga de organizar las batallas y de guardar solo los participantes
	 * que ganan, los participantes que pierden son eliminados del torneo. <br>
	 * <b>Pre:</b> La colección debe estar previamente inicializada.
	 * 
	 * @param entrenadores: Colección de los mismos que participarán en la ronda.
	 */
	public void Inicia(ArrayList<Entrenador> entrenadores)
	{

		Iterator<Entrenador> it = entrenadores.iterator();

		while (it.hasNext())
		{
			Batalla nuevaBatalla = new Batalla(it.next(), it.next());
			listaGanadores.add(nuevaBatalla.iniciaBatalla());
		}
	}

	public ArrayList<Entrenador> getListaGanadores()
	{
		return listaGanadores;
	}

}
