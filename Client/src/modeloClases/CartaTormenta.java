package modeloClases;

public class CartaTormenta implements ICarta{
    public CartaTormenta() {
        super();
    }

    @Override
    public void hechizar(IHechizable hechizable) {
        hechizable.hechizarTormenta();
    }
}
