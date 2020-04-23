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
