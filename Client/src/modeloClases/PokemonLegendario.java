package modeloClases;

 /**
  * @author DiSarro,Joaquina.
  * @version 1.0
  * <br>
  * Esta clase contiene metodos correspondientes a un Pokemon Legendario.<br>
  * La clase extiende de Pokemon y no permite ser clonable.
  */
public class PokemonLegendario extends Pokemon implements Cloneable {
    
    /**
     * Constructor parametrizado.<br>
     * <b>Pre:</b> El parametro nombre debe ser distinto de null y distinto de vacio.<br>
     * <b>Post:</b> Se crea un objeto de tipo Pokemon Legendario.<br>
     * @param nombre de tipo String: Nombre que se le asignara al Pokemon.
     */
    public PokemonLegendario(String nombre) {
        super(nombre);
    }
    
    /**
     *Método que se encarga de no permitir la clonación de los pokemones legendarios.<br>
     *@throws CloneNotSupportedException : Se lanzará siempre que se intente clonar un pokémon legendario.
     */
    @Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("No se puede clonar un pokemon legendario");
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

