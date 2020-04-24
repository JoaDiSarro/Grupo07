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
        pokemon.recibeDa�o(this.fuerza*0.90);    
    }
    
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
