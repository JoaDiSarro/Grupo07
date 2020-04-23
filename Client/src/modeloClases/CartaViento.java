package modeloClases;

public class CartaViento implements ICarta{
    public CartaViento() {
        super();
    }
    
    @Override
    public void hechizar(IHechizable hechizable) {
        hechizable.hechizarViento();
    }
}
