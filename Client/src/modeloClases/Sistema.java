package modeloClases;

public class Sistema {
    static Sistema instance;
    
    private Sistema() { 
    }
    
    public static Sistema getInstance(){
        if(instance == null)
            instance = new Sistema();
        return instance;
    }
    
    //FALTA PASARLE LA CANTIDAD DE CARTAS DISPONIBLES, AGREGAR A LA VISTA????
    public void nuevoEntrenador(String nombre){
        System.out.println(nombre);
        Entrenador entrenador = new Entrenador(nombre,0);
    }
    
}
