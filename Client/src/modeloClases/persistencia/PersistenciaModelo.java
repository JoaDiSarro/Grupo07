package modeloClases.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Di Sarro,Joaquina.<br>
 *         Clase que representa la persistencia del modelo.<br>
 */
public class PersistenciaModelo<T extends Serializable> {
	private final String nombreArchivo = "DatosTorneo.txt";

	/**
	 * Método utilizado para guardar datos en un archivo serializado.<br>
	 * 
	 * @param objeto de tipo T: Representa el tipo de archivo donde se
	 *               serializará.<br>
	 */
	public void guardar(T objeto) {
		try {
			FileOutputStream fileOutput = new FileOutputStream(nombreArchivo, false);
			ObjectOutputStream output = new ObjectOutputStream(fileOutput);
			output.writeObject(objeto);
			fileOutput.close();
			output.close();
		} catch (IOException e) {
			System.out.println("Falla al interactuar con el archivo");
		}
	}

	/**
	 * Método utilizado para leer datos desde un archivo serializado.<br>
	 * 
	 * @return objetoLeido de tipo T: Representa el archivo leído.<br>
	 */
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
