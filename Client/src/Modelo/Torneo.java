package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ivo Vucetic<br>
 * 
 *         Esta clase representa el funcionamiento de un torneo eliminatorio
 *         para 8 competidores. Cuenta con el conjunto de entrenadores que
 *         participaran en dicho torneo, el nombre del torneo, una variable que
 *         hara referencia a una sola instancia del torneo y una lista con las
 *         rondas del mismo.
 */
public class Torneo
{
	private String nombre;
	private ArrayList<Entrenador> listaEntrenadores;
	private static Torneo instanceTorneo = null;
	private ArrayList<Ronda> listaRondas;

	/**
	 * Constructor para iniciar la lista que contendra a los entrenadores y las
	 * rondas. <br>
	 */
	private Torneo()
	{
		this.listaEntrenadores = new ArrayList<Entrenador>();
		this.listaRondas = new ArrayList<Ronda>();
	}

	/**
	 * Este m�todo nos devuelve una instancia �nica del torneo. <br>
	 * 
	 * @return Referencia de tipo Torneo
	 */
	public static Torneo getInstance()
	{
		if (Torneo.instanceTorneo == null)
			Torneo.instanceTorneo = new Torneo();
		return instanceTorneo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * Estem m�todo se encarga de agregar un entrenador a la lista de los mismos.
	 * <br>
	 */
	public void agregaEntrenador(Entrenador entrenador)
	{
		this.listaEntrenadores.add(entrenador);
	}

	/**
	 * Este m�todo se encarga de crear la ronda para luego delegar el trabajo de
	 * iniciarla. <br>
	 * <b>Pre:</b> numero >= 0
	 * 
	 * @param numero: Representa la actual.
	 */
	public void creaRonda(int numero)
	{
		Ronda nuevaRonda = new Ronda(numero);
		if (numero == 1)
			nuevaRonda.Inicia(listaEntrenadores);
		else
			nuevaRonda.Inicia(listaRondas.get(numero - 2).getListaGanadores());
		listaRondas.add(nuevaRonda);
	}

}

