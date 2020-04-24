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
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento agua.
     * @param pokemon : Pokemon al que se lo decora con el elemento agua.
     */
    public PokemonAgua(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 500;
        this.escudo = 100;
        this.fuerza = 120;
    }

    /**
     * Metodo por el cual el Pokemon de Agua recupera toda su fuerza inicial.
     * <b>Post:</b> El pokemon setea su fuerza a 120 por defecto.
     */
    public void terminaCansancio(){
        this.fuerza = 120;
    }

    /**
     * Metodo por el cual el Pokemon de Agua realiza una recarga de su fuerza y vitalidad.
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 10%.
     */
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;
    }

    /**
     * Metodo por el cual el Pokemon de Agua le provoca a su adversario un daño igual a su fuerza.<br>
     * Luego su fuerza se reduce a la mitad.
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> El pokemon de Agua le realiza un daño al pokemon pasado como parametro. Luego disminuye su fuerza un 50%.
     * @param pokemon : pokemon al cual le realizaremos daño.
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza);
        this.fuerza *= 0.5;
    }

    /**
     * Metodo por el cual el Pokemon de Agua recibe daño.<br>
     * El escudo es el encargado de absorver todo el daño y solo cuando este se agota, comienza a decrementarse la vitalidad.
     * <b>Pre:</b> El daño pasado como parametro debe ser distinto de null.
     * <b>Post:</b> El Pokemon de Agua recibe cierta cantidad de daño. Existe la posibilidad de que muera.
     * @param daño : valor del impacto recibido.
     */
    public void recibeDaño(double daño){
        if(daño < this.escudo)
            this.escudo -= daño;
        else if(this.vitalidad > (daño-this.escudo)){
            this.vitalidad = daño - this.escudo;
            this.escudo = 0;
        }//else
            //Reveer que sucede si muere   
    }

    
    /**
     *Método que aplica el efecto de la carta de niebla al pokémon de agua.<br>
     *Reduce las estadísticas de combate un 7%. <br>
     */
    @Override
    public void hechizarNiebla() {
        this.fuerza*=0.93;
        this.escudo*=0.93;
        this.vitalidad*=0.93;
    }

    /**
     *Método que aplica el efecto de la carta de viento al pokémon de agua.<br>
     * Disminuye la fuerza un 50% del escudo actual.<br>
     * En caso de ser mayor o igual esa cantidad de escudo a la fuerza, la deja en 1.<br>
     */
    @Override
    public void hechizarViento() {
    	if (this.escudo*0.5 >= this.fuerza)
    		this.fuerza=1;
    	else
    		this.fuerza-= this.escudo*0.5;
    }

    /**
     *Método que aplica el efecto de la carta de tormenta al pokémon de agua.<br> 
     *Disminuye el escudo en un 20%.<br>
     */
    @Override
    public void hechizarTormenta() {
        this.escudo*=0.8;
    }
}
