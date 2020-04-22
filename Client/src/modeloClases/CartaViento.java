package modeloClases;

import interfaces.Hechizable;
import interfaces.ICarta;

public class CartaViento implements ICarta {

	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarViento();
	}

}
