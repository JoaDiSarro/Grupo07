package modeloClases;

import interfaces.Hechizable;
import interfaces.ICarta;

public class CartaNiebla implements ICarta {

	public void hechizar(Hechizable hechizable) {
		hechizable.hechizarNiebla();
	}

}
