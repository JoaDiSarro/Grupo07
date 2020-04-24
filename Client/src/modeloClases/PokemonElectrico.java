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
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento electrico.
     * @param pokemon : Pokemon al que se lo decora con el elemento electrico.
     */
    public PokemonElectrico(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 400;
        this.escudo = 70;
        this.fuerza = 200;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico recupera toda su fuerza inicial.
     * <b>Post:</b> El pokemon setea su fuerza a 200 por defecto.
     */
    public void terminaCansancio(){
        this.fuerza = 200;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico realiza una recarga de su fuerza y vitalidad.
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 50%.
     */
    public void recarga(){
        this.vitalidad *=1.5;
        this.fuerza *=1.1;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico le provoca a su adversario un daño igual a su fuerza.<br>
     * Luego su fuerza se reduce un 10%.
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> El pokemon electrico le realiza un daño al pokemon pasado como parametro. Luego disminuye su fuerza un 10%.
     * @param pokemon : pokemon al cual le realizaremos daño.
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza);
        this.fuerza *= 0.9;
    }
    
    /**
     * Metodo por el cual el Pokemon Electrico recibe daño.<br>
     * El escudo es el encargado de absorver todo el daño y solo cuando este se agota, comienza a decrementarse la vitalidad.
     * <b>Pre:</b> El daño pasado como parametro debe ser distinto de null.
     * <b>Post:</b> El Pokemon Electrico recibe cierta cantidad de daño. Existe la posibilidad de que muera.
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
}
