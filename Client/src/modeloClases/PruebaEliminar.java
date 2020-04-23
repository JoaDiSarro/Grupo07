package modeloClases;

public class PruebaEliminar {
    public PruebaEliminar() {
        super();
    }

    public static void main(String[] args) {
        PruebaEliminar pruebaEliminar = new PruebaEliminar();
        
        PokemonFactory factory = new PokemonFactory();

                Pokemon p1 = factory.creaPokemon("Pikachu", "Comun", "Agua");
                

                        System.out.println(p1.getClass()+" "+p1.getNombre()+" "+p1.getEscudo()+" "+p1.getFuerza());
    }
}
