package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase final que extiende de PokemonDecorator donde se decora a un Pokemon brindandole las funcionalidades pertenecientes al elemento Electrico.
 */
public final class PokemonElectrico extends PokemonDecorator {
    
    /**
     * Metodo constructor parametrizado<br>
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.<br>
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento electrico.<br>
     * @param pokemon : Pokemon al que se lo decora con el elemento electrico.<br>
     */
    public PokemonElectrico(Pokemon pokemon) {
    	super(pokemon,400,200,70);
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico recupera toda su fuerza inicial.<br>
     * <b>Post:</b> El pokemon setea su fuerza a 200 por defecto.<br>
     */
    public void terminaCansancio(){
    	super.pokemon.fuerza = 200;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico realiza una recarga de su fuerza y vitalidad.<br>
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 50%.<br>
     */
    public void recarga(){
    	super.pokemon.vitalidad *=1.5;
    	super.pokemon.fuerza *=1.1;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico le provoca a su adversario un daño igual a su fuerza.<br>
     * Luego su fuerza se reduce un 10%.<br>
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> El pokemon electrico le realiza un daño al pokemon pasado como parametro. Luego disminuye su fuerza un 10%.<br>
     * @param pokemon : pokemon al cual le realizaremos daño.<br>
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(super.pokemon.fuerza);
        super.pokemon.fuerza *= 0.9;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico recibe daño.<br>
     * El escudo es el encargado de absorver todo el daño y solo cuando este se agota, comienza a decrementarse la vitalidad.<br>
     * <b>Pre:</b> El daño pasado como parametro debe ser distinto de null.<br>
     * <b>Post:</b> El Pokemon Electrico recibe cierta cantidad de daño. Existe la posibilidad de que muera.<br>
     * @param daño : valor del impacto recibido.<br>
     */
    public void recibeDaño(double daño){
        if(daño < super.pokemon.escudo)
        	super.pokemon.escudo -= daño;
        else if(super.pokemon.vitalidad > (daño-super.pokemon.escudo)){
        	super.pokemon.vitalidad = daño - super.pokemon.escudo;
        	super.pokemon.escudo = 0;
        }else
            super.pokemon.vitalidad = 0;
    }

    
    /**
     *Método que aplica el efecto de la carta de niebla al pokémon eléctrico.<br>
     *Disminuye las estadísticas actuales en un 15%.<br>
     * <b>Post:</b> El Pokemon Electrico se hechiza por la carta Niebla.
     */
    @Override
    public void hechizarNiebla() {
    	super.pokemon.escudo*=0.85;
    	super.pokemon.fuerza*=0.85;
    	super.pokemon.vitalidad*=0.85;
    }

    
    /**
     *Método que aplica el efecto de la carta de viento al pokémon eléctrico.<br>
     *Reduce la fuerza un 20% del escudo actual.<br>
     *En caso de ser mayor o igual esa cantidad de escudo a la fuerza, la deja en 1.<br>
     * <b>Post:</b> El Pokemon Electrico se hechiza por la carta Viento.
     */
    @Override
    public void hechizarViento() {
    	if (super.pokemon.escudo*0.2>=super.pokemon.fuerza)
    		super.pokemon.fuerza=1;
    	else
    		super.pokemon.fuerza-= super.pokemon.escudo*0.2;
    }

    
    /**
     *Método que aplica el efecto de la carta de tormenta al pokémon eléctrico.<br>
     *Reduce la vitalidad en un 10%.<br>
     * <b>Post:</b> El Pokemon Electrico se hechiza por la carta Tormenta.
     */
    @Override
    public void hechizarTormenta() {
    	super.pokemon.vitalidad*=0.9;
    }
    
    @Override
	public String toString() {
		return super.toString()+" / "+" Elemento: Electrico";
	}
}
