package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase final que extiende de PokemonDecorator donde se decora a un Pokemon brindandole las funcionalidades pertenecientes al elemento Tierra.
 */
public final class PokemonTierra extends PokemonDecorator {
    
    /**
     * Metodo constructor parametrizado<br>
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento tierra.
     * @param pokemon : Pokemon al que se lo decora con el elemento tierra.
     */
    public PokemonTierra(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 600;
        this.escudo = 120;
        this.fuerza = 40;
    }
    
    /**
     * Metodo por el cual el Pokemon de Tierra recupera toda su fuerza inicial.
     * <b>Post:</b> El pokemon setea su fuerza a 40 por defecto.
     */
    public void terminaCansancio(){
        this.fuerza = 40;    
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico realiza una recarga de su fuerza completa.
     * <b>Post:</b> Su fuerza aumenta a 40.
     */
    public void recarga(){
        this.fuerza = 40;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Tierra le provoca a su adversario un da�o igual a su fuerza mas un 40%.<br>
     * Conserva su fuerza.
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> El pokemon de tierra le realiza un da�o al pokemon pasado como parametro.
     * @param pokemon : pokemon al cual le realizaremos da�o.
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.fuerza*1.4);
    }
    
    /**
     * Metodo por el cual el Pokemon de Tierra recibe da�o.<br>
     * El escudo es el encargado de absorver todo el da�o y solo cuando este se agota, comienza a decrementarse la vitalidad.
     * <b>Pre:</b> El da�o pasado como parametro debe ser distinto de null.
     * <b>Post:</b> El Pokemon de Tierra recibe cierta cantidad de da�o. Existe la posibilidad de que muera.
     * @param da�o : valor del impacto recibido.
     */
    public void recibeDa�o(double da�o){
        if(da�o < this.escudo)
            this.escudo -= da�o;
        else if(this.vitalidad > (da�o-this.escudo)){
            this.vitalidad = da�o - this.escudo;
            this.escudo = 0;
        }//else
            //Reveer que sucede si muere      
    }

    
    /**
     *M�todo que aplica el efecto de la carta de niebla al pok�mon de tierra.<br>
     *Reduce las estad�sticas de combate un 20% de su vitalidad actual.<br>
     *Si el porcentaje de vitalidad es mayor al escudo, �ste se vuelve 0.<br>
     *Si el porcentaje de vitalidad es mayor o igual a la fuerza, �sta se vuelve 1.<br>
     */
    @Override
    public void hechizarNiebla() {
    	double auxVitalidad = this.vitalidad*0.2;
    	
        if (auxVitalidad>=this.fuerza)
        	this.fuerza=1;
        else
        	this.fuerza-=auxVitalidad;
        if (auxVitalidad>this.escudo)
        	this.escudo=0;
        else
        	this.escudo-=auxVitalidad;
        this.vitalidad-=auxVitalidad;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de viento al pok�mon de tierra.<br>
     *Reduce la fuerza actual un 20%.<br>
     */
    @Override
    public void hechizarViento() {
        this.fuerza*=0.8;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon de tierra.<br>
     *Resta de la vitalidad la cantidad actual de escudo.<br>
     *Si el escudo es mayor o igual a la vitalidad, �sta se vuelve 1.<br>
     */
    @Override
    public void hechizarTormenta() {
        if (this.escudo>=this.vitalidad)
        	this.vitalidad=1;
        else
        	this.vitalidad-=this.escudo;
    }
}
