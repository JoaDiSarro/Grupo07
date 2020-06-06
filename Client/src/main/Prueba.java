package main;

import controlador.ControladorRegistroDeParticipantes;

import exceptions.SinCartasDisponiblesException;

import java.util.ArrayList;

import modeloClases.Carta;
import modeloClases.CartaNiebla;
import modeloClases.CartaTormenta;
import modeloClases.CartaViento;
import modeloClases.Entrenador;
import modeloClases.Pokemon;
import modeloClases.PokemonFactory;
import modeloClases.Torneo;

import vista.RegistroDeParticipantes;

import vista.interfacesVista.IVistaRegistroParticipantes;

public class Prueba {
    public static PokemonFactory factory = new PokemonFactory();
    public Prueba() {
        super();
    }

    public static void main(String[] args) {
        Prueba prueba = new Prueba();
        IVistaRegistroParticipantes vistaPrincipal = new RegistroDeParticipantes();
        ControladorRegistroDeParticipantes controladorPrincipal = new ControladorRegistroDeParticipantes(vistaPrincipal);
        vistaPrincipal.setControlador(controladorPrincipal);
        vistaPrincipal.abrir();
//Probando si anda 
//CREACION POKEMON
/*
        Pokemon p1 = factory.creaPokemon("Pikachu", "Comun", "Agua");
        Pokemon p1clon = null;

        Pokemon p2 = factory.creaPokemon("Pikacha", "Legendario", "Agua");
        Pokemon p2clon = null;

        Pokemon p3 = factory.creaPokemon("Pikachin", "Comun", "Tierra");
        Pokemon p3clon = null;

        Pokemon p4 = factory.creaPokemon("Pikachon", "Legendario", "Tierra");
        Pokemon p4clon = null;

        Pokemon p5 = factory.creaPokemon("Pikachun", "Comun", "Fuego");
        Pokemon p5clon = null;

        Pokemon p6 = factory.creaPokemon("Pikachi", "Legendario", "Fuego");
        Pokemon p6clon = null;

        Pokemon p7 = factory.creaPokemon("Pikache", "Comun", "Electrico");
        Pokemon p7clon = null;

        Pokemon p8 = factory.creaPokemon("Pikachen", "Legendario", "Electrico");
        Pokemon p8clon = null;

        Pokemon p9 = factory.creaPokemon("Pikapika", "Comun", "Hielo");
        Pokemon p9clon = null;

        Pokemon p10 = factory.creaPokemon("Pik", "Legendario", "Hielo");
        Pokemon p10clon = null;

        Pokemon p11 = factory.creaPokemon("pikipaka", "Comun", "Hielo Recargado");
        Pokemon p11clon = null;
        
//MUESTRA POKEMONES
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println(p6.toString());
        System.out.println(p7.toString());
        System.out.println(p8.toString());
        System.out.println(p9.toString());
        System.out.println(p10.toString());
        System.out.println(p11.toString());
        
//CLONACION POKEMONES
        
                try {
			p1clon=(Pokemon) p1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p2clon=(Pokemon) p2.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p3clon=(Pokemon) p3.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p4clon=(Pokemon) p4.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p5clon=(Pokemon) p5.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
        try {
			p6clon=(Pokemon) p6.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p7clon=(Pokemon) p7.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
        try {
			p8clon=(Pokemon) p8.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p9clon=(Pokemon) p9.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p10clon=(Pokemon) p10.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p11clon=(Pokemon) p11.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
    
        //MUESTRA POKEMONES CLONADOS
            
                    //Se comentan los métodos que no se pueden clonar, es decir, pokemones legendarios
                System.out.println(p1clon.toString());
                //System.out.println(p2clon.toString());
                System.out.println(p3clon.toString());
                //System.out.println(p4clon.toString());
                System.out.println(p5clon.toString());
                //System.out.println(p6clon.toString());
                System.out.println(p7clon.toString());
                //System.out.println(p8clon.toString());
                System.out.println(p9clon.toString());
                //System.out.println(p10clon.toString());
                System.out.println(p11clon.toString());
           
//CREACION DE CARTAS
                
        Carta cartaNiebla = new CartaNiebla();
        Carta cartaTormenta = new CartaTormenta();
        Carta cartaViento = new CartaViento();
        
//CREACION DE MAZO DE CARTAS
        
        ArrayList<Carta> mazo = new ArrayList<>();
        mazo.add(cartaNiebla);
        mazo.add(cartaTormenta);
        mazo.add(cartaViento);
                
//CREACION DE ENTRENADORES
        Entrenador e1 = new Entrenador("Pedro0",3);
        Entrenador e2 = new Entrenador("Pedro1",2);
        Entrenador e3 = new Entrenador("Pedro2",3);
        Entrenador e4 = new Entrenador("Pedro3",3);
        Entrenador e5 = new Entrenador("Pedro4",2);
        Entrenador e6 = new Entrenador("Pedro5",3);
        Entrenador e7 = new Entrenador("Pedro6",3);
        Entrenador e8 = new Entrenador("Pedro7",2);
        Entrenador e9 = new Entrenador("Pedro8",3);
        Entrenador e10 = new Entrenador("Pedro9",3);
        Entrenador e11 = new Entrenador("Pedro10",3);
        Entrenador e12 = new Entrenador("Pedro11",4);
        Entrenador e13 = new Entrenador("Pedro12",3);
        Entrenador e14 = new Entrenador("Pedro13",5);
        Entrenador e15 = new Entrenador("Pedro14",3);
        Entrenador e16 = new Entrenador("Pedro15",6);
        
//ASIGNACION DE CARTAS A LOS ENTRENADORES
        
        e1.setMazo(mazo);
        e2.setMazo(mazo);
        e3.setMazo(mazo);
        e4.setMazo(mazo);
        e5.setMazo(mazo);
        e6.setMazo(mazo);
        e7.setMazo(mazo);
        e8.setMazo(mazo);
        e9.setMazo(mazo);
        e10.setMazo(mazo);
        e11.setMazo(mazo);
        e12.setMazo(mazo);
        e13.setMazo(mazo);
        e14.setMazo(mazo);
        e15.setMazo(mazo);
        e16.setMazo(mazo);
               
//ASIGNACION DE POKEMONES A LOS ENTRENADORES
        
        generaDatosEntrenador(e1);
        generaDatosEntrenador(e2);
        generaDatosEntrenador(e3);
        generaDatosEntrenador(e4);
        generaDatosEntrenador(e5);
        generaDatosEntrenador(e6);
        generaDatosEntrenador(e7);
        generaDatosEntrenador(e8);
        generaDatosEntrenador(e9);
        generaDatosEntrenador(e10);
        generaDatosEntrenador(e11);
        generaDatosEntrenador(e12);
        generaDatosEntrenador(e13);
        generaDatosEntrenador(e14);
        generaDatosEntrenador(e15);
        generaDatosEntrenador(e16);
        
     
//CLONACION DE ENTRENADOR
        
        Entrenador entrenadorAClonar = new Entrenador("EntrenadorAClonar",4);
        entrenadorAClonar.setMazo(mazo);
        entrenadorAClonar.agregaPokemon(factory.creaPokemon("Pikachu", "Legendario", "tierra"));
        Entrenador entrenadorClon = null;
        
        try {
            entrenadorClon=(Entrenador) entrenadorAClonar.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e.getMessage());
            }
        
//CREACION DE TORNEO
        
        Torneo torneo = Torneo.getInstance(); 
        
//SE ASIGNAN LOS ENTRENDORES AL TORNEO
        
        torneo.agregaEntrenador(e1);
        torneo.agregaEntrenador(e2);
        torneo.agregaEntrenador(e3);
        torneo.agregaEntrenador(e4);
        torneo.agregaEntrenador(e5);
        torneo.agregaEntrenador(e6);
        torneo.agregaEntrenador(e7);
        torneo.agregaEntrenador(e8);
        torneo.agregaEntrenador(e9);
        torneo.agregaEntrenador(e10);
        torneo.agregaEntrenador(e11);
        torneo.agregaEntrenador(e12);
        torneo.agregaEntrenador(e13);
        torneo.agregaEntrenador(e14);
        torneo.agregaEntrenador(e15);
        torneo.agregaEntrenador(e16);
        
//COMIENZA EL TORNEO
        
        torneo.ejecutaTorneo();        
        */
} //ES LA DEL MAIN
                  
    public static void generaDatosEntrenador(Entrenador entrenador){
        entrenador.agregaPokemon(factory.creaPokemon("Pikachu1", "Comun", "tierra"));
        entrenador.agregaPokemon(factory.creaPokemon("Pikachu2", "Comun", "hielo recargado"));
        //entrenador.agregaPokemon(factory.creaPokemon("Pikachu3", "Comun", "agua"));
        //entrenador.agregaPokemon(factory.creaPokemon("Pikachu4", "Comun", "fuego"));
        //entrenador.agregaPokemon(factory.creaPokemon("Pikachu5", "Comun", "Electrico"));
    }
}
