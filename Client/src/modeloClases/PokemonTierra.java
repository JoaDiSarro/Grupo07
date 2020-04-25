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
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.<br>
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento tierra.<br>
     * @param pokemon : Pokemon al que se lo decora con el elemento tierra.<br>
     */
    public PokemonTierra(Pokemon pokemon) {
    	super(pokemon,600,40,120);
    }
    
    /**
     * Metodo por el cual el Pokemon de Tierra recupera toda su fuerza inicial.<br>
     * <b>Post:</b> El pokemon setea su fuerza a 40 por defecto.<br>
     */
    public void terminaCansancio(){
    	super.pokemon.fuerza = 40;    
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico realiza una recarga de su fuerza completa.<br>
     * <b>Post:</b> Su fuerza aumenta a 40.<br>
     */
    public void recarga(){
    	super.pokemon.fuerza = 40;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Tierra le provoca a su adversario un daño igual a su fuerza mas un 40%.<br>
     * Conserva su fuerza.<br>
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> El pokemon de tierra le realiza un daño al pokemon pasado como parametro.<br>
     * @param pokemon : pokemon al cual le realizaremos daño.<br>
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(super.pokemon.fuerza*1.4);
    }
    
    /**
     * Metodo por el cual el Pokemon de Tierra recibe daño.<br>
     * El escudo es el encargado de absorver todo el daño y solo cuando este se agota, comienza a decrementarse la vitalidad.<br>
     * <b>Pre:</b> El daño pasado como parametro debe ser distinto de null.<br>
     * <b>Post:</b> El Pokemon de Tierra recibe cierta cantidad de daño. Existe la posibilidad de que muera.<br>
     * @param daño : valor del impacto recibido.<br>
     */
    public void recibeDaño(double daño){
        if(daño < super.pokemon.escudo)
        	super.pokemon.escudo -= daño;
        else if(super.pokemon.vitalidad > (daño-super.pokemon.escudo)){
        	super.pokemon.vitalidad = daño - super.pokemon.escudo;
        	super.pokemon.escudo = 0;
        }//else
            //Reveer que sucede si muere      
    }

    
    /**
     *Método que aplica el efecto de la carta de niebla al pokémon de tierra.<br>
     *Reduce las estadísticas de combate un 20% de su vitalidad actual.<br>
     *Si el porcentaje de vitalidad es mayor al escudo, éste se vuelve 0.<br>
     *Si el porcentaje de vitalidad es mayor o igual a la fuerza, ésta se vuelve 1.<br>
     */
    @Override
    public void hechizarNiebla() {
    	double auxVitalidad = super.pokemon.vitalidad*0.2;
    	
        if (auxVitalidad>=super.pokemon.fuerza)
        	super.pokemon.fuerza=1;
        else
        	super.pokemon.fuerza-=auxVitalidad;
        if (auxVitalidad>super.pokemon.escudo)
        	super.pokemon.escudo=0;
        else
        	super.pokemon.escudo-=auxVitalidad;
        super.pokemon.vitalidad-=auxVitalidad;
    }

    
    /**
     *Método que aplica el efecto de la carta de viento al pokémon de tierra.<br>
     *Reduce la fuerza actual un 20%.<br>
     */
    @Override
    public void hechizarViento() {
    	super.pokemon.fuerza*=0.8;
    }

    
    /**
     *Método que aplica el efecto de la carta de tormenta al pokémon de tierra.<br>
     *Resta de la vitalidad la cantidad actual de escudo.<br>
     *Si el escudo es mayor o igual a la vitalidad, ésta se vuelve 1.<br>
     */
    @Override
    public void hechizarTormenta() {
        if (super.pokemon.escudo>=super.pokemon.vitalidad)
        	super.pokemon.vitalidad=1;
        else
        	super.pokemon.vitalidad-=super.pokemon.escudo;
    }
}
