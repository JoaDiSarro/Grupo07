package modeloClases;

public class PokemonHielo extends PokemonDecorator {
    public PokemonHielo(Pokemon pokemon) {
        super.setPokemon(pokemon);
        this.vitalidad = 500;
        this.escudo = 120;
        this.fuerza = 100;
    }
    
    public void terminaCansancio(){
        this.fuerza = 100;    
    }
    
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;    
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza*0.90);    
    }
    
    public void recibeDaño(double daño){
        double aux = 0;
        if(daño*0.75 < this.escudo)
            this.escudo -= daño*0.75;
        else{
            aux = daño*0.75 - escudo;
            this.escudo = 0;
        }
        
        if((daño*0.25 + aux) < this.vitalidad)     
            this.vitalidad -= daño*0.25 + aux;
        //else
            //Reveer que sucede si muere    
    }

    
    /**
     *Método que aplica el efecto de la carta de niebla al pokémon de hielo.<br>
     *Las estadísticas de combate se reducen un 30% de la fuerza actual. <br>
     *Si el porcentaje de fuerza es mayor al escudo, éste se vuelve 0.<br>
     *Si el porcentaje de fuerza es mayor o igual a la vitalidad, ésta se vuelve 1.<br>
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
     *Método que aplica el efecto de la carta de viento al pokémon de hielo.<br>
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
     *Método que aplica el efecto de la carta de tormenta al pokémon de hielo.<br>
     *Disminuye la vitalidad y el escudo actuales en un 15%.<br>
     */
    @Override
    public void hechizarTormenta() {
        this.vitalidad*=0.85;
        this.escudo*=0.85;
    }
}
