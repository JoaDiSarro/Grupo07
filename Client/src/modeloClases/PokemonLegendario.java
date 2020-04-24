package modeloClases;

 /**
  * @author DiSarro,Joaquina.
  * @version 1.0
  * <br>
  * Esta clase contiene metodos correspondientes a un Pokemon Legendario.<br>
  * La clase extiende de Pokemon y no permite ser clonable.
  */
public class PokemonLegendario extends Pokemon {
    
    /**
     * Constructor parametrizado.<br>
     * <b>Pre:</b> El parametro nombre debe ser distinto de null y distinto de vacio.<br>
     * <b>Post:</b> Se crea un objeto de tipo Pokemon Legendario.<br>
     * @param nombre : nombre que se le asignara al Pokemon.
     */
    public PokemonLegendario(String nombre) {
        super(nombre);
    }

    @Override
    public void terminaCansancio() {
        // TODO Implement this method
    }

    @Override
    public void recarga() {
        // TODO Implement this method
    }

    @Override
    public void golpeFinal(Pokemon pokemon) {
        // TODO Implement this method
    }

    @Override
    public void recibeDaño(double daño) {
        // TODO Implement this method
    }
    
    //@Override
    public void hechizarNiebla() {
        // TODO Implement this method
    }

    //@Override
    public void hechizarViento() {
        // TODO Implement this method
    }

    //@Override
    public void hechizarTormenta() {
        // TODO Implement this method
    }
}

