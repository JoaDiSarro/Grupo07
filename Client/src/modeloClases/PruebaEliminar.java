package modeloClases;

public class PruebaEliminar {

	 //En esta prueba se comprueba que todos los pokemones tengan sus respectivos atributos, tipos y elementos.
	
    public static void main(String[] args) {
        
        PokemonFactory factory = new PokemonFactory();

        Pokemon p1 = factory.creaPokemon("Pikachu", "Comun", "Agua");
        Pokemon p1clon = null;
        
        Pokemon p2 = factory.creaPokemon("Pikacha", "Legendario", "Agua");
        Pokemon p2clon = null;
        
        Pokemon p3 = factory.creaPokemon("Pikachin", "Comun", "Tierra");
        Pokemon p3clon = null;
        
        Pokemon p4 = factory.creaPokemon("Pikachon", "Legendario", "Tierra");
        Pokemon p4clon = null;
        
        Pokemon p5 = factory.creaPokemon("Pikachun", "Comun", "Fuego");
        Pokemon p5clon = null;
        
        Pokemon p6 = factory.creaPokemon("Pikachi", "Legendario", "Fuego");
        Pokemon p6clon = null;
        
        Pokemon p7 = factory.creaPokemon("Pikache", "Comun", "Electrico");
        Pokemon p7clon = null;
        
        Pokemon p8 = factory.creaPokemon("Pikachen", "Legendario", "Electrico");
        Pokemon p8clon = null;
        
        Pokemon p9 = factory.creaPokemon("Pikapika", "Comun", "Hielo");
        Pokemon p9clon = null;
        
        Pokemon p10 = factory.creaPokemon("Pik", "Legendario", "Hielo");
        Pokemon p10clon = null;
        
        Pokemon p11 = factory.creaPokemon("pikipaka", "Comun", "Hielo Recargado");
        Pokemon p11clon = null;
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
        System.out.println(p5.toString());
        System.out.println(p6.toString());
        System.out.println(p7.toString());
        System.out.println(p8.toString());
        System.out.println(p9.toString());
        System.out.println(p10.toString());
        System.out.println(p11.toString());
        
        try {
			p1clon=(Pokemon) p1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p2clon=(Pokemon) p2.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p3clon=(Pokemon) p3.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p4clon=(Pokemon) p4.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p5clon=(Pokemon) p5.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
        try {
			p6clon=(Pokemon) p6.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p7clon=(Pokemon) p7.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
        try {
			p8clon=(Pokemon) p8.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p9clon=(Pokemon) p9.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p10clon=(Pokemon) p10.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        try {
			p11clon=(Pokemon) p11.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
        
        //Se comentan los métodos que no se pueden clonar, es decir, pokemones legendarios
        System.out.println(p1clon.toString());
        //System.out.println(p2clon.toString());
        System.out.println(p3clon.toString());
        //System.out.println(p4clon.toString());
        System.out.println(p5clon.toString());
        //System.out.println(p6clon.toString());
        System.out.println(p7clon.toString());
        //System.out.println(p8clon.toString());
        System.out.println(p9clon.toString());
        //System.out.println(p10clon.toString());
        System.out.println(p11clon.toString());
        
    }
}
