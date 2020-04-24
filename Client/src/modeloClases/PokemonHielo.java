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
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento hielo.
     * @param pokemon : Pokemon al que se lo decora con el elemento hielo.
     */
    public PokemonHielo(Pokemon pokemon) {
                super(pokemon);;
        this.vitalidad = 500;
        this.escudo = 120;
        this.fuerza = 100;
    }
    
    /**
     * Metodo por el cual el Pokemon de Hielo recupera toda su fuerza inicial.
     * <b>Post:</b> El pokemon setea su fuerza a 100 por defecto.
     */
    public void terminaCansancio(){
        this.fuerza = 100;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Agua realiza una recarga de su fuerza y vitalidad
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 10%
     */
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Hielo le provoca al adversario un da�o igual a su fuerza menos un 10%.<br>
     * Conserva la misma fuerza original.
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null.
     * <b>Post:</b> El pokemon de Hielo le realiza un da�o al pokemon pasado como parametro.
     * @param pokemon : pokemon al cual le realizaremos da�o.
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.fuerza*0.90);    
    }
    
    /**
     * Metodo por el cual el Pokemon de Hielo recibe da�o.<br>
     * El escudo absorbe el 75% del da�o y la vitalidad el otro 25%.
     * <b>Pre:</b> El da�o pasado como parametro debe ser distinto de null.
     * <b>Post:</b> El Pokemon de Hielo recibe cierta cantidad de da�o. Existe la posibilidad de que muera.
     * @param da�o : valor del impacto recibido.
     */
    public void recibeDa�o(double da�o){
        double aux = 0;
        if(da�o*0.75 < this.escudo)
            this.escudo -= da�o*0.75;
        else{
            aux = da�o*0.75 - escudo;
            this.escudo = 0;
        }
        
        if((da�o*0.25 + aux) < this.vitalidad)     
            this.vitalidad -= da�o*0.25 + aux;
        //else
            //Reveer que sucede si muere    
    }

    
    /**
     *M�todo que aplica el efecto de la carta de niebla al pok�mon de hielo.<br>
     *Las estad�sticas de combate se reducen un 30% de la fuerza actual. <br>
     *Si el porcentaje de fuerza es mayor al escudo, �ste se vuelve 0.<br>
     *Si el porcentaje de fuerza es mayor o igual a la vitalidad, �sta se vuelve 1.<br>
     */
    @Override
    public void hechizarNiebla() {
    	double auxFuerza = this.fuerza*0.3;
    	
    	if (auxFuerza>this.escudo)
    		this.escudo=0;
    	else
    		this.escudo-=auxFuerza;
    	if (auxFuerza>=this.vitalidad)
    		this.vitalidad=1;
    	else
    		this.vitalidad-=auxFuerza;
    	this.fuerza-=auxFuerza;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de viento al pok�mon de hielo.<br>
     *Reduce la fuerza un 10% de la vitalidad mas un 10 % del escudo actuales. <br>
     *En caso de ser menor o igual la fuerza que la suma de estos valores, se vuelve 1.<br>
     */
    @Override
    public void hechizarViento() {
    	double auxValor = (this.vitalidad*0.1) + (this.escudo*0.1);
    	
        if (auxValor >= this.fuerza)
        	this.fuerza=1;
        else
        	this.fuerza-=auxValor;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon de hielo.<br>
     *Disminuye la vitalidad y el escudo actuales en un 15%.<br>
     */
    @Override
    public void hechizarTormenta() {
        this.vitalidad*=0.85;
        this.escudo*=0.85;
    }
}
