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
     * @param pokemon de tipo Pokemon: Pokemon al que se lo decora con el elemento fuego<br>
     */
    public PokemonFuego(Pokemon pokemon) {
    	super(pokemon,530,80,200);
    }
    
    /**
     * Metodo por el cual el Pokemon de Fuego recupera toda su fuerza inicial.<br>
     * <b>Post:</b> El pokemon setea su fuerza a 80 por defecto.
     */
    public void terminaCansancio(){
    	this.fuerza = 80;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Fuego realiza una recarga de su fuerza y vitalidad.<br>
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 10%.
     */
    public void recarga(){
    	this.fuerza *= 1.1;
    	this.vitalidad *= 1.1;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Fuego le provoca al adversario un da�o igual a su fuerza mas un 25%<br>
     * Luego la fuerza se agota por completo (queda en cero)<br>
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null<br>
     * <b>Post:</b> El pokemon de Fuego le realiza un da�o al pokemon pasado como parametro. Luego disminuye su fuerza a cero<br>
     * @param pokemon de tipo Pokemon: Pokemon al cual le realizaremos da�o<br>
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.fuerza*1.25);
        this.fuerza = 0;
    }

    /**
     * Metodo por el cual el Pokemon de Fuego recibe da�o.<br>
     * El escudo y la vitalidad absorben la mitad del da�o cada uno (decrement�ndose).<br>
     * <b>Pre:</b> El da�o pasado como parametro debe ser distinto de null<br>
     * <b>Post:</b> El Pokemon de Fuego recibe cierta cantidad de da�o. Existe la posibilidad de que muera<br>
     * @param da�o de tipo double: Valor del impacto recibido.
     */
    public void recibeDa�o(double da�o){
        double aux = 0;
        if(da�o*0.5 < this.escudo)
        	this.escudo -= da�o*0.5;
        else{
            aux = da�o*0.5 - escudo;
            this.escudo = 0;
        }
        if((da�o*0.5 + aux) < this.vitalidad)     
        	this.vitalidad -= da�o*0.5 + aux;
        else
            this.vitalidad = 0;
    }

  
    /**
     *M�todo que aplica el efecto de la carta de niebla al pok�mon de fuego.<br>
     *Disminuye las estad�sticas de combate un 10%.<br>
     * <b>Post:</b> El Pokemon de Fuego se hechiza por la carta Niebla.
     */
    @Override
    public void hechizarNiebla() {
    	this.escudo*=0.9;
    	this.fuerza*=0.9;
    	this.vitalidad*=0.9;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de viento al pok�mon de fuego.<br>
     *Reduce la fuerza un 10% de la vitalidad actual.<br>
     *En caso de ser mayor o igual la vitalidad actual al 10% de la fuerza, la fuerza se vuelve 1.<br>
     * <b>Post:</b> El Pokemon de Fuego se hechiza por la carta Viento.
     * 
     */
    @Override
    public void hechizarViento() {
    	if (this.vitalidad*0.1>=fuerza)
    		this.fuerza=1;
    	else
    		this.fuerza-= this.vitalidad*0.1;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon de fuego.<br>
     *Disminuye la vitalidad en un 40%. <br>
     * <b>Post:</b> El Pokemon de Fuego se hechiza por la carta Tormenta.
     */
    @Override
    public void hechizarTormenta() {
    	this.vitalidad*=0.6;
    }
    
    /**
     *Sobreescritura del metodo toString. Se utiliza para mostrar los atributos de un pok�mon de fuego.
     */
    @Override
	public String toString() {
		return super.toString()+" | Elemento: Fuego";
	}
}
