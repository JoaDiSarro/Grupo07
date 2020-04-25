package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase final que extiende de PokemonDecorator donde se decora a un Pokemon brindandole las funcionalidades pertenecientes al elemento Fuego.
 */
public final class PokemonFuego extends PokemonDecorator {
    
    /**
     * Metodo constructor parametrizado<br>
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.<br>
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null<br>
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento fuego.<br>
     * @param pokemon : Pokemon al que se lo decora con el elemento fuego<br>
     */
    public PokemonFuego(Pokemon pokemon) {
    	super(pokemon,530,80,200);
    }
    
    
    /**
     * Metodo por el cual el Pokemon de Fuego recupera toda su fuerza inicial.<br>
     * <b>Post:</b> El pokemon setea su fuerza a 80 por defecto.
     */
    public void terminaCansancio(){
    	super.pokemon.fuerza = 80;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Fuego realiza una recarga de su fuerza y vitalidad.<br>
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 10%.
     */
    public void recarga(){
    	super.pokemon.fuerza *= 1.1;
    	super.pokemon.vitalidad *= 1.1;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Fuego le provoca al adversario un daño igual a su fuerza mas un 25%<br>
     * Luego la fuerza se agota por completo (queda en cero)<br>
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null<br>
     * <b>Post:</b> El pokemon de Fuego le realiza un daño al pokemon pasado como parametro. Luego disminuye su fuerza a cero<br>
     * @param pokemon : pokemon al cual le realizaremos daño<br>
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(super.pokemon.fuerza*1.25);
        super.pokemon.fuerza = 0;
    }

    /**
     * Metodo por el cual el Pokemon de Fuego recibe daño.<br>
     * El escudo y la vitalidad absorben la mitad del daño cada uno (decrementándose).<br>
     * <b>Pre:</b> El daño pasado como parametro debe ser distinto de null<br>
     * <b>Post:</b> El Pokemon de Fuego recibe cierta cantidad de daño. Existe la posibilidad de que muera<br>
     * @param daño : valor del impacto recibido.
     */
    public void recibeDaño(double daño){
        double aux = 0;
        if(daño*0.5 < super.pokemon.escudo)
        	super.pokemon.escudo -= daño*0.5;
        else{
            aux = daño*0.5 - escudo;
            super.pokemon.escudo = 0;
        }
        if((daño*0.5 + aux) < super.pokemon.vitalidad)     
        	super.pokemon.vitalidad -= daño*0.5 + aux;
        //else
            //Reveer que sucede si muere
    }

  
    /**
     *Método que aplica el efecto de la carta de niebla al pokémon de fuego.<br>
     *Disminuye las estadísticas de combate un 10%.<br>
     */
    @Override
    public void hechizarNiebla() {
    	super.pokemon.escudo*=0.9;
    	super.pokemon.fuerza*=0.9;
    	super.pokemon.vitalidad*=0.9;
    }

    
    /**
     *Método que aplica el efecto de la carta de viento al pokémon de fuego.<br>
     *Reduce la fuerza un 10% de la vitalidad actual.<br>
     *En caso de ser mayor o igual la vitalidad actual al 10% de la fuerza, la fuerza se vuelve 1.<br>
     */
    @Override
    public void hechizarViento() {
    	if (super.pokemon.vitalidad*0.1>=super.pokemon.fuerza)
    		super.pokemon.fuerza=1;
    	else
    		super.pokemon.fuerza-= super.pokemon.vitalidad*0.1;
    }

    
    /**
     *Método que aplica el efecto de la carta de tormenta al pokémon de fuego.<br>
     *Disminuye la vitalidad en un 40%. <br>
     */
    @Override
    public void hechizarTormenta() {
    	super.pokemon.vitalidad*=0.6;
    }
    
    @Override
	public String toString() {
		return super.toString()+" / "+" Elemento: Fuego";
	}
}
