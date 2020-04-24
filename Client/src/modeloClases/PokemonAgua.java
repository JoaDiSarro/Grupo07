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
        pokemon.recibeDaño(this.fuerza);
        this.fuerza *= 0.5;
    }
    
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
    public void hechizarTormenta() {
        this.escudo*=0.8;
    }
}
