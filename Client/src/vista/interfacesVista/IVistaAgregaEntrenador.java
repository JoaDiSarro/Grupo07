package vista.interfacesVista;

import javax.swing.JButton;

public interface IVistaAgregaEntrenador extends IVista {
	
    static final String AGREGARPOKEMON = "AgregarPokemon";
    static final String ACEPTAR = "Aceptar";
    
    public String getNombreEntrenador();
    public int getCantidadDeCartas();
}
