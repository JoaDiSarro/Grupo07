package modeloClases;

public class CartaNiebla implements ICarta {
    
    public CartaNiebla() {
        super();
    }

    @Override
    public void hechizar(IHechizable hechizable) {
        hechizable.hechizarNiebla();
    }
}
