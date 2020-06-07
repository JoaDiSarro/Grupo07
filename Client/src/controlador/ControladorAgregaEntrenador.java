package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modeloClases.Torneo;

import vista.VistaAgregaPokemon;

import vista.interfacesVista.IVistaAgregaEntrenador;
import vista.interfacesVista.IVistaAgregaPokemon;

public class ControladorAgregaEntrenador implements ActionListener{
    
    private IVistaAgregaEntrenador vista;
    private Torneo torneo;
    
    public ControladorAgregaEntrenador(IVistaAgregaEntrenador vista) {
        this.vista = vista;
        torneo = Torneo.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand().equalsIgnoreCase(vista.ACEPTAR)){
            String nombre = vista.getNombre();
            if(nombre != null && !nombre.isEmpty())
                //torneo.nuevoEntrenador(nombre);
                //TODO:agregar la cantidad de cartas iniciales, debe estar en la vista. Falta agregar.
                torneo.agregaEntrenador(nombre,0);
            else
                vista.muestraMensajeAlerta("Ingrese un nombre valido");
        }else if(evento.getActionCommand().equalsIgnoreCase(vista.AGREGARPOKEMON)){
            vista.cerrar();
            abrirVentanaPokemon();
        }
    }
    
    public void abrirVentanaPokemon(){
        IVistaAgregaPokemon vista = new VistaAgregaPokemon();
        ControladorAgregaPokemon controlador = new ControladorAgregaPokemon(vista);
        vista.setControlador(controlador);
        vista.abrir();
    }
}
