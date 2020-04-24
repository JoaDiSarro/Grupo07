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
     * Por defecto los valores de vitalidad, escudo y fuerza son establecidos.
     * <b>Pre:</b> El pokemon pasado por parametro debe ser distinto de null
     * <b>Post:</b> Se le agrega al pokemon la funcionalidad del elemento fuego.
     * @param pokemon : Pokemon al que se lo decora con el elemento fuego
     */
    public PokemonFuego(Pokemon pokemon) {
        super(pokemon);
        this.vitalidad = 530;
        this.escudo = 200;
        this.fuerza = 80;
    }
    
    
    /**
     * Metodo por el cual el Pokemon de Fuego recupera toda su fuerza inicial.
     * <b>Post:</b> El pokemon setea su fuerza a 80 por defecto.
     */
    public void terminaCansancio(){
        this.fuerza = 80;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Fuego realiza una recarga de su fuerza y vitalidad
     * <b>Post:</b> Su fuerza aumenta un 10%. Su vitalidad aumenta un 10%
     */
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;    
    }
    
    /**
     * Metodo por el cual el Pokemon de Fuego le provoca al adversario un daño igual a su fuerza mas un 25%<br>
     * Luego la fuerza se agota por completo (queda en cero)
     * <b>Pre:</b> el pokemon pasado por parametro debe ser distinto de null
     * <b>Post:</b> El pokemon de Fuego le realiza un daño al pokemon pasado como parametro. Luego disminuye su fuerza a cero
     * @param pokemon : pokemon al cual le realizaremos daño
     */
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza*1.25);
        this.fuerza = 0;
    }

    /**
     * Metodo por el cual el Pokemon de Fuego recibe daño.<br>
     * El escudo y la vitalidad absorben la mitad del daño cada uno (decrementándose).
     * <b>Pre:</b> El daño pasado como parametro debe ser distinto de null
     * <b>Post:</b> El Pokemon de Fuego recibe cierta cantidad de daño. Existe la posibilidad de que muera
     * @param daño : valor del impacto recibido.
     */
    public void recibeDaño(double daño){
        double aux = 0;
        if(daño*0.5 < this.escudo)
            this.escudo -= daño*0.5;
        else{
            aux = daño*0.5 - escudo;
            this.escudo = 0;
        }
        if((daño*0.5 + aux) < this.vitalidad)     
            this.vitalidad -= daño*0.5 + aux;
        //else
            //Reveer que sucede si muere
    }
}
