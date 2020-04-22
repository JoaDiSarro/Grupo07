package modeloClases;

import interfaces.Hechizable;
import interfaces.ICarta;

public class CartaTormenta implements ICarta {

	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarTormenta();
	}

}
