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
     * @param pokemon de tipo Pokemon: Pokemon al que se lo decora con el elemento electrico.<br>
     */
    public PokemonElectrico(Pokemon pokemon) {
    	super(pokemon,400,200,70);
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico recupera toda su fuerza inicial.<br>
     * <b>Post:</b> El pokemon setea su fuerza a 200 por defecto.<br>
     */
    public void terminaCansancio(){
    	this.pokemon.fuerza = 200;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico realiza una recarga de su fuerza y vitalidad.<br>
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 50%.<br>
     */
    public void recarga(){
    	this.pokemon.vitalidad *=1.5;
    	this.pokemon.fuerza *=1.1;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico le provoca a su adversario un da�o igual a su fuerza.<br>
     * Luego su fuerza se reduce un 10%.<br>
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> El pokemon electrico le realiza un da�o al pokemon pasado como parametro. Luego disminuye su fuerza un 10%.<br>
     * @param pokemon de tipo Pokemon: Pokemon al cual le realizaremos da�o.<br>
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.pokemon.fuerza);
        this.pokemon.fuerza *= 0.9;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico recibe da�o.<br>
     * El escudo es el encargado de absorver todo el da�o y solo cuando este se agota, comienza a decrementarse la vitalidad.<br>
     * <b>Pre:</b> El da�o pasado como parametro debe ser distinto de null.<br>
     * <b>Post:</b> El Pokemon Electrico recibe cierta cantidad de da�o. Existe la posibilidad de que muera.<br>
     * @param da�o de tipo double: Valor del impacto recibido.<br>
     */
    public void recibeDa�o(double da�o){
        if(da�o < this.pokemon.escudo)
        	this.pokemon.escudo -= da�o;
        else if(this.pokemon.getVitalidad() > (da�o-this.pokemon.getEscudo())){
        	this.pokemon.setVitalidad( da�o - this.pokemon.getEscudo());
        	this.pokemon.setEscudo(0);
        }else
            this.pokemon.setVitalidad(0);
    }

    
    /**
     *M�todo que aplica el efecto de la carta de niebla al pok�mon el�ctrico.<br>
     *Disminuye las estad�sticas actuales en un 15%.<br>
     * <b>Post:</b> El Pokemon Electrico se hechiza por la carta Niebla.
     */
    @Override
    public void hechizarNiebla() {
    	this.pokemon.escudo*=0.85;
    	this.pokemon.fuerza*=0.85;
    	this.pokemon.vitalidad*=0.85;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de viento al pok�mon el�ctrico.<br>
     *Reduce la fuerza un 20% del escudo actual.<br>
     *En caso de ser mayor o igual esa cantidad de escudo a la fuerza, la deja en 1.<br>
     * <b>Post:</b> El Pokemon Electrico se hechiza por la carta Viento.
     */
    @Override
    public void hechizarViento() {
    	if (this.pokemon.escudo*0.2>=this.pokemon.fuerza)
    		this.pokemon.fuerza=1;
    	else
    		this.pokemon.fuerza-= this.pokemon.escudo*0.2;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon el�ctrico.<br>
     *Reduce la vitalidad en un 10%.<br>
     * <b>Post:</b> El Pokemon Electrico se hechiza por la carta Tormenta.
     */
    @Override
    public void hechizarTormenta() {
    	this.pokemon.vitalidad*=0.9;
    }
    
    /**
     *Sobreescritura del metodo toString. Se utiliza para mostrar los atributos de un pok�mon el�ctrico.
     */
    @Override
	public String toString() {
		return super.toString()+" / "+" Elemento: Electrico";
	}
}
