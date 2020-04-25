package modeloClases;

 /**
  * @author DiSarro,Joaquina.
  * @version 1.0
  * <br>
  * Esta clase contiene metodos correspondientes a un Pokemon Comun.<br>
  * La clase extiende de Pokemon y permite ser clonable.
  */
public class PokemonComun extends Pokemon implements Cloneable {

    /**
     * Constructor parametrizado.<br>
     * <b>Pre:</b> El parametro nombre debe ser distinto de null y distinto de vacio.<br>
     * <b>Post:</b> Se crea un objeto de tipo Pokemon Comun.<br>
     * @param nombre : nombre que se le asignara al Pokemon.
     */
    public PokemonComun(String nombre) {
        super(nombre);
        
    }

    /**
     * Método que clona un pokémon común.<br>
     *@return Retorna el clon de un pokémon común .
     */
    @Override
	public Object clone() {
		
		Object clon=null;
		try {
			return super.clone();
		} 
		catch (CloneNotSupportedException e) {
			//Nunca entro aca
		}
		return clon;
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

   // @Override
    public void hechizarViento() {
        // TODO Implement this method
    }

    //@Override
    public void hechizarTormenta() {
        // TODO Implement this method
    }

}
