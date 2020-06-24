package main;

import controlador.ControladorRegistroDeParticipantes;
import modeloClases.PokemonFactory;
import vista.VistaRegistroDeParticipantes;
import vista.interfacesVista.IVistaRegistroParticipantes;

public class Main {
	
public static PokemonFactory factory = new PokemonFactory();
    
    public Main() {
        super();
    }


	public static void main(String[] args) {

		Main main = new Main();
		
		//Abro ventana principal
        IVistaRegistroParticipantes vistaPrincipal = new VistaRegistroDeParticipantes();
        ControladorRegistroDeParticipantes controladorPrincipal = new ControladorRegistroDeParticipantes(vistaPrincipal);
        vistaPrincipal.setControlador(controladorPrincipal);
        vistaPrincipal.abrir();
	}

}
