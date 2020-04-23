package Modelo;

public class main
{

	public static void main(String[] args)
	{
		Torneo nuevo_torneo = Torneo.getInstance();
		nuevo_torneo.setNombre_torneo("COPA PISTON");
		System.out.println("----------------------------------------");
		System.out.println("-----BIENVENIDOS AL TORNEO"+ nuevo_torneo.getNombre_torneo()+"-----");
		System.out.println("----------------------------------------");
		
		System.out.println("----INSCRIPCION DE ENTRENADORES------");
		nuevo_torneo.AgregaEntrenador(new Entrenador());
		nuevo_torneo.AgregaEntrenador(new Entrenador());
		nuevo_torneo.AgregaEntrenador(new Entrenador());
		nuevo_torneo.AgregaEntrenador(new Entrenador());
		nuevo_torneo.AgregaEntrenador(new Entrenador());
		nuevo_torneo.AgregaEntrenador(new Entrenador());
		nuevo_torneo.AgregaEntrenador(new Entrenador());
		nuevo_torneo.AgregaEntrenador(new Entrenador());
		System.out.println("----TODOS INSCRIPTOS, QUE INICIE EL TORNEO!!----");
		nuevo_torneo.iniciaRonda("ronda1");

	}

}
