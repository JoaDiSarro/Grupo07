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
        pokemon.recibeDa�o(this.fuerza*1.4);
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
     *M�todo que aplica el efecto de la carta de niebla al pok�mon de tierra.<br>
     *Reduce las estad�sticas de combate un 20% de su vitalidad actual.<br>
     *Si el porcentaje de vitalidad es mayor al escudo, �ste se vuelve 0.<br>
     *Si el porcentaje de vitalidad es mayor o igual a la fuerza, �sta se vuelve 1.<br>
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
     *M�todo que aplica el efecto de la carta de viento al pok�mon de tierra.<br>
     *Reduce la fuerza actual un 20%.<br>
     */
    public void hechizarViento() {
        this.fuerza*=0.8;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon de tierra.<br>
     *Resta de la vitalidad la cantidad actual de escudo.<br>
     *Si el escudo es mayor o igual a la vitalidad, �sta se vuelve 1.<br>
     */
    public void hechizarTormenta() {
        if (this.escudo>=this.vitalidad)
        	this.vitalidad=1;
        else
        	this.vitalidad-=this.escudo;
    }
}
