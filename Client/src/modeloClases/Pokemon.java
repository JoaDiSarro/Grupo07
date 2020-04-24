package modeloClases;
public abstract class Pokemon implements IHechizable{
    protected String nombre;
    protected double vitalidad;
    protected double escudo;
    protected double fuerza;
    protected int experiencia;
    
    public Pokemon(){}
    
    public Pokemon(String nombre){
        this.nombre = nombre;
        this.experiencia = 0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getVitalidad() {
        return vitalidad;
    }

    public double getEscudo() {
        return escudo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public double getFuerza() {
        return fuerza;
    }
    
    public abstract void hechizarNiebla();
    
    public abstract void hechizarTormenta();

    public abstract void hechizarViento();
    
    public void ataca(Pokemon pokemon){
        golpeInicial(pokemon);
        recarga();
        golpeFinal(pokemon);
    }
    
    public void golpeInicial(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza);
        //se cansa
        this.fuerza *= 0.5;
    }
    
    //estos metodos son para poder utilizar el gancho con cada elemento
    
    public abstract void terminaCansancio();
    
    public abstract  void recarga();
    
    public abstract void golpeFinal(Pokemon pokemon);
    
    //Evaluar que sucede si el pokemon muere
    
    public abstract void recibeDaño(double daño);
    
   
    

}
