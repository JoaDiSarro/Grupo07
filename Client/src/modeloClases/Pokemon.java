package modeloClases;

import interfaces.IClasificable;

import interfaces.IHechizable;

import java.util.Random;

/**
 * @author DiSarro,Joaquina.
 * @version 1.0
 * <br>
 * Esta clase contiene los atributos y metodos correspondientes a un Pokemon.<br>
 * Pokemon es una clase abstracta e implementa las interfaces Cloneable, IHechizable,IClasificable.<br>
 */

public abstract class Pokemon implements Cloneable,IHechizable, IClasificable{

    protected String nombre;
    protected double vitalidad;
    protected double escudo;
    protected double fuerza;
    protected int experiencia=0;
    protected int clasificacionActual=1;

    /**
     * Metodo Constructor de un Pokémon por defecto
     */
    public Pokemon(){}

    /**
     * Metodo Constructor parametrizado.<br>
     * Por defecto su experiencia comienza con valor = 0<br>
     * <b>Pre:</b>El parametro nombre debe ser distinto de null.<br>
     * <b>Post:</b>Se genera un nuevo Pokemon.<br>
     * @param nombre  de tipo String: Nombre del Pokemon.<br>
     */

    /**
     * Metodo Constructor parametrizado.<br>
     * Por defecto su experiencia comienza con valor = 0 y su clasificacionActual = 1.<br>
     * <b>Pre:</b> El parametro nombre debe ser distinto de null. Ademas, vitalidad, fuerza y escudo deben ser distinto de null y mayores a 0.<br>
     * <b>Post:</b>Se genera un nuevo Pokemon.<br>
     * @param nombre  de tipo String: hace referencia al nombre del Pokemon a crear.<br>
     * @param vitalidad  de tipo double: hace referencia a la vitalidad del Pokemon a crear.<br>
     * @param fuerza  de tipo double: hace referencia a la fuerza del Pokemon a crear.<br>
     * @param escudo  de tipo double: hace referencia al escudo del Pokemon a crear.<br>
     */
    public Pokemon(String nombre, double vitalidad, double fuerza, double escudo){
        this.nombre = nombre;
        this.vitalidad = vitalidad;
        this.fuerza = fuerza;
        this.escudo = escudo;
    }

    /**
     * Constructor parametrizado
     *  <b>Pre:</b> El parametro nombre debe ser distinto de null.<br>
     *  <b>Post:</b>Se genera un nuevo Pokemon.<br>
     * @param nombre  de tipo String: hace referencia al nombre del Pokemon a crear.<br>
     */
    public Pokemon(String nombre) {
        this.nombre = nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEscudo(double escudo) {
        this.escudo = escudo;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setClasificacionActual(int clasificacionActual) {
        this.clasificacionActual = clasificacionActual;
    }

    public double getFuerza() {
        return fuerza;
    }
    
    public int getClasificacionActual() {
		return clasificacionActual;
	}

	public void setVitalidad(double vitalidad) {
		this.vitalidad = vitalidad;
	}

	public void setFuerza(double fuerza) {
		this.fuerza = fuerza;
	}

	/**
     *Método encargado de clonar un pokémon.<br>
     *@return Retorna un clon del pokémon.<br>
     */
    @Override
	public Object clone() throws CloneNotSupportedException {
    		return super.clone();
	}
    
    
    /**
     *Método encargado de sumar experiencia a un pokémon cuando gana una batalla.<br>
     * <b>Post:</b> Se aumenta la experiencia del Pokemon en 3 puntos.<br>
     */
    public void ganaBatalla() {
    	this.experiencia+=3;
    }
    
    /**
     * Método encargado de sumar experiencia a un pokémon cuando pierde una batalla.<br>
     * <b>Post:</b> Se aumenta la experiencia del Pokemon en 1 puntos.<br>
     */
    public void pierdeBatalla() {
    	this.experiencia+=1;
    }
    
    /**
     *Método encargado de clasificar pokemones acorde a su experiencia.<br>
     *<b> Post: </b> El pokémon puede subir de nivel, incrementando sus atributos.<br>
     */
    public void actualizaClasificacion() {
    	if (this.clasificacionActual==1) {
    		if (this.experiencia > 3) {
    			this.clasificacionActual = 2;
    			this.escudo*=1.3;
    			this.vitalidad*=1.3;
    			this.fuerza*=1.3;
    		}
    	}
    	else
    		if (this.clasificacionActual==2){
    			if (this.experiencia > 6) {
    				this.clasificacionActual = 3;
    				this.escudo*=2;
    				this.fuerza*=2;
    				this.vitalidad*=2;
    			}
    		}
    }
    
    /**
     * Metodo para atacar a otro Pokemon. Se realiza una secuencia de acciones.<br>
     * <b>Pre:</b> El parametro pokemon debe ser distinto de null.<br>
     * <b>Post:</b> Se genera el ataque al pokemon pasado como parametro.<br>
     * @param pokemon  de tipo Pokemon : Pokemon al que se le hara daño.<br>
     */
    public void ataca(Pokemon pokemon){
        System.out.println("\n-->"+this.nombre+" realiza su secuencia de ataque..\n");
        golpeInicial(pokemon);
        recarga();
        golpeFinal(pokemon);
    }

    /**
     * Metodo donde se le realiza un golpe inicial al pokemon pasado como parametro. Una vez realizado el daño, el Pokemon actual se cansa disminuyendo asi su fuerza en un 50%.
     * <b>Pre:</b> El parametro pokemon debe ser distinto de null.<br>
     * <b>Post:</b> Se le realiza un golpe al objeto pasado como parametro, y el pokemon actual disminuye su fuerza.<br>
     * @param pokemon de tipo Pokemon: Pokemon al que se le hara daño.<br>
     */
    public void golpeInicial(Pokemon pokemon){
        pokemon.recibeDaño(this.fuerza);
        this.fuerza *= 0.5;
    }
    
    public abstract void hechizarNiebla();
    
    public abstract void hechizarTormenta();

    public abstract void hechizarViento();

    public abstract void terminaCansancio();
    
    public abstract  void recarga();
    
    public abstract void golpeFinal(Pokemon pokemon);

    public abstract void recibeDaño(double daño);

    /**
     * Metodo que se encarga de comprar el estado entre dos Pokemones.<br>
     * Decide cual de los dos pokemones tiene un Mejor estado.<br>
     * @param pokemon  de tipo Pokemon: pokemon con el cual compararemos a nuestro Pokemon.<br>
     * @return  devuelve un int, el cual puede ser 1 si nuestro pokemon es mejor que el pasado como parametro, o 0 si es peor.<br>
     */
    public int comparaEstado(Pokemon pokemon){
    	int auxRetorno;
        double estadoPropio = (this.vitalidad+this.escudo)*this.fuerza;
        double estadoAjeno = (pokemon.vitalidad+pokemon.escudo)*pokemon.fuerza;
        
        if(estadoPropio>estadoAjeno)
            auxRetorno = 1;
        else
            if (estadoPropio<estadoAjeno)
            	auxRetorno = 0;
            else
            	if (this.experiencia>pokemon.getExperiencia())
            		auxRetorno = 1;
            	else
            		if (this.experiencia<pokemon.getExperiencia())
            			auxRetorno = 0;
            		else
            			auxRetorno = new Random().nextInt(2);
        
        return auxRetorno;
    }
    

}
