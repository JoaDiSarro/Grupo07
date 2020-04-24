package Modelo;

public class Prueba
{
	public static void main(String[] args)
	{
		Torneo torneo = Torneo.getInstance();
		torneo.setNombre("COPA PISTON");
		System.out.println("----------------------------------------");
		System.out.println("-----BIENVENIDOS AL TORNEO"+ torneo.getNombre()+"-----");
		System.out.println("----------------------------------------");
		
		System.out.println("----INSCRIPCION DE ENTRENADORES------");
		torneo.agregaEntrenador(new Entrenador());
		torneo.agregaEntrenador(new Entrenador());
		torneo.agregaEntrenador(new Entrenador());
		torneo.agregaEntrenador(new Entrenador());
		torneo.agregaEntrenador(new Entrenador());
		torneo.agregaEntrenador(new Entrenador());
		torneo.agregaEntrenador(new Entrenador());
		torneo.agregaEntrenador(new Entrenador());
		System.out.println("----TODOS INSCRIPTOS, QUE INICIE EL TORNEO!!----");
		torneo.creaRonda(1);
	}
}
