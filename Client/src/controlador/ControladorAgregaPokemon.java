package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.interfacesVista.IVistaAgregaPokemon;

public class ControladorAgregaPokemon implements ActionListener{
    private IVistaAgregaPokemon vista;
    
    public ControladorAgregaPokemon(IVistaAgregaPokemon vista) {
        this.vista = vista;      
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // TODO Implement this method
    }
}
