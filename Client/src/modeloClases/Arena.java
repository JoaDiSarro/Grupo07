package modeloClases;

import modeloClases.state.EnfrentamientoState;
import modeloClases.state.State;

import java.util.Observable;

import modeloClases.state.PreliminarState;

/**
 * @author Di Sarro,Joaquina.<br>
 *         Clase que representa una arena en la cual tendr�n lugar combates
 *         pok�mon.<br>
 */
public class Arena extends Observable {
	private String nombre;
	private boolean batallaEnCurso = false;
	private State estado;

	/**
	 * Constructor de la clase Arena.<br>
	 * 
	 * @param nombre de tipo String: Representa el nombre que tendr� la arena.<br>
	 */
	public Arena(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M�todo encargado de iniciar una batalla pok�mon<br>
	 * <b> Pre: </b> El par�metro debe ser distinto de null.<br>
	 * 
	 * @param modelo de tipo ModeloBatalla: Representa los participantes y sus
	 *               caracter�sticas al momento de iniciar una batalla pok�mon.<br>
	 * @return Entrenador: Representa el entrenador ganador de la batalla
	 *         pok�mon.<br>
	 */
	public synchronized Entrenador inicia(ModeloBatalla modelo) {
		while (batallaEnCurso) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.batallaEnCurso = true;
		estado = new PreliminarState(this);
		estado.ejecutar(modelo);
		while (estado != null) { // Espera hasta que el estado de la arena sea null (Batalla finalizada)
		}
		notifyAll();
		return modelo.getGanador();
	}

	/**
	 * M�todo encargado de terminar una batalla pok�mon.<br>
	 */
	public synchronized void termina() {
		// mientras que la arena no este ocupada, espero
		while (!batallaEnCurso) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.batallaEnCurso = false;
		// System.out.println("\nSaliendo A LA "+this.nombre);
		notifyAll();
	}

	public void setEstado(State estado) {
		this.estado = estado;
	}

	/**
	 * M�todo encargado de iniciar el cambio de estado en una arena.<br>
	 * <b> Pre: </b> El par�metro debe ser distinto de null.<br>
	 * 
	 * @param modelo de tipo ModeloBatalla: Representa el estado de los
	 *               participantes en la arena.<br>
	 */
	public void continua(ModeloBatalla modelo) {
		estado.ejecutar(modelo);
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo encargado de notificar un cambio de estado en la arena a sus
	 * observadores.<br>
	 * 
	 * @param mensaje de tipo String: Mensaje que se env�a a los observadores.<br>
	 */
	public void notificarEstado(String mensaje) {
		setChanged();
		notifyObservers(mensaje);
	}
}
