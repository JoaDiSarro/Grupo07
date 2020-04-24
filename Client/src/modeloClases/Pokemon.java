package modeloClases;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Esta clase contiene los atributos y metodos correspondientes a un Pokemon.<br>
 * Pokemon es una clase abstracta e implementa Cloneable.<br>
 */
public abstract class Pokemon implements Cloneable{

    protected String nombre;
    protected double vitalidad;
    protected double escudo;
    protected double fuerza;
    protected int experiencia;

    /**
     * Metodo Constructor por defecto
     */
    public Pokemon(){}

    /**
     * Metodo Constructor parametrizado.<br>
     * Por defecto su experiencia comienza con valor = 0<br>
     * <b>Pre:</b>El parametro nombre debe ser distinto de null.<br>
     * <b>Post:</b>Se genera un nuevo Pokemon.<br>
     * @param nombre : Nombre del Pokemon.
     */
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
    
    /**
     * Metodo para atacar a otro Pokemon. Se realiza una secuencia de acciones.<br>
     * <b>Pre:</b> El parametro pokemon debe ser distinto de null.<br>
     * <b>Post:</b> Se genera el ataque al pokemon pasado como parametro.<br>
     * @param pokemon : Pokemon al que se le hara daño.
     */
    public void ataca(Pokemon pokemon){
        golpeInicial(pokemon);
        recarga();
        golpeFinal(pokemon);
    }

    /**
     * Metodo donde se le realiza un golpe inicial al pokemon pasado como parametro. Una vez realizado el daño, el Pokemon actual se cansa disminuyendo asi su fuerza en un 50%.
     * <b>Pre:</b> El parametro pokemon debe ser distinto de null.<br>
     * <b>Post:</b> Se le realiza un golpe al objeto pasado como parametro, y el pokemon actual disminuye su fuerza.<br>
     * @param pokemon : Pokemon al que se le hara daño.
     */
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
