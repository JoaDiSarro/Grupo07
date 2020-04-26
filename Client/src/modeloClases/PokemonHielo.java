package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Clase final que extiende de PokemonDecorator donde se decora a un Pokemon brindandole las funcionalidades pertenecientes al elemento Hielo.
 */
public class PokemonHielo extends PokemonDecorator {
    
    /**
     * Metodo constructor parametrizado<br>
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.<br>
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento hielo.<br>
     * @param pokemon de tipo Pokemon: Pokemon al que se lo decora con el elemento hielo.<br>
     */
    public PokemonHielo(Pokemon pokemon) {
    	super(pokemon,500,100,120);
    }
    
    /**
     * Metodo por el cual el Pokemon de Hielo recupera toda su fuerza inicial.<br>
     * <b>Post:</b> El pokemon setea su fuerza a 100 por defecto.
     */
    public void terminaCansancio(){
    	super.pokemon.fuerza = 100;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Agua realiza una recarga de su fuerza y vitalidad<br>
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 10%
     */
    public void recarga(){
    	super.pokemon.fuerza *= 1.1;
    	super.pokemon.vitalidad *= 1.1;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Hielo le provoca al adversario un da�o igual a su fuerza menos un 10%.<br>
     * Conserva la misma fuerza original.<br>
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.<br>
     * <b>Post:</b> El pokemon de Hielo le realiza un da�o al pokemon pasado como parametro.<br>
     * @param pokemon de tipo Pokemon: Pokemon al cual le realizaremos da�o.
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(super.pokemon.fuerza*0.90);    
    }
    
    /**
     * Metodo por el cual el Pokemon de Hielo recibe da�o.<br>
     * El escudo absorbe el 75% del da�o y la vitalidad el otro 25%.<br>
     * <b>Pre:</b> El da�o pasado como parametro debe ser distinto de null.<br>
     * <b>Post:</b> El Pokemon de Hielo recibe cierta cantidad de da�o. Existe la posibilidad de que muera.<br>
     * @param da�o de tipo double: Valor del impacto recibido.<br>
     */
    public void recibeDa�o(double da�o){
        double aux = 0;
        if(da�o*0.75 < super.pokemon.escudo)
        	super.pokemon.escudo -= da�o*0.75;
        else{
            aux = da�o*0.75 - escudo;
            super.pokemon.escudo = 0;
        }
        
        if((da�o*0.25 + aux) < super.pokemon.vitalidad)     
        	super.pokemon.vitalidad -= da�o*0.25 + aux;
        else
            super.pokemon.vitalidad = 0;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de niebla al pok�mon de hielo.<br>
     *Las estad�sticas de combate se reducen un 30% de la fuerza actual. <br>
     *Si el porcentaje de fuerza es mayor al escudo, �ste se vuelve 0.<br>
     *Si el porcentaje de fuerza es mayor o igual a la vitalidad, �sta se vuelve 1.<br>
     * <b>Post:</b> El Pokemon de Hielo se hechiza por la carta Niebla.
     */
    @Override
    public void hechizarNiebla() {
    	double auxFuerza = super.pokemon.fuerza*0.3;
    	
    	if (auxFuerza>super.pokemon.escudo)
    		super.pokemon.escudo=0;
    	else
    		super.pokemon.escudo-=auxFuerza;
    	if (auxFuerza>=super.pokemon.vitalidad)
    		super.pokemon.vitalidad=1;
    	else
    		super.pokemon.vitalidad-=auxFuerza;
    	super.pokemon.fuerza-=auxFuerza;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de viento al pok�mon de hielo.<br>
     *Reduce la fuerza un 10% de la vitalidad mas un 10 % del escudo actuales. <br>
     *En caso de ser menor o igual la fuerza que la suma de estos valores, se vuelve 1.<br>
     * <b>Post:</b> El Pokemon de Hielo se hechiza por la carta Viento.
     */
    @Override
    public void hechizarViento() {
    	double auxValor = (super.pokemon.vitalidad*0.1) + (super.pokemon.escudo*0.1);
    	
        if (auxValor >= super.pokemon.fuerza)
        	super.pokemon.fuerza=1;
        else
        	super.pokemon.fuerza-=auxValor;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon de hielo.<br>
     *Disminuye la vitalidad y el escudo actuales en un 15%.<br>
     * <b>Post:</b> El Pokemon de Hielo se hechiza por la carta Tormenta.
     */
    @Override
    public void hechizarTormenta() {
    	super.pokemon.vitalidad*=0.85;
    	super.pokemon.escudo*=0.85;
    }
    
    /**
     *Sobreescritura del metodo toString. Se utiliza para mostrar los atributos de un pok�mon de hielo.
     */
    @Override
	public String toString() {
		return super.toString()+" / "+" Elemento: Hielo";
	}
}
