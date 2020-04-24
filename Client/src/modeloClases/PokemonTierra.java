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
}
