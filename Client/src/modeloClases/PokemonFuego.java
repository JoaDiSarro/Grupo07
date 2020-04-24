package modeloClases;

public final class PokemonFuego extends PokemonDecorator {
    public PokemonFuego(Pokemon pokemon) {
        super.setPokemon(pokemon);
        this.vitalidad = 530;
        this.escudo = 200;
        this.fuerza = 80;
    }
    
    public void terminaCansancio(){
        this.fuerza = 80;    
    }
    
    public void recarga(){
        this.fuerza *= 1.1;
        this.vitalidad *= 1.1;    
    }
    
    public void golpeFinal(Pokemon pokemon){
        pokemon.recibeDa�o(this.fuerza*1.25);
        this.fuerza = 0;
    }

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
        //else
            //Reveer que sucede si muere
    }

  
    /**
     *M�todo que aplica el efecto de la carta de niebla al pok�mon de fuego.<br>
     *Disminuye las estad�sticas de combate un 10%.<br>
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
     */
    @Override
    public void hechizarViento() {
    	if (this.vitalidad*0.1>=this.fuerza)
    		this.fuerza=1;
    	else
    		this.fuerza-= this.vitalidad*0.1;
    }

    
    /**
     *M�todo que aplica el efecto de la carta de tormenta al pok�mon de fuego.<br>
     *Disminuye la vitalidad en un 40%. <br>
     */
    @Override
    public void hechizarTormenta() {
        this.vitalidad*=0.6;
    }
}
