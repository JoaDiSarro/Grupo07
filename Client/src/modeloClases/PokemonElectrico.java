package modeloClases;

public final class PokemonElectrico extends PokemonDecorator {
    public PokemonElectrico(Pokemon pokemon) {
        super.setPokemon(pokemon);
        this.vitalidad = 400;
        this.escudo = 70;
        this.fuerza = 200;
    }
    
    public void terminaCansancio(){
        this.fuerza = 200;
    }
    
    public void recarga(){
        this.vitalidad *=1.5;
        this.fuerza *=1.1;
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.fuerza);
        this.fuerza *= 0.9;
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
     *M�todo que aplica el efecto de la carta de niebla al pok�mon el�ctrico.<br>
     *Disminuye las estad�sticas actuales en un 15%.<br>
     */
    public void hechizarNiebla() {
    	this.escudo*=0.85;
    	this.fuerza*=0.85;
    	this.vitalidad*=0.85;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de viento al pok�mon el�ctrico.<br>
     *Reduce la fuerza un 20% del escudo actual.<br>
     *En caso de ser mayor o igual esa cantidad de escudo a la fuerza, la deja en 1.<br>
     */
    public void hechizarViento() {
    	if (this.escudo*0.2>=this.fuerza)
    		this.fuerza=1;
    	else
    		this.fuerza-= this.escudo*0.2;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon el�ctrico.<br>
     *Reduce la vitalidad en un 10%.<br>
     */
    public void hechizarTormenta() {
    	this.vitalidad*=0.9;
    }
}
