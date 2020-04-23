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
    
    public void atacaNiebla(){
        //ACA HAGO ALGO
    }

    @Override
    public void hechizarNiebla() {
        // TODO Implement this method
    }

    @Override
    public void hechizarViento() {
        // TODO Implement this method
    }

    @Override
    public void hechizarTormenta() {
        // TODO Implement this method
    }
}
