package vista.interfacesVista;

import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modeloClases.Entrenador;

public interface IVista {
    
    public void abrir();
    public void cerrar();
    public void setControlador(ActionListener c);
    
    public static void muestraMensajeAlerta(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
