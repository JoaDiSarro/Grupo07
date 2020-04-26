package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase final que extiende de PokemonDecorator donde se decora a un Pokemon brindandole las funcionalidades pertenecientes al elemento Agua.
 */
public final class PokemonAgua extends PokemonDecorator {

    /**
     * Metodo constructor parametrizado<br>
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.<br>
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento agua.<br>
     * @param pokemon de tipo Pokemon: Pokemon al que se lo decora con el elemento agua.
     */
    public PokemonAgua(Pokemon pokemon) {
    	super(pokemon,500,120,100);
    }

    /**
     * Metodo por el cual el Pokemon de Agua recupera toda su fuerza inicial.<br>
     * <b>Post:</b> El pokemon setea su fuerza a 120 por defecto.
     */
    public void terminaCansancio(){
        this.pokemon.fuerza = 120;
    }

    /**
     * Metodo por el cual el Pokemon de Agua realiza una recarga de su fuerza y vitalidad.<br>
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 10%.
     */
    public void recarga(){
    	this.pokemon.fuerza *= 1.1;
    	this.pokemon.vitalidad *= 1.1;
    }

    /**
     * Metodo por el cual el Pokemon de Agua le provoca a su adversario un daño igual a su fuerza.<br>
     * Luego su fuerza se reduce a la mitad.<br>
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> El pokemon de Agua le realiza un daño al pokemon pasado como parametro. Luego disminuye su fuerza un 50%.<br>
     * @param pokemon de tipo Pokemon : Pokemon al cual le realizaremos daño.
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.pokemon.fuerza);
        this.pokemon.fuerza *= 0.5;
    }

    /**
     * Metodo por el cual el Pokemon de Agua recibe daño.<br>
     * El escudo es el encargado de absorver todo el daño y solo cuando este se agota, comienza a decrementarse la vitalidad.<br>
     * <b>Pre:</b> El daño pasado como parametro debe ser distinto de null.<br>
     * <b>Post:</b> El Pokemon de Agua recibe cierta cantidad de daño. Existe la posibilidad de que muera.<br>
     * @param daño de tipo double: Valor del impacto recibido.
     */
    public void recibeDaño(double daño){
        if(daño < this.pokemon.escudo)
        	this.pokemon.escudo -= daño;
        else if(this.pokemon.vitalidad > (daño-this.pokemon.escudo)){
        	this.pokemon.vitalidad = daño - this.pokemon.escudo;
        	this.pokemon.escudo = 0;
        }
        else
        	this.pokemon.vitalidad=0;   
    }

    
    /**
     *Método que aplica el efecto de la carta de niebla al pokémon de agua.<br>
     *Reduce las estadísticas de combate un 7%. <br>
     * <b>Post:</b> El Pokemon de Agua se hechiza por la carta Niebla, disminuyendo su fuerza, escudo y vitalidad un 7%.
     */
    @Override
    public void hechizarNiebla() {
    	this.pokemon.fuerza*=0.93;
    	this.pokemon.escudo*=0.93;
    	this.pokemon.vitalidad*=0.93;
    }

    /**
     *Método que aplica el efecto de la carta de viento al pokémon de agua.<br>
     * Disminuye la fuerza un 50% del escudo actual.<br>
     * En caso de ser mayor o igual esa cantidad de escudo a la fuerza, la deja en 1.<br>
     * <b>Post:</b> El Pokemon de Agua se hechiza por la carta Viento.
     */
    @Override
    public void hechizarViento() {
    	if (this.pokemon.escudo*0.5 >= this.pokemon.fuerza)
    		this.pokemon.fuerza=1;
    	else
    		this.pokemon.fuerza-= this.pokemon.escudo*0.5;
    }

    /**
     *Método que aplica el efecto de la carta de tormenta al pokémon de agua.<br> 
     *Disminuye el escudo en un 20%.<br>
     * <b>Post:</b> El Pokemon de Agua se hechiza por la carta Tormenta, disminuyendo su escudo un 20%.
     */
    @Override
    public void hechizarTormenta() {
    	this.pokemon.escudo*=0.8;
    }

	/**
	 *Sobreescritura del metodo toString. Se utiliza para mostrar los atributos de un pokémon de agua.
	 */
	@Override
	public String toString() {
		return super.toString()+" / "+" Elemento: Agua";
	}
    
    
}
