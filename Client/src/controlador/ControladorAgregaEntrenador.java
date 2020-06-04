package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modeloClases.Sistema;

import vista.AgregaPokemon;

import vista.interfacesVista.IVistaAgregaEntrenador;
import vista.interfacesVista.IVistaAgregaPokemon;

public class ControladorAgregaEntrenador implements ActionListener{
    
    private IVistaAgregaEntrenador vista;
    private Sistema sistema;
    
    public ControladorAgregaEntrenador(IVistaAgregaEntrenador vista) {
        this.vista = vista;
        sistema = Sistema.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getActionCommand().equalsIgnoreCase(vista.ACEPTAR)){
            String nombre = vista.getNombre();
            if(nombre != null && !nombre.isEmpty())
                sistema.nuevoEntrenador(nombre);
            else
                vista.muestraMensajeAlerta("Ingrese un nombre valido");
        }else if(evento.getActionCommand().equalsIgnoreCase(vista.AGREGARPOKEMON)){
            vista.cerrar();
            abrirVentanaPokemon();
        }
    }
    
    public void abrirVentanaPokemon(){
        IVistaAgregaPokemon vista = new AgregaPokemon();
        ControladorAgregaPokemon controlador = new ControladorAgregaPokemon(vista);
        vista.setControlador(controlador);
        vista.abrir();
    }
}
