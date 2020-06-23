package modeloClases.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistenciaModelo<T extends Serializable> {
    private final String nombreArchivo = "DatosTorneo.txt";
    
    public void guardar(T objeto) {
        try {
            FileOutputStream fileOutput = new FileOutputStream(nombreArchivo, false);
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(objeto);
            fileOutput.close();
            output.close();
        }
        catch (IOException e) {
            System.out.println("Falla al interactuar con el archivo");
        }
    }
    
    public T leerDatos() {
        T objetoLeido = null;
        try {
            FileInputStream fileInput = new FileInputStream(nombreArchivo);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            objetoLeido = (T) input.readObject();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            System.out.println("Falla en parseo");
        }
        return objetoLeido;
    }
}
