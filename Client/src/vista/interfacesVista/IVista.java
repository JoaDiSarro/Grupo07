package vista.interfacesVista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import modeloClases.Entrenador;

public interface IVista {
    
    public void abrir();
    public void cerrar();
    public void setControlador(ActionListener c);
    public void muestraMensajeAlerta(String mensaje);
}
