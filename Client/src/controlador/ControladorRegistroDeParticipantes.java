package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.AgregaEntrenador;
import vista.interfacesVista.IVista;
import vista.interfacesVista.IVistaAgregaEntrenador;
import vista.interfacesVista.IVistaRegistroParticipantes;

public class ControladorRegistroDeParticipantes implements ActionListener{
    private IVistaRegistroParticipantes vista;
    
    public ControladorRegistroDeParticipantes(IVistaRegistroParticipantes vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equalsIgnoreCase(vista.AGREGARENTRENADOR)){
            vista.cerrar();
            abreVistaAgregaEntrenador();
        }else if(actionEvent.getActionCommand().equalsIgnoreCase(vista.CLONAENTRENADOR)){
            System.out.println("Clona Entrenador");
        }else if(actionEvent.getActionCommand().equalsIgnoreCase(vista.AGREGARPOKEMON)){
            System.out.println("Agregar Pokemon");
        }else if(actionEvent.getActionCommand().equalsIgnoreCase(vista.CLONAPOKEMON)){
            System.out.println("Clona Pokemon");
        }else if(actionEvent.getActionCommand().equalsIgnoreCase(vista.INICIARTORNEO)){
            System.out.println("Iniciar Torneo");
        }
    }
    
    public void abreVistaAgregaEntrenador(){
        IVistaAgregaEntrenador vista = new AgregaEntrenador();
        ControladorAgregaEntrenador controlador = new ControladorAgregaEntrenador(vista);
        vista.setControlador(controlador);
        vista.abrir();
    }
}
