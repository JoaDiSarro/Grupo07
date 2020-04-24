package modeloClases;

public final class PokemonAgua extends PokemonDecorator {
    
    public PokemonAgua(Pokemon pokemon) {
        super.setPokemon(pokemon);
        this.vitalidad = 500;
        this.escudo = 100;
        this.fuerza = 120;
    }
    
    
    public void terminaCansancio(){
        this.fuerza = 120;
    }
    
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.fuerza);
        this.fuerza *= 0.5;
    }
    
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
     *M�todo que aplica el efecto de la carta de niebla al pok�mon de agua.<br>
     *Reduce las estad�sticas de combate un 7%. <br>
     */
    public void hechizarNiebla() {
        this.fuerza*=0.93;
        this.escudo*=0.93;
        this.vitalidad*=0.93;
    }

    /**
     *M�todo que aplica el efecto de la carta de viento al pok�mon de agua.<br>
     * Disminuye la fuerza un 50% del escudo actual.<br>
     * En caso de ser mayor o igual esa cantidad de escudo a la fuerza, la deja en 1.<br>
     */
    public void hechizarViento() {
    	if (this.escudo*0.5 >= this.fuerza)
    		this.fuerza=1;
    	else
    		this.fuerza-= this.escudo*0.5;
    }

    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon de agua.<br> 
     *Disminuye el escudo en un 20%.<br>
     */
    public void hechizarTormenta() {
        this.escudo*=0.8;
    }
}
