package modeloClases;

public final class PokemonTierra extends PokemonDecorator {
    public PokemonTierra(Pokemon pokemon) {
        super.setPokemon(pokemon);
        this.vitalidad = 600;
        this.escudo = 120;
        this.fuerza = 40;
    }
    
    public void terminaCansancio(){
        this.fuerza = 40;    
    }
    
    public void recarga(){
        this.fuerza = 40;    
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza*1.4);
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
     *Método que aplica el efecto de la carta de niebla al pokémon de tierra.<br>
     *Reduce las estadísticas de combate un 20% de su vitalidad actual.<br>
     *Si el porcentaje de vitalidad es mayor al escudo, éste se vuelve 0.<br>
     *Si el porcentaje de vitalidad es mayor o igual a la fuerza, ésta se vuelve 1.<br>
     */
    public void hechizarNiebla() {
    	double auxVitalidad = this.vitalidad*0.2;
    	
        if (auxVitalidad>=this.fuerza)
        	this.fuerza=1;
        else
        	this.fuerza-=auxVitalidad;
        if (auxVitalidad>this.escudo)
        	this.escudo=0;
        else
        	this.escudo-=auxVitalidad;
        this.vitalidad-=auxVitalidad;
    }

    
    /**
     *Método que aplica el efecto de la carta de viento al pokémon de tierra.<br>
     *Reduce la fuerza actual un 20%.<br>
     */
    public void hechizarViento() {
        this.fuerza*=0.8;
    }

    
    /**
     *Método que aplica el efecto de la carta de tormenta al pokémon de tierra.<br>
     *Resta de la vitalidad la cantidad actual de escudo.<br>
     *Si el escudo es mayor o igual a la vitalidad, ésta se vuelve 1.<br>
     */
    public void hechizarTormenta() {
        if (this.escudo>=this.vitalidad)
        	this.vitalidad=1;
        else
        	this.vitalidad-=this.escudo;
    }
}
