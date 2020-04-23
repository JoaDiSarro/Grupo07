package Modelo;

import java.util.ArrayList;

/**
 * @author Grupo
 * 
 *         Esta clase representa el funcionamiento de un torneo eliminatorio
 *         para 8 competidores. Cuenta con el conjunto de entrenadores que
 *         participaran en dicho torneo, el nombre del torneo y una
 *         variable que hara referencia a una sola instancia del
 *         torneo.
 */
public class Torneo
{
	private String nombre_torneo;
	private ArrayList<Entrenador> entrenadores;
	private static Torneo instance_torneo = null;
	private ArrayList<Ronda> rondas;
	
	/**
	 * Constructor para iniciar la lista que contendra a los entrenadores.
	 */
	private Torneo()
	{
		this.entrenadores = new ArrayList<Entrenador>();
	}

	/**
	 * Este método nos devuelve una instancia única del torneo.
	 * 
	 * @return Referencia de tipo Torneo
	 */
	public static Torneo getInstance()
	{
		if (Torneo.instance_torneo == null)
			Torneo.instance_torneo = new Torneo();
		return instance_torneo;
	}

	public String getNombre_torneo()
	{
		return nombre_torneo;
	}

	public void setNombre_torneo(String nombre_torneo)
	{
		this.nombre_torneo = nombre_torneo;
	}

	/**
	 * Estem método se encarga de agregar un entrenador a la lista de los mismos.
	 */
	public void AgregaEntrenador(Entrenador entrenador)
	{
		this.entrenadores.add(entrenador);
	}
	
	public void inicia_ronda()
	

}
